@import com.baloise.cc2023diabetes.htmx.food.SelectedFoodModel
@import java.util.Collection

@param Collection<SelectedFoodModel> items

<div hx-trigger="selectedFoodEntryChanged from:body" hx-get="/selectedFoodItems"></div>

