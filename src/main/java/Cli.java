import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

class Cli {

    private final Scanner scanner;
    private final PrintStream out;

    Cli(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void displayBoard(String[] squares) {
        ArrayList<String> boardConglomerator = new ArrayList<>();
        for (String square : squares) {
            boardConglomerator.add("[");
            boardConglomerator.add(square);
            boardConglomerator.add("]");
        }
        boardConglomerator.add(9,"\n");
        boardConglomerator.add(19,"\n");

        StringBuilder boardFinal = new StringBuilder();

        for (String s: boardConglomerator) {
            boardFinal.append(s);
        }
        out.print(boardFinal + "\n");
    }

    public String askAndTakeInput(Player activePlayer){
        askInput(activePlayer);
       return takeInput();
    }

    public void askInput(Player activePlayer) {
        out.print("\nHi " + activePlayer.getName() + "! Please select a square from 1-9\n");
    }

    public String takeInput() {
        return scanner.next();
    }

    public void askGameMode() {
        out.print("\nHi! please enter '1' to " +
                "play human-vs-human or '2' to play against the computer.\n");
    }

    public void announceWinner(Player activePlayer) {
        out.print("Congratulations " + activePlayer.getName() + " - You're the winner!\n");
    }
}


