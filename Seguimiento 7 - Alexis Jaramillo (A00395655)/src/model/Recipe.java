package model;

import java.util.ArrayList;

public class Recipe {

    //Crear una lista de ingredientes en el recipiente.
    private ArrayList<Ingredient> ingredients;

    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient (Ingredient ingredient){
        int position = verifyIngredient(ingredient);

        if (position == -1){
            this.ingredients.add(ingredient);
        } else {
            this.ingredients.get(position).addWeight(ingredient.getWeight());
        }
    }

    public int verifyIngredient (Ingredient ingredient){

        for (int i = 0; i < ingredients.size()-1; i++){
            if (ingredients.get(i).getName().equals(ingredient.getName())){
                return i;
            }
        }
        return -1;
    }

    public Ingredient getAnIngredient (int index){
        return this.ingredients.get(index);
    }

    public int size (){
        return this.ingredients.size();
    }

    public Ingredient getLast (){
        int index = this.ingredients.size();
        return this.ingredients.get(index-1);
    }

    //Remover un ingrediente del recipiente.
    public void removeIngredient (String name){
        for (int i = 0; i < ingredients.size(); i++){
            if (ingredients.get(i).getName().equals(name)){
                ingredients.remove(i);
            }
        }
    }


}