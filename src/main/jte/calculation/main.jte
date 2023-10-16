@import com.baloise.cc2023diabetes.htmx.food.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM model

@template.layout.page(
content = @`
	<div>
		<div>
			<article>
				<header>
					<h3>Zutaten Menge festlegen</h3>
				</header>
				<table class="striped">
					<thead>
					<tr>
						<th scope="col">Lebensmittel</th>
						<th scope="col">Menge</th>
						<th scope="col">Aktion</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td scope="row">Apfel</td>
						<td>
							<input class="table-input" type="text" placeholder="Text" aria-label="Text"/>
						</td>
						<td>
							<button><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24"><path fill="currentColor" d="m9.4 16.5l2.6-2.6l2.6 2.6l1.4-1.4l-2.6-2.6L16 9.9l-1.4-1.4l-2.6 2.6l-2.6-2.6L8 9.9l2.6 2.6L8 15.1l1.4 1.4ZM7 21q-.825 0-1.413-.588T5 19V6H4V4h5V3h6v1h5v2h-1v13q0 .825-.588 1.413T17 21H7Z"/></svg></button>
						</td>
					</tr>
					</tbody>
				</table>
			</article>

			<article>
				<header>
					<h3>Tageszeit für Insulinempfindlichkeitsfaktor</h3>
				</header>
				<fieldset><label for="morning">
						<input type="radio" id="morning" name="size" value="morning" checked>
						Morgens
					</label>
					<label for="noon">
						<input type="radio" id="noon" name="size" value="noon">
						Mittags
					</label>
					<label for="evening">
						<input type="radio" id="evening" name="size" value="evening">
						Abends
					</label>
				</fieldset>
			</article>
			<article>
				<header>
					<h3>Zusammenfassung KE</h3>
				</header>
				<table class="striped">
					<thead>
					<tr>
						<th scope="col">Lebensmittel</th>
						<th scope="col">Menge</th>
						<th scope="col">KEs</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td scope="row">Apfel</td>
						<td>300 g</td>
						<td>3</td>
					</tr>
					</tbody>
					<tfoot>
					<tr>
						<td scope="row">Summe</td>
						<td></td>
						<td>3</td>
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
		</div>
	</div>
`
)

