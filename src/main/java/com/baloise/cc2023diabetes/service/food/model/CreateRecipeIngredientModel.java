package com.baloise.cc2023diabetes.service.food.model;

import java.math.BigDecimal;

public record CreateRecipeIngredientModel(Integer foodId, BigDecimal amount) {
}
