package com.baloise.cc2023diabetes.service.food;

import com.baloise.cc2023diabetes.generated.tables.daos.RecipeDao;
import com.baloise.cc2023diabetes.generated.tables.pojos.Recipe;
import com.baloise.cc2023diabetes.service.food.model.CreateRecipeModel;
import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import com.baloise.cc2023diabetes.service.food.model.RecipeIngredientModel;
import com.baloise.cc2023diabetes.service.food.model.RecipeModel;
import lombok.AllArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Records;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.baloise.cc2023diabetes.generated.Tables.RECIPE;
import static com.baloise.cc2023diabetes.generated.Tables.RECIPE_INGREDIENTS;
import static com.baloise.cc2023diabetes.generated.tables.Food.FOOD;
import static org.jooq.impl.DSL.*;

@Service
@AllArgsConstructor
public class RecipeService {

    private final DSLContext jooq;

    public List<Recipe> all() {
        return new RecipeDao(jooq.configuration())
                .findAll();
    }

    public boolean userOwns(UUID userId, Long recipeId) {
        return Optional.ofNullable(new RecipeDao(jooq.configuration())
                        .findById(recipeId))
                .map(Recipe::getUserId)
                .map(recipeUser -> recipeUser.equals(userId))
                .orElse(false);
    }

    public RecipeModel createRecipe(UUID userId, CreateRecipeModel recipe) {
        Long recipeId = jooq.transactionResult(ctx -> {
            Long id = Objects.requireNonNull(ctx.dsl().insertInto(RECIPE, RECIPE.USER_ID, RECIPE.TITLE)
                    .values(userId, recipe.title())
                    .returningResult(RECIPE.ID)
                    .fetchOne()).getValue(RECIPE.ID);

            recipe.ingredients().forEach(food -> ctx.dsl().insertInto(RECIPE_INGREDIENTS, RECIPE_INGREDIENTS.RECIPE,
                            RECIPE_INGREDIENTS.FOOD, RECIPE_INGREDIENTS.AMOUNT)
                    .values(id, food.foodId(), food.amount())
                    .execute());
            return id;
        });
        return getRecipe(userId, recipeId);
    }

    public List<RecipeModel> getAll(UUID userId) {
        return getRecipes(userId, Collections.emptyList());
    }

    List<RecipeModel> getRecipes(UUID userId, List<Condition> recipeConditions) {
        return jooq.select(
                        RECIPE.ID,
                        RECIPE.TITLE,
                        multiset(
                                select(
                                        row(FOOD.ID,
                                                FOOD.TITLE,
                                                FOOD.UNIT,
                                                FOOD.CARBOHYDRATE_AVAILABLE,
                                                FOOD.CARBOHYDRATE_AVAILABLE.div(10.0),
                                                FOOD.SUGAR
                                        ).mapping(FoodModel::new),
                                        RECIPE_INGREDIENTS.AMOUNT
                                )
                                        .from(RECIPE_INGREDIENTS)
                                        .join(FOOD).on(RECIPE_INGREDIENTS.FOOD.eq(FOOD.ID))
                                        .join(RECIPE).on(RECIPE.ID.eq(RECIPE_INGREDIENTS.RECIPE))
                                        .where(RECIPE.USER_ID.eq(userId))
                        ).convertFrom(p -> p.map(Records.mapping(RecipeIngredientModel::new))))
                .from(RECIPE)
                .where(recipeConditions.isEmpty() ? List.of(trueCondition()) : recipeConditions)
                .fetchInto(RecipeModel.class);
    }

    public List<RecipeModel> searchRecipes(UUID userId, String search) {
        return getRecipes(userId, List.of(RECIPE.TITLE.like("%" + search + "%")));
    }

    public RecipeModel getRecipe(UUID userId, Long id) {
        List<RecipeModel> recipeModel = getRecipes(userId, List.of(RECIPE.ID.eq(id)));
        return recipeModel.isEmpty() ? null : recipeModel.get(0);
    }
}
