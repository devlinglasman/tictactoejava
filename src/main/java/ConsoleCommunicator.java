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
            if (itIsHumanTurn()) {
                askForSquareChoice();
                boolean humanTurnOngoing = true;
                while (humanTurnOngoing) {
                    String input = takeHumanInput();
                    String statusMessage = sendInputToGameReceiveStatusMessage(input);
                    if (statusMessage.equals("inputNotValid")) {
                        announceInputInvalid();
                        humanTurnOngoing = true;
                    } else if (statusMessage.equals("gameWon")) {
                        announceWinner();
                        humanTurnOngoing = false;
                    } else if (statusMessage.equals("gameTied")) {
                        announceGameTied();
                        humanTurnOngoing = false;
                    } else {
                        announceHumanSquareChoice();
                        displayGrid();
                        humanTurnOngoing = false;
                    }
                }
            } else {
                boolean turnOngoing = true;
                while (turnOngoing) {
                    String input = takeComputerInput();
                    String statusMessage = sendInputToGameReceiveStatusMessage(input);
                    if (statusMessage.equals("inputNotValid")) {
                        turnOngoing = true;
                    } else if (statusMessage.equals("gameWon")) {
                        announceWinner();
                        turnOngoing = false;
                    } else if (statusMessage.equals("gameTied")) {
                        announceGameTied();
                        turnOngoing = false;
                    } else {
                        announceComputerTurn();
                        displayGrid();
                        turnOngoing = false;
                    }
                }
            }
            gameLogic.alternatePlayer();
        }
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

    public String sendInputToGameReceiveStatusMessage(String input) {
        String statusMessage = gameLogic.receiveInputSendStatus(input);
        return statusMessage;
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

    public String takeComputerInput() {
        return gameLogic.generateComputerInput();
    }

    public void runHumanGame() {
        displayGrid();
        while (gameOngoing()) {
            displayGrid();
            String input = takeHumanInput();
            sendInputToGameReceiveStatusMessage(input);
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


