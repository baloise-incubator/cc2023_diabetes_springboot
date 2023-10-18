@import com.baloise.cc2023diabetes.htmx.food.SelectedFoodModel
@import java.util.Collection

@param Collection<SelectedFoodModel> items

@template.layout.page(
init = "selectedFoodEntryChanged",
content = @`
	<div>
		<div>
			@template.calculation.calc_dataentry(items)
<%--			@template.calculation.calc_empfindlichkeit()--%>
			@template.calculation.calc_result(items)


		</div>
	</div>
`
)

