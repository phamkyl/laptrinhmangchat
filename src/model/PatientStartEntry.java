package model;

import java.io.Serializable;

public class PatientStartEntry implements Serializable {
    private int month;
    private int count;

    public PatientStartEntry(int month, int count) {
        this.month = month;
        this.count = count;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PatientChart{" +
                "month=" + month +
                ", count=" + count +
                '}';
    }
}
