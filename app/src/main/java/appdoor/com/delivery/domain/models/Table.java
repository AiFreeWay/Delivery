package appdoor.com.delivery.domain.models;


public class Table {

    public static final int STATUS_OK = 0;
    public static final int STATUS_WAIT = 1;
    public static final int STATUS_BUSY = 2;
    public static final int STATUS_NONE = 3;

    private int number;
    private int status;

    public Table() {
    }

    public Table(int number, int status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
