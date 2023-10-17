package com.baloise.cc2023diabetes.htmx.food;

import com.baloise.cc2023diabetes.service.food.FoodService;
import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        if (search != "") {
            model.addAttribute("result", new FoodVM(foodService.search(search)));
        }

        System.out.println("search = " + search);
        return "food/search";
    }

    @PostMapping(path = "/saveSelectedFood", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void saveSelectedFood(SaveFoodPayload payload, Model model, HttpServletResponse response) {
        selectedFood.getTitles().add(payload.title());
        model.addAttribute("message", payload.title() + " put into session");
        response.setHeader("HX-Trigger", "selectedFoodSaved");
        response.setStatus(HttpStatus.CREATED.value());
//        return "food/play";
    }

    @GetMapping("/getSession")
    public String getSession(Model model) {
        String title = selectedFood.getTitles().isEmpty() ? "-" : selectedFood.getTitles().get(0);
        model.addAttribute("message", title + " read from session");
        return "food/play";
    }


    @GetMapping("/chips")
    public String chips(Model model) {
        String title = selectedFood.getTitles().isEmpty() ? "-" : selectedFood.getTitles().get(0);
        model.addAttribute("items", selectedFood.getTitles());
//        model.addAttribute("items", Arrays.asList("1", "2", "3"));
        return "food/chips";
    }


}
