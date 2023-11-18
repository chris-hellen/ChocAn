package services;

public class Service {
    private int code;
    private int fee;
    private String name;

    public Service(String name, int code, int fee){
        this.name = name;
        this.code = code;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getFee() {
        return fee;
    }
}
