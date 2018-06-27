package Core.Players;

import Core.FileManipulators.GameDataReader;
import Core.GameMode;
import Core.Mark;
import Core.UserInterfaces.Communicator;

import java.io.File;
import java.util.ArrayList;

public class PlayerFactory {

    private Communicator communicator;
    private GameDataReader gameDataReader;
    private Player playerOne;
    private Player playerTwo;
    private final String playerOneName = "Player One";
    private final String playerTwoName = "Player Two";

    public PlayerFactory(Communicator communicator) {
        this.communicator = communicator;
        gameDataReader = new GameDataReader();
    }

    public ArrayList<Player> producePrimaryPlayers(GameMode gameMode) {
        ArrayList<Player> players = new ArrayList<>();

        boolean humanPlayerOne = true;
        boolean humanPlayerTwo = true;

        switch (gameMode) {
            case HUMANVSCOMP:
                humanPlayerTwo = false;
                break;
            case COMPVSCOMP:
                humanPlayerOne = false;
                humanPlayerTwo = false;
                break;
            case HUMANVSHUMAN:
                break;
            default:
                throw new RuntimeException("Something wrong with creating the players");
        }

        generatePlayerOne(humanPlayerOne);
        generatePlayerTwo(humanPlayerTwo);
        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    private Player generatePlayerOne(boolean human) {
        if (human) {
            playerOne = new PlayerHuman(Mark.PLAYERONEMARK, communicator);
        } else {
            playerOne = new PlayerComputer(Mark.PLAYERONEMARK);
        }
        return playerOne;
    }

    private Player generatePlayerTwo(boolean human) {
        if (human) {
            playerTwo = new PlayerHuman(Mark.PLAYERTWOMARK, communicator);
        } else {
            playerTwo = new PlayerComputer(Mark.PLAYERTWOMARK);
        }
        return playerTwo;
    }

    public ArrayList<Player> produceSimulatedPlayers(File gameData) {
        ArrayList<String> gameValues = gameDataReader.extractData(gameData);
        ArrayList<Player> players = new ArrayList<>();

        ArrayList<Integer> gameMoves = convertToIntegers(gameValues);

        ArrayList<Integer> simulatedPlayerOnePlies = populatePlies(gameMoves, 0);
        ArrayList<Integer> simulatedPlayerTwoPlies = populatePlies(gameMoves, 1);

        Player playerOne = new PlayerSimulated(Mark.PLAYERONEMARK, simulatedPlayerOnePlies);
        Player playerTwo = new PlayerSimulated(Mark.PLAYERTWOMARK, simulatedPlayerTwoPlies);

        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    private ArrayList<Integer> convertToIntegers(ArrayList<String> gameValues) {
        ArrayList<Integer> gameMoves = new ArrayList<>();
        for (String ply : gameValues) {
            Integer move = null;
            try {
                move = Integer.parseInt(ply);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            gameMoves.add(move);
        }
        return gameMoves;
    }

    private ArrayList<Integer> populatePlies(ArrayList<Integer> gameValues, int playerPosition) {
        ArrayList<Integer> plies = new ArrayList<>();
        for (int i = playerPosition; i < gameValues.size(); i = i + 2) {
            plies.add(gameValues.get(i));
        }
        return plies;
    }
}
