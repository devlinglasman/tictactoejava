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

    public PlayerFactory(Communicator communicator) {
        this.communicator = communicator;
        gameDataReader = new GameDataReader();
    }

    public ArrayList<Player> producePrimaryPlayers(GameMode gameMode) {
        ArrayList<Player> players = new ArrayList<>();

        boolean playerOneIsHuman;
        boolean playerTwoIsHuman;

        switch (gameMode) {
            case HUMANVSCOMP:
                playerOneIsHuman = true;
                playerTwoIsHuman = false;
                break;
            case COMPVSCOMP:
                playerOneIsHuman = false;
                playerTwoIsHuman = false;
                break;
            case HUMANVSHUMAN:
                playerOneIsHuman = true;
                playerTwoIsHuman = true;
                break;
            default:
                throw new RuntimeException("Something wrong with creating the players");
        }

        players.add(generatePlayer(Mark.PLAYERONEMARK, playerOneIsHuman));
        players.add(generatePlayer(Mark.PLAYERTWOMARK, playerTwoIsHuman));
        return players;
    }

    private Player generatePlayer(Mark mark, boolean human) {
        return human ? new PlayerHuman(mark, communicator)
                : new PlayerComputer(mark);
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
