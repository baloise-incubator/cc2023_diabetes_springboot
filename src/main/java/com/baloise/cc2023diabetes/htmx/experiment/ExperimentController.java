package com.baloise.cc2023diabetes.htmx.experiment;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class ExperimentController {

    @GetMapping("/experiment")
    public String experiment(Model model) {
        return "experiment/main";
    }


}
