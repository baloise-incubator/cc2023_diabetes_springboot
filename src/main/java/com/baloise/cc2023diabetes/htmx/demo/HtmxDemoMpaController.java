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

    @GetMapping("/demo")
    public String main(Model model) {
        return "demo/main";
    }

    @GetMapping("/demo/spa/alpine-data/page1")
    public String data_page1(Model model) {
        return "demo/spa/alpine-data/page1";
    }

    @GetMapping("/demo/spa/alpine-data/page2")
    public String data_page2(Model model) {
        return "demo/spa/alpine-data/page2";
    }

    @GetMapping("/demo/spa/alpine-store/page1")
    public String store_page1(Model model) {
        return "demo/spa/alpine-store/page1";
    }

    @GetMapping("/demo/spa/alpine-store/page2")
    public String store_page2(Model model) {
        return "demo/spa/alpine-store/page2";
    }

}
