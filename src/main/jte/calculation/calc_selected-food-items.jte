@import com.baloise.cc2023diabetes.htmx.food.SelectedFoodModel
@import java.util.Collection

@param Collection<SelectedFoodModel> items
@param String insulinSum
@param String keSum
@param double selectedSensitivity

<article>

	<header>
		<h3>Zusammenfassung KE</h3>
	</header>
	<table class="striped">
		<thead>
		<tr>
			<th scope="col">Lebensmittel</th>
			<th scope="col">Einheit</th>
			<th scope="col">Menge in Einheit</th>
			<th scope="col">Kohlenhydrate in g</th>
			<th scope="col">Zucker in g</th>
			<th scope="col">KEs</th>
		</tr>
		</thead>
		<tbody>
		@for(SelectedFoodModel food : items)
			<tr>
				<td scope="row">${food.title()}</td>
				<td>${food.unit()}</td>
				<td>${food.amount()}</td>
				<td>${food.weightedCarbohydrateAvailable()}</td>
				<td>${food.weightedSugar()}</td>
				<td>${food.weightedCarbohydrateUnits()}</td>
			</tr>
		@endfor
		</tbody>
	</table>
</article>

<article>
	<header>
		<h3>Insulinbedarf: ${insulinSum} Einheiten</h3>
	</header>
	<body>
	<h4> Berechnung</h4>
	<table>
		<thead>
		<th>Summe KEs</th>
		<th></th>
		<th>KE-Faktor</th>
		<th></th>
		<th><b>Insulineinheiten</b></th>
		</thead>
		<tbody>
		<tr>
			<td>${keSum}</td>
			<td>*</td>
			<td>${selectedSensitivity}</td>
			<td>=</td>
			<td><b>${insulinSum}</b></td>
		</tr>
		</tbody>
	</table>
	</body>
</article>
