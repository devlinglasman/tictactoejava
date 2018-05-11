public class BoardSquare {

    private int status;

    public BoardSquare() {
        status = 1;
    }

    public String retrieveStatus() {
        String any = null;
        if (getStatus() == 1) any = " ";
        return any;
    }

    public int getStatus() {
        return status;
    }
}
