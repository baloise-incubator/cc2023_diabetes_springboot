package com.baloise.cc2023diabetes.htmx.food;

import com.baloise.cc2023diabetes.service.food.FoodService;
import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxFoodController {

    private final FoodService foodService;

    @GetMapping("/food")
    public String food(Model model) {
        List<FoodModel> rows = foodService.all();

        // View model population:
        model.addAttribute("model", new FoodVM(rows));

        return "food/main";
    }

    @GetMapping("/food/search")
    public String food_search(HttpServletRequest request, @RequestParam(required = true) String search, Model model) {
        model.addAttribute("result", new FoodVM(new ArrayList<>()));
        if (search != "") {
            model.addAttribute("result", new FoodVM(foodService.search(search)));
        }

        System.out.println("search = " + search);
        return "food/search";
    }
}
