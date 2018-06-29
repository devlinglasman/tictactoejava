package Core.FileManipulators;

import java.io.*;
import java.util.ArrayList;

public class GameFileAnalyser {

    private File gameData;

    public GameFileAnalyser() {
        gameData = new File("src/main/resources/gameData.txt");
    }

    public ArrayList<Integer> generateMovesFromFile(File file, int playerPosition) {
        ArrayList<String> gameValues = performExtraction(file);
        ArrayList<Integer> gameMoves = convertToIntegers(gameValues);
        return populatePlies(gameMoves, playerPosition);
    }

    public ArrayList<Integer> generateMovesFromFile(int playerPosition) {
        ArrayList<String> gameValues = performExtraction(gameData);
        ArrayList<Integer> gameMoves = convertToIntegers(gameValues);
        return populatePlies(gameMoves, playerPosition);
    }

    private ArrayList<String> performExtraction(File file) {
        ArrayList<String> gameMoves = new ArrayList<>();

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
