package com.baloise.cc2023diabetes.service.food;

import com.baloise.cc2023.diabetes.jooq.tables.daos.RecipeDao;
import com.baloise.cc2023.diabetes.jooq.tables.pojos.Recipe;
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

import static com.baloise.cc2023.diabetes.jooq.Tables.*;
import static org.jooq.impl.DSL.*;

@Service
@AllArgsConstructor
public class RecipeService {

    private final DSLContext jooq;

    public List<Recipe> all() {
        return new RecipeDao(jooq.configuration())
                .findAll();
    }

    public boolean userOwns(UUID userId, Integer recipeId) {
        return Optional.ofNullable(new RecipeDao(jooq.configuration())
                        .findById(recipeId))
                .map(Recipe::getUserId)
                .map(recipeUser -> recipeUser.equals(userId))
                .orElse(false);
    }

    public RecipeModel createRecipe(UUID userId, CreateRecipeModel recipe) {
        Integer recipeId = jooq.transactionResult(ctx -> {
            Integer id = Objects.requireNonNull(ctx.dsl().insertInto(RECIPE, RECIPE.USER_ID, RECIPE.TITLE)
                    .values(userId, recipe.title())
                    .returningResult(RECIPE.ID)
                    .fetchOne()).getValue(RECIPE.ID);

            recipe.ingredients().forEach(food -> ctx.dsl().insertInto(RECIPE_INCREEDIENTS, RECIPE_INCREEDIENTS.RECIPE,
                            RECIPE_INCREEDIENTS.FOOD, RECIPE_INCREEDIENTS.AMOUNT)
                    .values(id, food.foodId(), food.amount())
                    .execute());
            return id;
        });
        return getRecipe(userId, recipeId);
    }

    public List<RecipeModel> getAll(UUID userId) {
        return getRecipes(userId, Collections.emptyList());
    }

    private List<RecipeModel> getRecipes(UUID userId, List<Condition> recipeConditions) {
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
                                        RECIPE_INCREEDIENTS.AMOUNT
                                )
                                        .from(RECIPE_INCREEDIENTS)
                                    .join(FOOD).on(RECIPE_INCREEDIENTS.FOOD.eq(FOOD.ID))
//                                        .from(RECIPE_INCREEDIENTS, FOOD)
                                        .where(RECIPE_INCREEDIENTS.FOOD.eq(FOOD.ID)
                                                .and(RECIPE_INCREEDIENTS.RECIPE.eq(RECIPE.ID)
                                                        .and(RECIPE.USER_ID.eq(userId))))
                        ).convertFrom(p -> p.map(Records.mapping(RecipeIngredientModel::new))))
                .from(RECIPE)
                .where(recipeConditions.isEmpty() ? List.of(trueCondition()) : recipeConditions)
                .fetchInto(RecipeModel.class);
    }

    public List<RecipeModel> searchRecipes(UUID userId, String search) {
        return getRecipes(userId, List.of(RECIPE.TITLE.like("%" + search + "%")));
    }

    public RecipeModel getRecipe(UUID userId, Integer id) {
        List<RecipeModel> recipeModel = getRecipes(userId, List.of(RECIPE.ID.eq(id)));
        return recipeModel.isEmpty() ? null : recipeModel.get(0);
    }
}
