@import com.baloise.cc2023diabetes.htmx.food.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM result
    <ul id="myUL" x-data>
    @for(FoodModel food : result.foodModels())
<%--            <li @click="$store.globalstate.addItem('${food.title()}')">${food.title()}</li>--%>
            <li @click="items = [...items, {id: '${food.title()}', title: '${food.title()}'}]">${food.title()}</li>
    @endfor
    </ul>
