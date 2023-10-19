package com.baloise.cc2023diabetes.service.food.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record CreateRecipeIngredientModel(Long foodId, Double amount) {
}
