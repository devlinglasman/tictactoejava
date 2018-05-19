public class Validator {

    public boolean inputIsNotValid(String input) {
        if (inputIsNotValidNumber(input)) return true;
        else {
            int inputConverted = convertInputStrtoInt(input);
            return inputIsNotWithinRange(inputConverted);
        }
    }

    public boolean inputIsNotValidNumber(String input) {
        try {
            convertInputStrtoInt(input);
        } catch (NumberFormatException error) {
            return true;
        }
        return false;
    }

    public boolean inputIsNotWithinRange(int input) {
        return input < 1 || input > 9;
    }

    public int convertInputStrtoInt(String input) {
        return Integer.parseInt(input);
    }
}
