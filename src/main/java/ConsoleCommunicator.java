import java.util.Random;

class ConsoleCommunicator {

    private GameLogic gameLogic;
    private ConsoleDisplay consoleDisplay;

    ConsoleCommunicator(ConsoleDisplay consoleDisplay, GameLogic gameLogic) {
        this.consoleDisplay = consoleDisplay;
        this.gameLogic = gameLogic;
    }

    public void chooseGame() {
        askGameMode();
        String choice = takeInput();
        if (choice.equals("1")) {
            runComputerGame();
        } else {
            runHumanGame();
        }
    }

    public void runComputerGame() {
        displayGrid();
        while (gameLogic.gameOngoing()) {
            if (gameLogic.getActivePlayer() == Player.PLAYERONE) {
                runHumanTurn();
            } else {
                runComputerTurn();
            }
            if (gameLogic.isGameWon()) {
                announceWinner();
            }
            displayGrid();
            gameLogic.alternatePlayer();
        }
    }

    public void runHumanTurn() {
        int squareNumber = takeLegalInput();
        gameLogic.markSquare(squareNumber, gameLogic.getActivePlayer().getMark());
    }

    public int takeLegalInput() {
        boolean isMoveLegal = false;
        int potentialInput = 0;
        while (!isMoveLegal) {
            potentialInput = inputSelection();
            isMoveLegal = isMoveLegal(potentialInput);
        }
        return potentialInput;
    }


    public int inputSelection() {
        int input;
        if (gameLogic.getActivePlayer() == Player.PLAYERONE) {
            String inputString = askAndTakeInput();
            input = gameLogic.convertInputToSquareNumber(inputString);
        } else {
            input = computerInputSelection();
        }
        return input;
    }

    public int computerInputSelection() {
        Random rand = new Random();
        int potentialInput = rand.nextInt(8);
        return potentialInput;
    }


    private boolean isMoveLegal(int potentialInput) {
        if (gameLogic.isMoveLegal(potentialInput)) return true;
        else return false;
    }

    public void runComputerTurn() {
        int potentialInput = takeLegalInput();
        announceComputerTurn();
        gameLogic.markSquare(potentialInput, gameLogic.getActivePlayer().getMark());
    }

    public void runHumanGame() {
        displayGrid();
        while (gameLogic.gameOngoing()) {
            runHumanTurn();
            if (gameLogic.isGameWon()) {
                announceWinner();
            }
            displayGrid();
            gameLogic.alternatePlayer();
        }
    }

    public void displayGrid() {
        consoleDisplay.displayGrid(gameLogic.getGridSquares());
    }

    public String askAndTakeInput() {
        return consoleDisplay.askAndTakeInput(gameLogic.getActivePlayer());
    }

    public String takeInput() {
        return consoleDisplay.takeInput();
    }

    public void askGameMode() {
        consoleDisplay.askGameMode();
    }

    public void announceWinner() {
        consoleDisplay.announceWinner(gameLogic.getActivePlayer());
    }

    public void announceComputerTurn() {
        consoleDisplay.announceComputerTurn();
    }
}


