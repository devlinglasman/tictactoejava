import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleDisplay {

    private final Scanner scanner;
    private final PrintStream out;

    ConsoleDisplay(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void displayGrid(ArrayList<String> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();
        for (String square : squares) {
            gridConglomerator.add("[" + square + "]");
        }
        gridConglomerator.add(3, "\n");
        gridConglomerator.add(7, "\n");

        StringBuilder gridFinal = new StringBuilder();

        for (String s : gridConglomerator) {
            gridFinal.append(s);
        }
        out.print(gridFinal + "\n");
    }

    public String askAndTakeInput(Player activePlayer) {
        askForInput(activePlayer);
        return takeInput();
    }

    public void askForInput(Player activePlayer) {
        out.print("\nHi " + activePlayer.getName() + "! Please select a square from 1-9\n");
    }

    public String takeInput() {
        return scanner.next();
    }

    public void askGameMode() {
        out.print("\nHi! please enter '1' to " +
                "play against the computer or '2' to play human-vs-human.\n");
    }

    public void announceWinner(Player activePlayer) {
        out.print("Congratulations " + activePlayer.getName() + " - You're the winner!\n");
    }

    public void announceComputerTurn() {
        out.print("Computer chooses...\n");
    }
}
