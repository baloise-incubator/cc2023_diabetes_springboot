package com.baloise.cc2023diabetes.service.food.model;

import java.util.List;

public record CreateRecipeModel(String title,
                                List<CreateRecipeIngredientModel> ingredients) {
}
