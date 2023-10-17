package com.baloise.cc2023diabetes.service.food.model;

public record FoodModel(long id, String title, String unit, Double carbohydrateAvailable, Double carbohydrateUnits,
                        Double sugar) {
}
