package Core.Players;

import Core.Board.Mark;
import Core.GameModes.GameMode;
import Core.UserInterfaces.Communicator;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {

    private Communicator communicator;
    private MovesGenerator movesGenerator;

    public PlayerFactory(Communicator communicator, MovesGenerator movesGenerator) {
        this.communicator = communicator;
        this.movesGenerator = movesGenerator;
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

    public List<Player> buildSimulatedPlayers(List<String> allMoves) {
        List<Integer> playerOneMoves = movesGenerator.generateMoves(allMoves, 0);
        List<Integer> playerTwoMoves = movesGenerator.generateMoves(allMoves, 1);
        return Arrays.asList(new SimulatedPlayer(Mark.PLAYER_ONE, playerOneMoves),
                new SimulatedPlayer(Mark.PLAYER_TWO, playerTwoMoves));
    }
}
