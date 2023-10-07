package com.baloise.cc2023diabetes.htmx;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxFoodController {

	@GetMapping("/food")
	public String contact() {
		return "food/main";
	}
}
