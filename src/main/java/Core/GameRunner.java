package Core;

import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;

import java.util.Arrays;

public class GameRunner {

    private Grid grid;
    private UI ui;
    private Player playerOne;
    private Player playerTwo;

    public GameRunner(UI ui) {
        this.ui = ui;
        grid = new Grid();
    }

    public int getValidGameModeChoice() {
        ui.askGameMode();
        int gameModeChoice = ui.getValidNumber();
        boolean gameChoiceIllegal = gameModeChoiceNotValid(gameModeChoice);
        while (gameChoiceIllegal) {
            ui.announceGameModeChoiceInvalid();
            gameModeChoice = ui.getValidNumber();
            gameChoiceIllegal = gameModeChoiceNotValid(gameModeChoice);
        }
        return gameModeChoice;
    }

    public void run() {
    }

    private void setPlayers(String gameModeChoice) {
        switch (gameModeChoice) {
            case "1":
                playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, ui);
                playerTwo = new PlayerComputer("Computer", Mark.PLAYERTWOMARK, Mark.PLAYERONEMARK);
                break;
            case "2":
                playerOne = new PlayerComputer("ComputerOne", Mark.PLAYERONEMARK, Mark.PLAYERTWOMARK);
                playerTwo = new PlayerComputer("ComputerTwo", Mark.PLAYERTWOMARK, Mark.PLAYERONEMARK);
                break;
            case "3":
                playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, ui);
                playerTwo = new PlayerHuman("Player Two", Mark.PLAYERTWOMARK, ui);
        }
    }

    private boolean gameModeChoiceNotValid(int gameModeChoice) {
        return Arrays.stream(GameModes.values())
                .noneMatch(gameMode -> gameMode.getModeNumber() == gameModeChoice);
    }

}
