package com.baloise.cc2023diabetes.htmx.food;

import com.baloise.cc2023diabetes.service.food.FoodService;
import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxFoodController {

    private final FoodService foodService;

    private final SelectedFood selectedFood;

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
        if (!"".equals(search)) {
            model.addAttribute("result", new FoodVM(foodService.search(search)));
        }

        return "food/search";
    }

    @PostMapping(path = "/saveSelectedFood", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void saveSelectedFood(SaveFoodPayload payload, Model model, HttpServletResponse response) {
        String newFoodName = payload.title();
        FoodModel foodModel = foodService.search(newFoodName).get(0);
        var newItems = new HashMap<>(selectedFood.getItems());
        newItems.put(newFoodName, foodModel);
        selectedFood.setItems(newItems);

        model.addAttribute("message", newFoodName + " put into session");
        response.setHeader("HX-Trigger", "selectedFoodChanged");
        response.setStatus(HttpStatus.CREATED.value());
    }

    @DeleteMapping(path = "/deleteSelectedFood", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void deleteSelectedFood(DeleteFoodPayload payload, Model model, HttpServletResponse response) {
        var map = new HashMap<>(selectedFood.getItems());
        map.remove(payload.title());
        selectedFood.setItems(map);
        response.setHeader("HX-Trigger", "selectedFoodChanged");
    }

    @GetMapping("/chips")
    public String chips(Model model) {
        model.addAttribute("items", selectedFood.getItems().keySet());
        return "food/chips";
    }


}
