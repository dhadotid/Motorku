package com.rsypj.motorku.ui.controller;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.rsypj.motorku.adapter.RecordAdapter;
import com.rsypj.motorku.model.RecordModel;
import com.rsypj.motorku.ui.RecordActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class RecordController {

    RecordAdapter adapter;
    RecordActivity activity;
    ArrayList<RecordModel> data = new ArrayList<>();

    public RecordController(RecordActivity activity) {
        this.activity = activity;

        dummyData();
        setAdapter();
    }

    private void setAdapter(){
        adapter = new RecordAdapter(activity, data);

        activity.getRcRecord().setLayoutManager(new LinearLayoutManager(activity));
        activity.getRcRecord().setItemAnimator(new DefaultItemAnimator());
        activity.getRcRecord().setAdapter(adapter);
    }

    private void dummyData(){
        data.add(new RecordModel(1, "B 4444 FBJ", "Sedang Diperbaiki", getCalender()));
        data.add(new RecordModel(1, "B 1234 AUZ", "Sedang Diperbaiki", getCalender2()));
        data.add(new RecordModel(1, "B 1872 TDT", "Sedang Diperbaiki", getCalender3()));
        data.add(new RecordModel(1, "B 4531 BGS", "Sedang Diperbaiki", getCalender4()));
        data.add(new RecordModel(1, "B 4583 RGY", "Sedang Diperbaiki", getCalender2()));

    }

    private long getCalender(){
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.add(Calendar.HOUR_OF_DAY, 2);

        long times = calendar.getTime().getTime();
        return times;
    }

    private long getCalender2(){
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.add(Calendar.HOUR_OF_DAY, 3);

        long times = calendar.getTime().getTime();
        return times;
    }

    private long getCalender3(){
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.add(Calendar.SECOND, 20);
        calendar.add(Calendar.MINUTE, 20);
        calendar.add(Calendar.HOUR_OF_DAY, 0);

        long times = calendar.getTime().getTime();
        return times;
    }

    private long getCalender4(){
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.add(Calendar.HOUR_OF_DAY, 1);

        long times = calendar.getTime().getTime();
        return times;
    }
}
