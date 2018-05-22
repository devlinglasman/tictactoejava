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

    public void displayGrid(ArrayList<Mark> squares) {
        ArrayList<String> gridConglomerator = new ArrayList<>();
        for (Mark squareMark : squares) {
            gridConglomerator.add("[" + squareMark.getStringRepresentation() + "]");
        }
        gridConglomerator.add(3, "\n");
        gridConglomerator.add(7, "\n");

        StringBuilder gridFinal = new StringBuilder();

        for (String s : gridConglomerator) {
            gridFinal.append(s);
        }
        out.print("\n" + gridFinal + "\n");
    }

    public void askForSquareChoice(String playerName) {
        out.print("\n" + playerName + " please select a square from 1-9.\n");
    }

    public String takeInput() {
        return scanner.next();
    }

    public void askGameMode() {
        out.print("\nHi! please enter '1' to " +
                "play against the computer or '2' to play human-vs-human.\n");
    }

    public void announceInputInvalid() {
        out.print("\nLooks like you made a boo-boo! Please enter a number from 1-9 that hasn't already been picked.\n");
    }

    public void announceWinner(String playerName) {
        out.print("\nCongratulations " + playerName + " - You're the winner!\n");
    }

    public void announceGameTied() {
        out.print("\nLooks like the game was a tie!\n");
    }

    public void announceSquareChoice(Player player) {
        out.print("\n" + player.getName() + " picked...\n");
    }
}
