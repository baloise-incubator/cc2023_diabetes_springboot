package com.baloise.cc2023diabetes.json.recipe;

import com.baloise.cc2023diabetes.service.food.RecipeService;
import com.baloise.cc2023diabetes.service.food.model.CreateRecipeModel;
import com.baloise.cc2023diabetes.service.food.model.RecipeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class JsonRecipeController {

    private final RecipeService recipeService;

    @PostMapping("/json/recipes")
    public RecipeModel createRecipe(Principal principal, @RequestBody CreateRecipeModel recipeModel) {
        return recipeService.createRecipe(UUID.fromString(principal.getName()), recipeModel);
    }

    @GetMapping("/json/recipes/{id}")
    public RecipeModel getRecipeById(Principal principal, @PathVariable Integer id) {
        return recipeService.getRecipe(UUID.fromString(principal.getName()), id);
    }

    @GetMapping("/json/recipes")
    public List<RecipeModel> getAllRecipes(Principal principal, @RequestParam String search) {
        UUID userId = UUID.fromString(principal.getName());
        return search != null && !search.isEmpty()
                ? recipeService.searchRecipes(userId, search) :
                recipeService.getAll(userId);
    }
}
