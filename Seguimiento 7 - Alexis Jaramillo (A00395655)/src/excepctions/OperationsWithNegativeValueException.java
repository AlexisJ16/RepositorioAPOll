package excepctions;

public class OperationsWithNegativeValueException extends RuntimeException{

    public OperationsWithNegativeValueException() {
        super("No puedes usar un numero negativo para las operaciones");
    }
}