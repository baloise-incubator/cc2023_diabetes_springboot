package com.baloise.cc2023diabetes.service.food;

import com.baloise.cc2023diabetes.service.food.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RecipeServiceTest {

	@Autowired
	DataSource ds;

	@Autowired
	RecipeService recipeService;

	@Test
	void t1() {
		UUID userId = UUID.randomUUID();
		createRecipe(userId);

		List<RecipeModel> recipes = recipeService.getRecipes(userId, Collections.emptyList());
		var recipe = recipes.get(recipes.size() - 1);
		assertThat(recipe).extracting(RecipeModel::title).isEqualTo("My Recipe");
		assertThat(recipe.ingredients().size()).isEqualTo(2);

		assertThat(recipe.ingredients().get(0)).extracting(
			RecipeIngredientModel::amount,
			it -> it.food().title(),
			it -> it.food().unit()
		).containsExactly(new BigDecimal("2"), "Agavensirup", "pro 100g essbarer Anteil");
		assertThat(recipe.ingredients().get(1)).extracting(
			RecipeIngredientModel::amount,
			it -> it.food().title(),
			it -> it.food().unit()
		).containsExactly(new BigDecimal("5"), "Ahornsirup", "pro 100 ml");
		System.out.println(recipes);
	}

	private void createRecipe(UUID userId) {
		CreateRecipeIngredientModel ingredient1 = CreateRecipeIngredientModelBuilder.builder()
			.amount(new BigDecimal("2"))
			.foodId(2)
			.build();
		CreateRecipeIngredientModel ingredient2 = CreateRecipeIngredientModelBuilder.builder()
			.amount(new BigDecimal("5"))
			.foodId(3)
			.build();
		CreateRecipeModel myRecipe = CreateRecipeModelBuilder.builder()
			.title("My Recipe")
			.ingredients(List.of(ingredient1, ingredient2))
			.build();
		recipeService.createRecipe(userId, myRecipe);
	}
}
