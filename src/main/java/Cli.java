import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

class Cli {

    private final Scanner scanner;
    private Game b = new Game();
    private final PrintStream out;
    private String userInput = "";

    Cli(InputStream in, PrintStream out, Game b) {
        this.scanner = new Scanner(in);
        this.out = out;
        this.b = b;
    }

    public void displayBoard() {
        ArrayList<String> boardConglomerator = new ArrayList<>();
        for (String point : b.getVars()) {
            boardConglomerator.add("[");
            boardConglomerator.add(point);
            boardConglomerator.add("]");
        }
        boardConglomerator.add(9,"\n");
        boardConglomerator.add(19,"\n");

        StringBuilder boardFinal = new StringBuilder();

        for (String s: boardConglomerator) {
            boardFinal.append(s);
        }
        out.print(boardFinal);
    }

    public void askInput() {
        out.print("\nHi! Please select a square from 1-9");
    }

    public void takeInput() {
        String input = scanner.next();
        this.userInput = input;
    }
}


