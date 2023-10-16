@import com.baloise.cc2023diabetes.htmx.food.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM result
    <ul id="myUL">
    @for(FoodModel food : result.foodModels())
            <li @click="items = [...items, '${food.name()}']">${food.name()}</li>
    @endfor
    </ul>
