package com.baloise.cc2023diabetes.htmx.calculation;

import com.baloise.cc2023diabetes.htmx.food.SelectedFoodModel;
import com.baloise.cc2023diabetes.htmx.food.SelectedFoodStore;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.*;

@Controller
@AllArgsConstructor
@Slf4j
public class HtmxCalculationController {

    private final SelectedFoodStore selectedFoodStore;

    @GetMapping("/calculation")
    public String calculation(Model model) {
        var items = selectedFoodStore.getItems();

        model.addAttribute("items", items.values());
        return "calculation/main";
    }

    @PutMapping(path = "/changeSelectedFood", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void changeSelectedFood(ChangeSelectedFoodPayload payload, Model model, HttpServletResponse response) {
        log.info("changeSelectedFood: {}", payload);
        selectedFoodStore.changeItem(payload.title(), payload.amount());
        response.setHeader("HX-Trigger", "selectedFoodEntryChanged");
    }

    @GetMapping("/calcDataEntry")
    public String calcDataEntry(Model model) {
        model.addAttribute("items", selectedFoodModelsSorted(selectedFoodStore.getItems().values()));
        return "calculation/calc_dataentry";
    }

    @GetMapping("/selectedFoodItems")
    public String selectedFoodItems(Model model) {
        Collection<SelectedFoodModel> values = selectedFoodStore.getItems().values();
        model.addAttribute("items", selectedFoodModelsSorted(values));

        var selectedSensitivity = 1.2;

        var insulinSum = 0.0;
        var keSum = 0.0;
        for (SelectedFoodModel value : values) {
            var w = value.amount();
            insulinSum += (w)/100.0;
            keSum += w*value.carbohydrateUnits();
        }
		insulinSum /= selectedSensitivity;
        model.addAttribute("insulinSum", String.format("%,.2f", insulinSum) );
        model.addAttribute("keSum", String.format("%,.2f", keSum));
        model.addAttribute("selectedSensitivity", selectedSensitivity);

        return "calculation/calc_selected-food-items";
    }

    private List<SelectedFoodModel> selectedFoodModelsSorted(Collection<SelectedFoodModel> values) {
        var result = new ArrayList<>(values);
        Collections.sort(result);
        return result;
    }

}
