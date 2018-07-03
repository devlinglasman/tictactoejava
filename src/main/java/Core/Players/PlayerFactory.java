package Core.Players;

import Core.GameMode;
import Core.Mark;
import Core.UserInterfaces.Communicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerFactory {

    private Communicator communicator;

    public PlayerFactory(Communicator communicator) {
        this.communicator = communicator;
    }

    public List<Player> buildPlayers(GameMode gameMode) {
        switch (gameMode) {
            case HUMANVSCOMP:
                return Arrays.asList(
                        new HumanPlayer(Mark.PLAYER_ONE, communicator),
                        new ComputerPlayer(Mark.PLAYER_TWO)
                );
            case COMPVSCOMP:
                return Arrays.asList(
                        new ComputerPlayer(Mark.PLAYER_ONE),
                        new ComputerPlayer(Mark.PLAYER_TWO)
                );
            case HUMANVSHUMAN:
                return Arrays.asList(
                        new HumanPlayer(Mark.PLAYER_ONE, communicator),
                        new HumanPlayer(Mark.PLAYER_TWO, communicator)
                );
            default:
                throw new RuntimeException("Something wrong with creating the players");
        }
    }

    public List<Player> buildPlayers(ArrayList<Integer> playerOneMoves, ArrayList<Integer> playerTwoMoves) {
        List<Player> players = new ArrayList<>();
        Player playerOne = new SimulatedPlayer(Mark.PLAYER_ONE, playerOneMoves);
        Player playerTwo = new SimulatedPlayer(Mark.PLAYER_TWO, playerTwoMoves);

        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }
}
