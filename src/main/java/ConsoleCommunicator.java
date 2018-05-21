class ConsoleCommunicator {

    private GameLogic gameLogic;
    private ConsoleDisplay consoleDisplay;

    ConsoleCommunicator(ConsoleDisplay consoleDisplay, GameLogic gameLogic) {
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

    public String chooseGame() {
        askGameMode();
        String choice = takeHumanInput();
        return gameLogic.findGameMode(choice);
    }

    public String takeHumanInput() {
        return consoleDisplay.takeInput();
    }

    public void runComputerGame() {
        displayGrid();
        while (gameOngoing()) {
            String statusMessage;
            if (itIsHumanTurn()) {
                askForSquareChoice();
                String input = takeHumanInput();
                boolean inputInvalid = inputNotLegal(input);
                while (inputInvalid) {
                    announceInputInvalid();
                    askForSquareChoice();
                    input = takeHumanInput();
                    inputInvalid = inputNotLegal(input);
                }
                statusMessage = sendHumanInputReceiveStatus(input);
                announceHumanSquareChoice();
            } else {
                statusMessage = computerTurnStatus();
                announceComputerTurn();
            }
            displayGrid();
            if (statusMessage.equals("gameWon")) {
                announceWinner();
            } else if (statusMessage.equals("gameTied")) {
                announceGameTied();
            }
        }
    }

    public boolean inputNotLegal(String input) {
        return gameLogic.inputNotLegal(input);
    }

    public String sendHumanInputReceiveStatus(String input) {
        return gameLogic.sendHumanInputReceiveStatus(input);
    }

    public String computerTurnStatus() {
        return gameLogic.computerTurnStatus();
    }

    private void announceHumanSquareChoice() {
        consoleDisplay.announceHumanSquareChoice();
    }

    public void displayGrid() {
        consoleDisplay.displayGrid(gameLogic.getGridSquares());
    }

    public boolean gameOngoing() {
        return gameLogic.gameOngoing();
    }

    private boolean itIsHumanTurn() {
        return gameLogic.itIsHumanTurn();
    }

    private void announceInputInvalid() {
        consoleDisplay.announceInputInvalid();
    }

    private boolean gameIsWon() {
        return gameLogic.gameIsWon();
    }

    private void askForSquareChoice() {
        consoleDisplay.askForSquareChoice(gameLogic.getActivePlayer());
    }

    public void announceWinner() {
        consoleDisplay.announceWinner(gameLogic.getActivePlayer());
    }

    public void announceGameTied() {
        consoleDisplay.announceGameTied();
    }

    public void runHumanGame() {
        displayGrid();
        while (gameOngoing()) {
            displayGrid();
            String input = takeHumanInput();
            if (gameIsWon()) {
                announceWinner();
            }
            displayGrid();
            gameLogic.alternatePlayer();
        }
    }

    public void askGameMode() {
        consoleDisplay.askGameMode();
    }

    public void announceComputerTurn() {
        consoleDisplay.announceComputerTurn();
    }
}


