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
                        new PlayerHuman(Mark.PLAYERONEMARK, communicator),
                        new PlayerComputer(Mark.PLAYERTWOMARK)
                );
            case COMPVSCOMP:
                return Arrays.asList(
                        new PlayerComputer(Mark.PLAYERONEMARK),
                        new PlayerComputer(Mark.PLAYERTWOMARK)
                );
            case HUMANVSHUMAN:
                return Arrays.asList(
                        new PlayerHuman(Mark.PLAYERONEMARK, communicator),
                        new PlayerHuman(Mark.PLAYERTWOMARK, communicator)
                        );
            default:
                throw new RuntimeException("Something wrong with creating the players");
        }
    }

    public List<Player> buildPlayers(ArrayList<Integer> playerOneMoves, ArrayList<Integer> playerTwoMoves) {
        List<Player> players = new ArrayList<>();
        Player playerOne = new PlayerSimulated(Mark.PLAYERONEMARK, playerOneMoves);
        Player playerTwo = new PlayerSimulated(Mark.PLAYERTWOMARK, playerTwoMoves);

        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }
}
