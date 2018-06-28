package Core.FileManipulators;

import Core.Players.Player;

import java.io.*;
import java.util.ArrayList;

public class GameFileAnalyser {

    public ArrayList<String> extractData(File file) {
        ArrayList<String> gameData = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                gameData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gameData;
    }

    public ArrayList<Integer> generateMovesFromFile(File gameData, int playerPosition) {
        ArrayList<String> gameValues = extractData(gameData);
        ArrayList<Integer> gameMoves = convertToIntegers(gameValues);
        return populatePlies(gameMoves, playerPosition);
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
