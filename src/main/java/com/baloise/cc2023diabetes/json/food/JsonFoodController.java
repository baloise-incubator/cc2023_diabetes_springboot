package com.baloise.cc2023diabetes.json.food;

import com.baloise.cc2023diabetes.service.food.FoodService;
import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class JsonFoodController {

    private final FoodService foodService;

    @GetMapping("/json/food")
    public ResponseEntity<List<FoodModel>> food(Principal principal) {
        List<FoodModel> rows = foodService.all();
        return ResponseEntity.ok(rows);
    }

    @GetMapping("/json/food/search")
    public List<FoodModel> foodSearch(@RequestParam(required = true) String search) {
        return foodService.search(search);
    }
}
