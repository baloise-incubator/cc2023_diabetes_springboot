@import com.baloise.cc2023diabetes.service.food.model.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM model

@template.layout.page(
content = @`
	<div class="search-container">
		<input
				type="search"
				id="myInput"
				name="search"
				placeholder="Suche nach Lebensmittel"
				hx-get="/food/search"
				hx-target="#search-result"
				hx-trigger="keyup delay:200ms changed"
		/>
		<div id="search-result"></div>
		<div hx-trigger="selectedFoodChanged from:body" hx-get="/chips"></div>
		<hr>
		<a role="button" href="/calculation">Weiter zur Berechnung</a>
	</div>
`
)

