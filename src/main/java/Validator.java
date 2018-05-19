public class Validator {

    public boolean inputIsNotValid(String input) {
        int inputConverted = convertInputStrtoInt(input);
        return inputConverted < 1 || inputConverted > 9;
    }

    public int convertInputToGridSquare(String input) {
        int inputConverted = convertInputStrtoInt(input);
        return inputConverted - 1;
    }

    public int convertInputStrtoInt(String input) {
        return Integer.parseInt(input);
    }
}
