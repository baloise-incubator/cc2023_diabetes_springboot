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

    @GetMapping("/json/recipes/search")
    public List<RecipeModel> searchRecipes(Principal principal, @RequestParam String search) {
        return recipeService.searchRecipes(UUID.fromString(principal.getName()), search);
    }

    @GetMapping("/json/recipes")
    public List<RecipeModel> getAllRecipes(Principal principal) {
        return recipeService.getAll(UUID.fromString(principal.getName()));
    }
}
