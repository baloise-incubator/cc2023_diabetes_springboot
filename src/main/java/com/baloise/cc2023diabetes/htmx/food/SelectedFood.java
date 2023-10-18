package com.baloise.cc2023diabetes.htmx.food;

import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@SessionScope
@Component
@Data
public class SelectedFood {
//	private Set<String> titles = new HashSet<>();
	private Map<String, FoodModel> items = new HashMap<>();
}
