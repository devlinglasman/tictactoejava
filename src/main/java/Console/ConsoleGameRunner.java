package Console;

import Core.Game;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;
import Core.Players.PlayerSimulated;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ConsoleGameRunner {

    private Grid grid;
    private ConsoleIO consoleIO;
    private Player playerOne;
    private Player playerTwo;

    public ConsoleGameRunner(ConsoleIO consoleIO) {
        this.consoleIO = consoleIO;
        grid = new Grid();
    }

    public void run() throws IOException {
//        findGameMode();
//        clearScreen();
//        Game game = new Game(grid, playerOne, playerTwo, consoleIO);
//        game.runGame();
        rewatch();
    }

    private void findGameMode() {
        consoleIO.askGameMode();
        String gameChoice = consoleIO.takeInput();
        if (gameChoice.equals("1")) {
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
            playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark, Mark.playerOneMark);
        } else if (gameChoice.equals("2")) {
            playerOne = new PlayerComputer("ComputerOne", Mark.playerOneMark, Mark.playerTwoMark);
            playerTwo = new PlayerComputer("ComputerTwo", Mark.playerTwoMark, Mark.playerOneMark);
        } else {
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
            playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleIO);
        }
    }

    private void clearScreen() {
        consoleIO.clearScreen();
    }

    private void rewatch() throws IOException {
        boolean rewatchOn = true;
        while (rewatchOn) {
            consoleIO.askToRewatch();
            String rewatchChoice = consoleIO.takeInput();
            if (rewatchChoice.equals("y")) {
                GameMovesReader gameMovesReader = new GameMovesReader();
                ArrayList<String> gameValues = gameMovesReader.runRead();
                grid = new Grid();
                String firstName = gameValues.get(0);
                String secondName = gameValues.get(1);
                ArrayList<Integer> playerOnePlies = populatePlies(gameValues, 2);
                ArrayList<Integer> playerTwoPlies = populatePlies(gameValues, 3);

                playerOne = new PlayerSimulated(firstName, Mark.playerOneMark, playerOnePlies);
                playerTwo = new PlayerSimulated(secondName, Mark.playerTwoMark, playerTwoPlies);
                Game game = new Game(grid, playerOne, playerTwo, consoleIO);
                game.runGame();
            } else {
                rewatchOn = false;
            }
        }

    }

    private ArrayList<Integer> populatePlies(ArrayList<String> gameValues, int startingPosition) {
       ArrayList<Integer> playerPlies = new ArrayList<>();

        for (int i = 0; i < gameValues.size(); i = i+2) {
            if (i + startingPosition < gameValues.size()) {
                String move = gameValues.get(i + startingPosition);
                Integer newMove = Integer.parseInt(move);
                playerPlies.add(newMove - 1);
            }
        }
        return playerPlies;
    }
}
