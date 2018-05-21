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
        while (gameOngoing()) {
            if (itIsHumanTurn()) {
                boolean humanTurnOngoing = true;
                while (humanTurnOngoing) {
                     String statusMessage = sendInputToGame();
                     if (statusMessage.equals("inputNotValid")) {
                         announceInputInvalid();
                         humanTurnOngoing = true;
                     } else if (statusMessage.equals("gameWon")){
                         announceWinner();
                         humanTurnOngoing = false;
                     } else if (statusMessage.equals("gameTied")){
                         announceGameTied();
                         humanTurnOngoing = false;
                     } else {
                         humanTurnOngoing = false;
                     }
                }
            } else {
                runComputerTurn();
            }
            gameLogic.alternatePlayer();
        }
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

    public String sendInputToGame() {
        displayGrid();
        String input = takeHumanInput();
        String statusMessage = gameLogic.runHumanTurn(input);
        return statusMessage;
    }

    private void announceInputInvalid() {
        consoleDisplay.announceInputInvalid();
    }

    private boolean inputIsNotValid(String input) {
        return gameLogic.inputNotValid(input);
    }

    public boolean moveIsNotLegal(String input) {
        return gameLogic.moveNotLegal(input);
    }

    private void makeMove(String input) {
        gameLogic.makeMove(input);
    }

    private boolean gameIsWon() {
        return gameLogic.gameIsWon();
    }

    public void announceWinner() {
        consoleDisplay.announceWinner(gameLogic.getActivePlayer());
    }

    public void announceGameTied() {
        consoleDisplay.announceGameTied();
    }

    public void runComputerTurn() {
        String input = takeComputerInput();
        while (moveIsNotLegal(input)) input = takeComputerInput();
        announceComputerTurn();
        makeMove(input);
    }

    public String takeComputerInput() {
        return gameLogic.generateComputerInput();
    }

    public void runHumanGame() {
        displayGrid();
        while (gameOngoing()) {
            sendInputToGame();
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


