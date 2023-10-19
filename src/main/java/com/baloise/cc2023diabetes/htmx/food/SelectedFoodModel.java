package com.baloise.cc2023diabetes.htmx.food;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.math.BigDecimal;

@RecordBuilder
public record SelectedFoodModel(
	long id,
	String title,
	String unit,
	int amount,
	BigDecimal carbohydrateAvailable,
	BigDecimal carbohydrateUnits,
	BigDecimal sugar
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
	public String weightedDouble(BigDecimal value, String format) {
		try {
			BigDecimal d = value.multiply(BigDecimal.valueOf(amount));
			return String.format(format, d);
		} catch (NumberFormatException e) {
			return "0";
		}
	}

}
