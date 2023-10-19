package com.baloise.cc2023diabetes.service.food.model;

import java.math.BigDecimal;

public record FoodModel(Integer id, String title,
                        String unit,
                        BigDecimal carbohydrateAvailable,
                        BigDecimal carbohydrateUnits,
                        BigDecimal sugar) {

}
