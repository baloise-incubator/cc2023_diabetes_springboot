@import com.baloise.cc2023diabetes.htmx.food.SelectedFoodModel
@import java.util.Collection

@param Collection<SelectedFoodModel> items

<article>

	<header>
		<h3>Zusammenfassung KE</h3>
	</header>
	<table class="striped">
		<thead>
		<tr>
			<th scope="col">Lebensmittel</th>
			<th scope="col">Menge in g</th>
			<th scope="col">Kohlenhydrate in g</th>
			<th scope="col">Zucker in g</th>
			<th scope="col">KEs</th>
		</tr>
		</thead>
		<tbody>
		@for(SelectedFoodModel food : items)
			<tr>
				<td scope="row">${food.title()}</td>
				<td>${food.amount()}</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
			</tr>
		@endfor
		</tbody>
		<tfoot>
		<tr>
			<td scope="row">Summe</td>
			<td></td>
			<td>3</td>
			<td></td>
			<td></td>
		</tr>
		</tfoot>
	</table>
	<footer>
		<details>
			<summary>Gesamt Insulin Einheiten: 6</summary>
			<p>Berechnung: 3 KEs * Insulinfaktor (2) = Gesamt Insulin Einheiten: 6</p>
		</details>
		<!--                    <p data-tooltip="3 KEs * Insulinfaktor (2) = Gesamt Insulin Einheiten: 6">Gesamt Insulin Einheiten: 6</p>-->
	</footer>
</article>
