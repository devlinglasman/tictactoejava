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
                    humanTurnOngoing = runHumanTurn();
                }
            } else {
                runComputerTurn();
            }
            if (gameIsWon()) {
                announceWinner();
            }
            displayGrid();
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

    public boolean runHumanTurn() {
        String input = takeHumanInput();
        String statusReturn = gameLogic.runHumanTurn(input);
        switch (statusReturn) {
            case "inputNotValid":
                announceComputerTurn();
                return true;
            case "moveNotLegal":
                announceComputerTurn();
                return true;
            case "gameWon":
                announceWinner();
                return false;
            case "gameDraw":
                announceComputerTurn();
                return false;
        }
        return false;
    }

    private boolean inputIsNotValid(String input) {
        return gameLogic.inputIsNotValid(input);
    }

    public boolean moveIsNotLegal(String input) {
        return gameLogic.moveIsNotLegal(input);
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
            runHumanTurn();
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


