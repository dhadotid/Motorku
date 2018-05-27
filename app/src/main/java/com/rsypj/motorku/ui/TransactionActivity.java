package com.rsypj.motorku.ui;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rsypj.motorku.R;
import com.rsypj.motorku.base.MotorBaseApplication;
import com.rsypj.motorku.ui.controller.TransactionController;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class TransactionActivity extends MotorBaseApplication {

    RecyclerView rcList;
    TransactionController controller;
    TextView tvPlatNomer;
    TextView tvStatus;
    TextView tvTime;

    @Override
    public int getLayoutId() {
        return R.layout.activity_transaction;
    }

    @Override
    public void initiateItem() {
        tvPlatNomer = findViewById(R.id.activity_transaction_tvPlatNomer);
        tvStatus = findViewById(R.id.activity_transaction_tvNote);
        tvTime = findViewById(R.id.activity_transaction_tvTime);
        rcList = findViewById(R.id.activity_transaction_rvTrans);

        controller = new TransactionController(this);
    }

    public RecyclerView getRcList() {
        return rcList;
    }

    public TextView getTvPlatNomer() {
        return tvPlatNomer;
    }

    public TextView getTvStatus() {
        return tvStatus;
    }

    public TextView getTvTime() {
        return tvTime;
    }
}
