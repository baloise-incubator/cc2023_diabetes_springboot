package com.baloise.cc2023diabetes.service.food;

import com.baloise.cc2023.diabetes.jooq.tables.daos.RecipeDao;
import com.baloise.cc2023.diabetes.jooq.tables.daos.RecipeIncreedientsDao;
import com.baloise.cc2023.diabetes.jooq.tables.pojos.Recipe;
import com.baloise.cc2023.diabetes.jooq.tables.pojos.RecipeIncreedients;
import com.baloise.cc2023diabetes.service.food.model.CreateRecipeModel;
import com.baloise.cc2023diabetes.service.food.model.RecipeIngredientModel;
import com.baloise.cc2023diabetes.service.food.model.RecipeModel;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static com.baloise.cc2023.diabetes.jooq.Tables.RECIPE;
import static com.baloise.cc2023.diabetes.jooq.Tables.RECIPE_INCREEDIENTS;

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

    public List<RecipeIncreedients> ingredientsFor(Integer id) {
        return new RecipeIncreedientsDao(jooq.configuration())
                .fetchByFood(id)
                .stream().toList();
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
        return getRecipe(recipeId);
    }

    public List<RecipeModel> getAll(UUID userId) {
        return jooq.select(RECIPE.ID).from(RECIPE).where(RECIPE.USER_ID.eq(userId)).stream()
                .map(r -> r.get(RECIPE.ID))
                .map(this::getRecipe)
                .toList();
    }

    public List<RecipeModel> searchRecipes(UUID userId, String search) {
        return jooq.select(RECIPE.ID).from(RECIPE).where(RECIPE.USER_ID.eq(userId).and(RECIPE.TITLE.like("%" + search + "%")))
                .stream()
                .map(r -> r.get(RECIPE.ID))
                .map(this::getRecipe)
                .toList();
    }

    public RecipeModel getRecipe(Integer id) {
        Recipe recipe = new RecipeDao(jooq.configuration()).findById(id);
        assert recipe != null;
        List<RecipeIncreedients> recipeIncreedients = new RecipeIncreedientsDao(jooq.configuration()).fetchByRecipe(id);
        return new RecipeModel(
                id,
                recipe.getTitle(),
                recipeIncreedients.stream().map(i -> new RecipeIngredientModel(i.getFood(), i.getAmount())).toList()
        );
    }
}
