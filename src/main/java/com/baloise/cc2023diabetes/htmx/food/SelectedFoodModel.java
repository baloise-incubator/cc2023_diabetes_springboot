package com.baloise.cc2023diabetes.htmx.food;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record SelectedFoodModel(
        long id,
        String title,
        String unit,
        Double amount,
        Double carbohydrateAvailable,
        Double carbohydrateUnits,
        Double sugar
) implements Comparable<SelectedFoodModel>, SelectedFoodModelBuilder.With {
    @Override
    public int compareTo(SelectedFoodModel other) {
        return this.title.compareTo(other.title);
    }

    public String weightedCarbohydrateAvailable() {
        return weightedDouble(carbohydrateAvailable(), "%,.2f");
    }

    public String weightedSugar() {
        return weightedDouble(sugar(), "%,.2f");
    }

    public String weightedCarbohydrateUnits() {
        return weightedDouble(carbohydrateUnits(), "%,.2f");
    }

    public String weightedDouble(Double value, String format) {
        try {
            Double d = value * amount;
            return String.format(format, d);
        } catch (NumberFormatException e) {
            return "0";
        }
    }

}
