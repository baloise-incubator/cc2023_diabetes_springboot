package com.baloise.cc2023diabetes.htmx.calculation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxCalculationController {

    @GetMapping("/calculation")
    public String calculation(HttpServletRequest request) {
        return "calculation/main";
    }
}
