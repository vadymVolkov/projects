package com.volkov.model;

public class Locker {
    public int id;
    public int num;
    public String status;
    public int priority;
    public String type;
    public int cardnum;

    public Locker(int id, int num, String status, int priority, String type, int cardnum) {
        this.id = id;
        this.num = num;
        this.status = status;
        this.priority = priority;
        this.type = type;
        this.cardnum = cardnum;
    }

    public Locker(int id, int num, String status, String type) {
        this.id = id;
        this.num = num;
        this.status = status;
        this.type=type;
    }
    public int getCardnum() {
        return cardnum;
    }

    public void setCardnum(int cardnum) {
        this.cardnum = cardnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
