package Console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IOHelper {
    public ByteArrayOutputStream out;
    public ByteArrayInputStream in;
    public PrintStream print;

    public IOHelper(String input) {
        out = new ByteArrayOutputStream();
        in = new ByteArrayInputStream(input.getBytes());
        print = new PrintStream(out);
    }

    public String output() {
        return out.toString();
    }
}
