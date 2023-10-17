@import com.baloise.cc2023diabetes.htmx.food.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM result
    <ul id="myUL">
    @for(FoodModel food : result.foodModels())
        <li id="food-${food.title()}" hx-post="/saveSelectedFood" hx-target="#set-session-result" hx-vals='{"title": "${food.title()}", "p2": "v2"}'>${food.title()}</li>
    @endfor
    </ul>

<div id="set-session-result"></div>
<button hx-get="/getSession" hx-target="#set-session-result">Get Session Value</button>
