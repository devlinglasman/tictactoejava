package Core.Players;

import Core.GameModes.GameMode;
import Core.Board.Mark;
import Core.UserInterfaces.Communicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerFactory {

    private Communicator communicator;

    public PlayerFactory(Communicator communicator) {
        this.communicator = communicator;
    }

    public List<Player> buildPrimaryPlayers(GameMode gameMode) {
        switch (gameMode) {
            case HUMANVSCOMP:
                return Arrays.asList(
                        new HumanPlayer(Mark.PLAYER_ONE, communicator),
                        new ComputerPlayer(Mark.PLAYER_TWO));
            case COMPVSCOMP:
                return Arrays.asList(
                        new ComputerPlayer(Mark.PLAYER_ONE),
                        new ComputerPlayer(Mark.PLAYER_TWO));
            case HUMANVSHUMAN:
                return Arrays.asList(
                        new HumanPlayer(Mark.PLAYER_ONE, communicator),
                        new HumanPlayer(Mark.PLAYER_TWO, communicator));
            default:
                throw new RuntimeException("Something wrong with creating the players");
        }
    }

    public List<Player> buildSimulatedPlayers(List<Integer> playerOneMoves, List<Integer> playerTwoMoves) {
        List<Player> players = new ArrayList<>();
        players.add(new SimulatedPlayer(Mark.PLAYER_ONE, playerOneMoves));
        players.add(new SimulatedPlayer(Mark.PLAYER_TWO, playerTwoMoves));
        return players;
    }
}
