package model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private String userName;
    private String message;
    private String type;
    private Date date;

    public Message(String userName, String message, String type, Date date) {
        this.userName = userName;
        this.message = message;
        this.type = type;
        this.date = date;
    }

    public Message() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Message{" +
                "userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
