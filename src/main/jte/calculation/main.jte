@import com.baloise.cc2023diabetes.htmx.food.SelectedFoodModel
@import java.util.Collection

@param Collection<SelectedFoodModel> items

<%-- selectedFoodEntryChanged --%>
@template.layout.page(
init = "init",
content = @`
	<div>
		<div>
			<div hx-trigger="selectedFoodEntryChanged from:body, init from:body" hx-get="/calcDataEntry"></div>
<%--			@template.calculation.calc_empfindlichkeit()--%>
			<div hx-trigger="selectedFoodEntryChanged from:body, init from:body" hx-get="/selectedFoodItems"></div>


		</div>
	</div>
	<%--
	Disable hx-boost so that 'DOMContentLoaded' event will be triggered.
	Alternative: disable it completely on body element.
	--%>
	<a hx-boost="false" role="button" href="/food">Zurück</a>
`
)

