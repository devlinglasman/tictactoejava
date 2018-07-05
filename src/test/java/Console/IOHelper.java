package Console;

import java.io.*;

public class IOHelper {
    public OutputStream out;
    public InputStream in;
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
