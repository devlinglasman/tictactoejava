package Core.Players;

import java.util.ArrayList;
import java.util.List;

public class MovesGenerator {

    public List<Integer> generateMoves(List<String> allMoves, int playerPosition) {
        List<Integer> allMovesIntegers = convertToIntegers(allMoves);
        return populatePlies(allMovesIntegers, playerPosition);
    }

    private List<Integer> convertToIntegers(List<String> allMoves) {
        List<Integer> gameMoves = new ArrayList<>();
        for (String ply : allMoves) {
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

    private List<Integer> populatePlies(List<Integer> gameValues, int playerPosition) {
        List<Integer> plies = new ArrayList<>();
        for (int i = playerPosition; i < gameValues.size(); i = i + 2) {
            plies.add(gameValues.get(i));
        }
        return plies;
    }
}
