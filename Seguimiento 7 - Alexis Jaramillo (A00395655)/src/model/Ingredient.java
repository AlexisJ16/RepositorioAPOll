package model;

import excepctions.OperationsWithNegativeValueException;

public class Ingredient {

    private String name;
    private int weight;

    public Ingredient(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addWeight(int weight) throws OperationsWithNegativeValueException{
        //Condicion que garantiza que el numero ingresado es negativo.
        if (weight < 0){
            //Arroja la excepcion.
            throw new OperationsWithNegativeValueException();
        }else {
            //Adiciona la suma al peso actual
            this.weight += weight;
        }
    }

    public void removeWeight(int weight) throws OperationsWithNegativeValueException{
        //Condicion que garantiza que el numero ingresado es negativo.
        if (weight < 0){
            //Arroja la excepcion.
            throw new OperationsWithNegativeValueException();
        } else {
            //Resta la suma al peso actual
            this.weight -= weight;
        }
    }


}