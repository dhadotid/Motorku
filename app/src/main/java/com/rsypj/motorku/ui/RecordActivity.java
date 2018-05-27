package com.rsypj.motorku.ui;

import android.support.v7.widget.RecyclerView;

import com.rsypj.motorku.R;
import com.rsypj.motorku.base.MotorBaseApplication;
import com.rsypj.motorku.ui.controller.RecordController;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class RecordActivity extends MotorBaseApplication {

    RecordController controller;
    RecyclerView rcRecord;

    @Override
    public int getLayoutId() {
        return R.layout.activity_record;
    }

    @Override
    public void initiateItem() {
        rcRecord = findViewById(R.id.activity_record_rv1);

        controller = new RecordController(this);
    }

    public RecyclerView getRcRecord() {
        return rcRecord;
    }
}
