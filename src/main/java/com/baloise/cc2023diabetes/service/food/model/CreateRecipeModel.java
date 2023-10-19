package com.baloise.cc2023diabetes.service.food.model;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.List;

@RecordBuilder
public record CreateRecipeModel(
	String title,
	List<CreateRecipeIngredientModel> ingredients
) implements CreateRecipeModelBuilder.With {
}
