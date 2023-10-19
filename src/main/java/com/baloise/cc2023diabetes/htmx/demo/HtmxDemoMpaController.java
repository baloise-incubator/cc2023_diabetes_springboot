package com.baloise.cc2023diabetes.htmx.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxDemoMpaController {

    @GetMapping("/demo/mpa/page1")
    public String page1(Model model) {
        return "demo/mpa/page1";
    }

    @GetMapping("/demo/mpa/page2")
    public String page2(Model model) {
        return "demo/mpa/page2";
    }

}
