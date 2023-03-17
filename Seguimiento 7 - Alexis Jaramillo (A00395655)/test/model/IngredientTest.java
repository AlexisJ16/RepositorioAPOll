package model;

import excepctions.OperationsWithNegativeValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest{

    private Ingredient ingredient;

    public void setupStage1 (){
        ingredient = new Ingredient("Tomate",245 );
    }

    @Test
    public void addWeightToAnIngredientTest(){

        setupStage1();
        this.ingredient.addWeight(54);
        assertEquals(299,this.ingredient.getWeight());
    }

    @Test
    public void addNegativeWeightToAnIngredientTest(){

        setupStage1();
        boolean result = true;

        try {
            this.ingredient.addWeight(-100);
        }catch (OperationsWithNegativeValueException ex){
            result = false;
        }
        assertFalse(result);
        assertEquals(245,this.ingredient.getWeight());
    }

    @Test
    public void removeWeightToAnIngredientTest(){

        setupStage1();
        this.ingredient.removeWeight(45);
        assertEquals(200, this.ingredient.getWeight());
    }

    @Test
    public void removeNegativeWeightToAnIngredientTest(){

        setupStage1();
        boolean result = true;

        try {
            this.ingredient.removeWeight(-100);
        } catch (OperationsWithNegativeValueException ex){
            result = false;
        }
        assertFalse(result);
        assertEquals(245, this.ingredient.getWeight());
    }
}