package Console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IOHelper {
    public static ByteArrayOutputStream out;
    public static ByteArrayInputStream in;
    public static PrintStream print;

    public IOHelper(String input) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        IOHelper.out = out;
        IOHelper.in = in;
        print = new PrintStream(out);
    }

    public String output() {
        return out.toString();
    }
}
