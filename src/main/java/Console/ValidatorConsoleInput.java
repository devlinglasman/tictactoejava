package Console;

public class ValidatorConsoleInput {

    public boolean inputNotValidGameChoice(String input) {
       if (inputNotCorrectFormat(input)) return true;
       else {
           int inputConverted = convertInputStrtoInt(input);
           return inputConverted != 1 && inputConverted != 2;
       }
    }

    public boolean inputNotValidGridNumber(String input) {
        if (inputNotCorrectFormat(input)) return true;
        else {
            int inputConverted = convertInputStrtoInt(input);
            return inputIsNotWithinRange(inputConverted);
        }
    }

    public boolean inputNotCorrectFormat(String input) {
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
