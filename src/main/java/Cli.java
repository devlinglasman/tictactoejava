import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Cli {

    private final Scanner scanner;
    private final PrintStream out;
    private GameRunner gameRunner;

    Cli(InputStream in, PrintStream out, GameRunner gameRunner) {
        this.scanner = new Scanner(in);
        this.out = out;
        this.gameRunner = gameRunner;
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
        displayGrid(gameRunner.getGrid().getSquares());
        while (gameRunner.gameOngoing()) {
            if (gameRunner.getActivePlayer() == Player.PLAYERONE) {
                runHumanTurn();
            } else {
                runComputerTurn();
            }
            if (gameRunner.isGameWon()) {
                announceWinner(gameRunner.getActivePlayer());
            }
            displayGrid(gameRunner.getGrid().getSquares());
            gameRunner.alternatePlayer();
        }
    }

    private void runComputerTurn() {
        announceComputerTurn();
        Random rand = new Random();
        gameRunner.getGrid().markSquare(rand.nextInt(8), gameRunner.getActivePlayer().getMark());
    }

    public void runHumanGame() {
        displayGrid(gameRunner.getGrid().getSquares());
        while (gameRunner.gameOngoing()) {
            runHumanTurn();
            if (gameRunner.isGameWon()) {
                announceWinner(gameRunner.getActivePlayer());
            }
            displayGrid(gameRunner.getGrid().getSquares());
            gameRunner.alternatePlayer();
        }
    }

    public void runHumanTurn() {
        String input = askAndTakeInput(gameRunner.getActivePlayer());
        int squareNumber = gameRunner.convertInputToSquareNumber(input);
        gameRunner.getGrid().markSquare(squareNumber, gameRunner.getActivePlayer().getMark());
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


