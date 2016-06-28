package appdoor.com.delivery.domain.models;


public class TableDomain {

    public static final int STATUS_OK = 0;
    public static final int STATUS_WAIT = 1;
    public static final int STATUS_BUSY = 2;
    public static final int STATUS_NONE = 3;

    private int number;
    private int status;
    private String uuid;

    public TableDomain() {
    }

    public TableDomain(int number, int status, String uuid) {
        this.number = number;
        this.status = status;
        this.uuid = uuid;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
