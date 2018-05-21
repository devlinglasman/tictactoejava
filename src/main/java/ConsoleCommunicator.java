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
            boolean turnOngoing = true;
            if (itIsHumanTurn()) {
                askForSquareChoice();
                while (turnOngoing) {
                    String input = takeHumanInput();
                    if (inputNotLegal(input)) {
                        announceInputInvalid();
                    } else {
                       turnOngoing = false;
                       sendInputToGameReceiveResponse(input);
                    }
                }
            } else {
                while (turnOngoing) {
                    String input = takeComputerInput();
                    if (!inputNotLegal(input)) {
                        announceComputerTurn();
                        turnOngoing = false;
                        sendInputToGameReceiveResponse(input);
                    }
                }
            }
        }
    }

    public boolean inputNotLegal(String input) {
       return gameLogic.inputNotLegal(input);
    }

    public void sendInputToGameReceiveResponse(String input) {
        String statusMessage = sendInputToGameReceiveStatusMessage(input);
        if (statusMessage.equals("humanMadeChoice")) announceHumanSquareChoice();
        displayGrid();
        if (statusMessage.equals("gameWon")) {
            announceWinner();
        } else if (statusMessage.equals("gameTied")) {
            announceGameTied();
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


