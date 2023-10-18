package com.baloise.cc2023diabetes.htmx.food;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record SelectedFoodModel(long id, String title, String amount) implements SelectedFoodModelBuilder.With {
}
