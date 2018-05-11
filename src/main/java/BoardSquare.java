public class BoardSquare {

    private int status;

    public BoardSquare() {
        status = 1;
    }


    public String retrieveStatusOutput() {
        String any;
        if (getStatus() == 1) any = " ";
        else any = "X";
        return any;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int statusSetter) {
       status = statusSetter;
    }

}
