package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

    private Recipe recipe;

    public void setupStage1 (){
        recipe = new Recipe();
    }

    public void setupStage2 (){

        recipe = new Recipe();
        recipe.addIngredient( new Ingredient("Cebolla", 315));
        recipe.addIngredient( new Ingredient("Ajo", 58));
        recipe.addIngredient( new Ingredient("Arroz", 520));
    }

    @Test
    public void RecipeWithOnlyOneIngredientTest(){

        setupStage1();
        this.recipe.addIngredient( new Ingredient("sal", 12));

        assertEquals(1, recipe.size());
        assertEquals("sal", recipe.getAnIngredient(0).getName());
        assertEquals(12, recipe.getAnIngredient(0).getWeight());
    }

    @Test
    public void AddANewIngredientToTheRecipeTest(){

        setupStage2();
        this.recipe.addIngredient( new Ingredient("Pimienta", 6));

        assertEquals(4, recipe.size());
        assertEquals("Pimienta", recipe.getLast().getName());
        assertEquals(6, recipe.getLast().getWeight());
    }

    @Test
    public void ModifyAnIngredientInTheRecipeTest(){

        setupStage2();
        this.recipe.addIngredient( new Ingredient("Ajo", 21));

        assertEquals(3, recipe.size());
        assertEquals(79, recipe.getAnIngredient(1).getWeight());
    }

    @Test

    public void RemoveAnIngredientFromTheRecipeTest(){

        setupStage2();
        this.recipe.removeIngredient("Ajo");

        assertEquals(2, recipe.size());
    }

}