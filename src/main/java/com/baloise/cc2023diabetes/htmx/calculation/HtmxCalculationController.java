package com.baloise.cc2023diabetes.htmx.calculation;

import com.baloise.cc2023diabetes.htmx.food.SelectedFood;
import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxCalculationController {

    private final SelectedFood selectedFood;

    @GetMapping("/calculation")
    public String calculation(Model model) {
        Map<String, FoodModel> items = selectedFood.getItems();
        model.addAttribute("items", items.keySet());
        return "calculation/main";
    }
}
