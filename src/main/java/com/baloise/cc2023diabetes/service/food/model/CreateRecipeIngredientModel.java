package com.baloise.cc2023diabetes.service.food.model;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.math.BigDecimal;

@RecordBuilder
public record CreateRecipeIngredientModel(Integer foodId, BigDecimal amount) {
}
