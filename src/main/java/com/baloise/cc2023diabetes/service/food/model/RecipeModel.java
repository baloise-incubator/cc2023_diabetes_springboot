package com.baloise.cc2023diabetes.service.food.model;

import java.util.List;

public record RecipeModel(Integer id,
                          String title,
                          List<RecipeIngredientModel> ingredients) {
}
