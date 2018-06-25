package Core;

import Core.Players.Player;

import java.util.ArrayList;

public class Communicator {

    private UI ui;

    public Communicator(UI ui) {
        this.ui = ui;
    }

    public String getInput() {
        return ui.getInput();
    }

    public int getValidNumber() {
        String input = getInput();
        boolean inputNotNumber = checkIfInputNotNumber(input);
        while (inputNotNumber) {
            announceNumberNotValid();
            input = getInput();
            inputNotNumber = checkIfInputNotNumber(input);
        }
        return Integer.parseInt(input);
    }

    public void askGameMode() {
        ui.presentMessage(Message.askGameMode);
    }

    public void announceGameModeChoiceInvalid() {
        ui.presentMessage(Message.announceGameModeChoiceInvalid);
    }

    public void displayGrid(ArrayList<Mark> gridSquares) {
        ui.displayGrid(gridSquares);
    }

    public void presentMove(Player player, Grid grid) {
        ui.clearScreen();
        ui.pause();
        ui.presentMessage(Message.announceSquareChoice(player));
        ui.pause();
        displayGrid(grid.getSquares());
    }

    public void askSquareChoice(Player player) {
        ui.presentMessage(Message.askSquareChoice(player));
    }

    public void announceSquareChoiceInvalid(Player player) {
        ui.presentMessage(Message.announceSquareChoiceInvalid(player));
    }

    public void announceTie() {
        ui.presentMessage(Message.announceTie);
    }

    public void announceWinner(Player player) {
        ui.presentMessage(Message.announceWinner(player));
    }

    public void askRewatch() {
        ui.presentMessage(Message.askRewatch());
    }

    public String findYesorNoAnswer() {
        String input = getInput().toLowerCase();
        boolean inputNotCorrect = inputNotYesOrNo(input);
        while (inputNotCorrect) {
            askForNewYOrN();
            input = getInput().toLowerCase();
            inputNotCorrect = inputNotYesOrNo(input);
        }
        return input;
    }

    private boolean checkIfInputNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }

    private void announceNumberNotValid() {
        ui.presentMessage(Message.announceNumberNotValid);
    }

    private boolean inputNotYesOrNo(String input) {
        return !input.equals("y") && !input.equals("n");
    }

    private void askForNewYOrN() {
        ui.presentMessage(Message.askNewYOrN());
    }
}
