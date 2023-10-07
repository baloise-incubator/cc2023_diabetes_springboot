package com.baloise.cc2023diabetes.json.food;

import com.baloise.cc2023diabetes.htmx.food.FoodModel;
import com.baloise.cc2023diabetes.service.food.FoodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class JsonFoodController {

	private final FoodService foodService;

	@GetMapping("/json/food")
	public ResponseEntity<List<FoodModel>> food() {
		List<FoodModel> rows = foodService.all();
		return ResponseEntity.ok(rows);
	}
}
