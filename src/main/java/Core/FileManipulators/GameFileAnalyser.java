package Core.FileManipulators;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameFileAnalyser {

    private File gameData;

    public GameFileAnalyser(String pathName) {
        gameData = new File(pathName);
    }

    public List<Integer> generateMovesFromFile(int playerPosition) {
        List<String> gameValues = performExtraction(gameData);
        List<Integer> gameMoves = convertToIntegers(gameValues);
        return populatePlies(gameMoves, playerPosition);
    }

    private List<String> performExtraction(File file) {
        List<String> gameMoves = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                gameMoves.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gameMoves;
    }

    private List<Integer> convertToIntegers(List<String> gameValues) {
        List<Integer> gameMoves = new ArrayList<>();
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

    private List<Integer> populatePlies(List<Integer> gameValues, int playerPosition) {
        List<Integer> plies = new ArrayList<>();
        for (int i = playerPosition; i < gameValues.size(); i = i + 2) {
            plies.add(gameValues.get(i));
        }
        return plies;
    }
}
