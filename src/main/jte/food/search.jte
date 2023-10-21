@import com.baloise.cc2023diabetes.service.food.model.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM result
    <ul id="myUL">
    @for(FoodModel food : result.foodModels())
        <li hx-post="/saveSelectedFood" hx-swap="none" hx-vals='{"title": "${food.title()}", "p2": "v2"}'>${food.title()}</li>
    @endfor
    </ul>
