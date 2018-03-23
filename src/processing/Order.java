package processing;

import java.io.Serializable;

public class Order implements Serializable{
    private String id;
    private String num;
    private String date;
    public Order(){
        this.id="0";
        this.num="0";
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNum(String  num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public String getNum() {
        return num;
    }
}
