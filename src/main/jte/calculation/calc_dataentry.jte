@import com.baloise.cc2023diabetes.htmx.food.SelectedFoodModel
@import java.util.Collection

@param Collection<SelectedFoodModel> items

<article>
	<header>
		<h3>Zutaten Menge festlegen</h3>
	</header>
	<table class="striped">
		<thead>
		<tr>
			<th scope="col">Lebensmittel</th>
			<th scope="col">Einheit</th>
			<th scope="col">Menge in Einheit</th>
			<th scope="col">Aktion</th>
		</tr>
		</thead>
		<tbody>
		@for(SelectedFoodModel food : items)
			<tr>
				<td scope="row">${food.title()}</td>
				<td scope="row">${food.unit()}</td>
				<td>
					<input
						class="table-input"
						type="text"
						placeholder="Menge eintragen"
						aria-label="Text"
						name="amount"
						hx-put="/changeSelectedFood"
						hx-vals='{"title": "${food.title()}"}'
						value="${food.amount()}"
					>
				</td>
				<td>
					<button><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24"><path fill="currentColor" d="m9.4 16.5l2.6-2.6l2.6 2.6l1.4-1.4l-2.6-2.6L16 9.9l-1.4-1.4l-2.6 2.6l-2.6-2.6L8 9.9l2.6 2.6L8 15.1l1.4 1.4ZM7 21q-.825 0-1.413-.588T5 19V6H4V4h5V3h6v1h5v2h-1v13q0 .825-.588 1.413T17 21H7Z"/></svg></button>
				</td>
			</tr>
		@endfor
		</tbody>
	</table>
</article>
