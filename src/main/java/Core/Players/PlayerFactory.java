package Core.Players;

import Core.FileManipulators.GameDataReader;
import Core.GameMode;
import Core.Mark;
import Core.Communicator;

import java.io.File;
import java.util.ArrayList;

public class PlayerFactory {

    private Communicator communicator;
    private GameDataReader gameDataReader;

    private final String playerOneName = "Player One";
    private final String playerTwoName = "Player Two";
    private final String computerName = "Computer";
    private final String computerOneName = "Computer One";
    private final String computerTwoName = "Computer Two";

    public PlayerFactory(Communicator communicator) {
        this.communicator = communicator;
        gameDataReader = new GameDataReader();
    }

    public ArrayList<Player> producePrimaryPlayers(GameMode gameMode) {
        ArrayList<Player> players = new ArrayList<>();
        Player playerOne;
        Player playerTwo;

        switch (gameMode) {
            case HUMANVSCOMP:
                playerOne = new PlayerHuman(playerOneName, Mark.PLAYERONEMARK, communicator);
                playerTwo = new PlayerComputer(computerName, Mark.PLAYERTWOMARK, Mark.PLAYERONEMARK);
                break;
            case COMPVSCOMP:
                playerOne = new PlayerComputer(computerOneName, Mark.PLAYERONEMARK, Mark.PLAYERTWOMARK);
                playerTwo = new PlayerComputer(computerTwoName, Mark.PLAYERTWOMARK, Mark.PLAYERONEMARK);
                break;
            case HUMANVSHUMAN:
                playerOne = new PlayerHuman(playerOneName, Mark.PLAYERONEMARK, communicator);
                playerTwo = new PlayerHuman(playerTwoName, Mark.PLAYERTWOMARK, communicator);
                break;
            default:
                throw new RuntimeException("Something wrong with creating the players");
        }

        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    public ArrayList<Player> produceSimulatedPlayers(File gameData) {
        ArrayList<String> gameValues = gameDataReader.extractData(gameData);
        ArrayList<Player> players = new ArrayList<>();

        String simulatedPlayerOneName = gameValues.get(0);
        gameValues.remove(0);
        String simulatedPlayerTwoName = gameValues.get(0);
        gameValues.remove(0);

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

        ArrayList<Integer> simulatedPlayerOnePlies = populatePlies(gameMoves, 0);
        ArrayList<Integer> simulatedPlayerTwoPlies = populatePlies(gameMoves, 1);

        Player playerOne = new PlayerSimulated(simulatedPlayerOneName, Mark.PLAYERONEMARK, simulatedPlayerOnePlies);
        Player playerTwo = new PlayerSimulated(simulatedPlayerTwoName, Mark.PLAYERTWOMARK, simulatedPlayerTwoPlies);

        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    private ArrayList<Integer> populatePlies(ArrayList<Integer> gameValues, int playerPosition) {
        ArrayList<Integer> plies = new ArrayList<>();
        for (int i = playerPosition; i < gameValues.size(); i = i + 2) {
            plies.add(gameValues.get(i));
        }
        return plies;
    }

}
