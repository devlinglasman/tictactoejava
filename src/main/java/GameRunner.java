class GameRunner {

    private GameLogic gameLogic;
    private ConsoleDisplay consoleDisplay;

    GameRunner(ConsoleDisplay consoleDisplay, GameLogic gameLogic) {
        this.consoleDisplay = consoleDisplay;
        this.gameLogic = gameLogic;
    }

    public void run() {
        String gameChoice = chooseGame();
        if (gameChoice.equals("computerGame")) {
            runComputerGame();
        } else {
            runHumanGame();
        }
    }

    public void runComputerGame() {
        String statusMessage;
        displayGrid();
        while (gameOngoing()) {
            if (itIsHumanTurn()) {
                statusMessage = runHumanTurnReturnStatusMessage();
                announceHumanSquareChoice();
            } else {
                statusMessage = computerTurnStatus();
                announceComputerTurn();
            }
            displayGrid();
            announceIfGameOver(statusMessage);
        }
    }

    public void runHumanGame() {
        String statusMessage;
        displayGrid();
        while (gameOngoing()) {
            statusMessage = runHumanTurnReturnStatusMessage();
            announceHumanSquareChoice();
            displayGrid();
            announceIfGameOver(statusMessage);
        }
    }

    public String runHumanTurnReturnStatusMessage() {
        askForSquareChoice();
        String input = takeHumanInput();
        boolean inputInvalid = inputNotLegal(input);
        while (inputInvalid) {
            announceInputInvalid();
            askForSquareChoice();
            input = takeHumanInput();
            inputInvalid = inputNotLegal(input);
        }
        return sendHumanInputReceiveStatus(input);
    }

    public void announceIfGameOver(String statusMessage) {
        if (statusMessage.equals("gameWon")) {
            announceWinner();
        } else if (statusMessage.equals("gameTied")) {
            announceGameTied();
        }
    }

    private String chooseGame() {
        askGameMode();
        String choice = takeHumanInput();
        return gameLogic.findGameMode(choice);
    }

    private String takeHumanInput() {
        return consoleDisplay.takeInput();
    }

    private boolean inputNotLegal(String input) {
        return gameLogic.inputNotLegal(input);
    }

    private String sendHumanInputReceiveStatus(String input) {
        return gameLogic.makeMoveReturnStatus(input);
    }

    private String computerTurnStatus() {
        return gameLogic.computerTurnStatus();
    }

    private void announceHumanSquareChoice() {
        consoleDisplay.announceHumanSquareChoice();
    }

    private void displayGrid() {
        consoleDisplay.displayGrid(gameLogic.getGridSquares());
    }

    private boolean gameOngoing() {
        return gameLogic.gameOngoing();
    }

    private boolean itIsHumanTurn() {
        return gameLogic.itIsHumanTurn();
    }

    private void announceInputInvalid() {
        consoleDisplay.announceInputInvalid();
    }

    private void askForSquareChoice() {
        consoleDisplay.askForSquareChoice(gameLogic.getActivePlayer());
    }

    private void announceWinner() {
        consoleDisplay.announceWinner(gameLogic.getActivePlayer());
    }

    private void announceGameTied() {
        consoleDisplay.announceGameTied();
    }

    private void askGameMode() {
        consoleDisplay.askGameMode();
    }

    private void announceComputerTurn() {
        consoleDisplay.announceComputerTurn();
    }
}


