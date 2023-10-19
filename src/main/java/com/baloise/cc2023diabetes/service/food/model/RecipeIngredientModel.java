package com.baloise.cc2023diabetes.service.food.model;

import java.math.BigDecimal;

public record RecipeIngredientModel(FoodModel food,
                                    BigDecimal amount) {
}
