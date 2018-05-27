package com.rsypj.motorku.model;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class RecordModel {

    int id;
    String platNomer;
    String note;
    long time;

    public RecordModel(int id, String platNomer, String note, long time) {
        this.id = id;
        this.platNomer = platNomer;
        this.note = note;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getPlatNomer() {
        return platNomer;
    }

    public String getNote() {
        return note;
    }

    public long getTime() {
        return time;
    }
}
