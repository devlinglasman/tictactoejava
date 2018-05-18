import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Cli {

    private final Scanner scanner;
    private final PrintStream out;
    private GameLogic gameLogic;

    Cli(InputStream in, PrintStream out, GameLogic gameLogic) {
        this.scanner = new Scanner(in);
        this.out = out;
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
        displayGrid(gameLogic.getGridSquares());
        while (gameLogic.gameOngoing()) {
            if (gameLogic.getActivePlayer() == Player.PLAYERONE) {
                runHumanTurn();
            } else {
                runComputerTurn();
            }
            if (gameLogic.isGameWon()) {
                announceWinner(gameLogic.getActivePlayer());
            }
            displayGrid(gameLogic.getGridSquares());
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
            String inputString = askAndTakeInput(gameLogic.getActivePlayer());
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
        displayGrid(gameLogic.getGridSquares());
        while (gameLogic.gameOngoing()) {
            runHumanTurn();
            if (gameLogic.isGameWon()) {
                announceWinner(gameLogic.getActivePlayer());
            }
            displayGrid(gameLogic.getGridSquares());
            gameLogic.alternatePlayer();
        }
    }

    public void displayGrid(ArrayList<String> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();
        for (String square : squares) {
            gridConglomerator.add("[" + square + "]");
        }
        gridConglomerator.add(3, "\n");
        gridConglomerator.add(7, "\n");

        StringBuilder gridFinal = new StringBuilder();

        for (String s : gridConglomerator) {
            gridFinal.append(s);
        }
        out.print(gridFinal + "\n");
    }

    public String askAndTakeInput(Player activePlayer) {
        askInput(activePlayer);
        return takeInput();
    }

    public void askInput(Player activePlayer) {
        out.print("\nHi " + activePlayer.getName() + "! Please select a square from 1-9\n");
    }

    public String takeInput() {
        return scanner.next();
    }

    public void askGameMode() {
        out.print("\nHi! please enter '1' to " +
                "play against the computer or '2' to play human-vs-human.\n");
    }

    public void announceWinner(Player activePlayer) {
        out.print("Congratulations " + activePlayer.getName() + " - You're the winner!\n");
    }

    public void announceComputerTurn() {
        out.print("\nComputer takes turn...\n");
    }
}


