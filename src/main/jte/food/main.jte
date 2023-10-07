@import com.baloise.cc2023diabetes.htmx.food.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM model

@template.layout.page(
content = @`
	<table>
	<thead>
		<tr><th>ID</th> <th>Name</th></tr>
	</thead>
	<tbody>
	@for(FoodModel food : model.foodModels())
		<tr>
			<td>${ food.id() }</td>
			<td>${ food.name() }</td>
		</tr>
	@endfor
	</tbody>

	</table>
`
)

