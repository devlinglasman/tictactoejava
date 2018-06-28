package Core.Players;

import Core.FileManipulators.GameFileAnalyser;
import Core.GameMode;
import Core.Mark;
import Core.UserInterfaces.Communicator;

import java.io.File;
import java.util.ArrayList;

public class PlayerFactory {

    private Communicator communicator;

    public PlayerFactory(Communicator communicator) {
        this.communicator = communicator;
    }

    public ArrayList<Player> buildPlayers(GameMode gameMode) {
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

    public ArrayList<Player> buildPlayers(ArrayList<Integer> playerOneMoves, ArrayList<Integer> playerTwoMoves) {
        ArrayList<Player> players = new ArrayList<>();
        Player playerOne = new PlayerSimulated(Mark.PLAYERONEMARK, playerOneMoves);
        Player playerTwo = new PlayerSimulated(Mark.PLAYERTWOMARK, playerTwoMoves);

        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    private Player generatePlayer(Mark mark, boolean human) {
        return human ? new PlayerHuman(mark, communicator)
                : new PlayerComputer(mark);
    }

}
