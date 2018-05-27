package com.rsypj.motorku.ui.controller;

import android.os.CountDownTimer;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.rsypj.motorku.adapter.TransactionAdapter;
import com.rsypj.motorku.helper.Helper;
import com.rsypj.motorku.model.TransactionModel;
import com.rsypj.motorku.ui.TransactionActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class TransactionController {

    ArrayList<TransactionModel> data = new ArrayList<>();
    TransactionAdapter adapter;
    TransactionActivity activity;

    String platNomer;

    public TransactionController(TransactionActivity activity) {
        this.activity = activity;

        platNomer = activity.getIntent().getStringExtra("PN");
        activity.getTvPlatNomer().setText(Helper.nama);
        activity.getTvStatus().setText(Helper.status);
        operation(Helper.time);

        if (platNomer.equals("B 4444 FBJ")){
            dummyData();
        }else if (platNomer.equals("B 1234 AUZ")){
            dummyData1();
        }else if(platNomer.equals("B 1872 TDT")){
            dummyData2();
        }else if (platNomer.equals("B 4531 BGS")){
            dummyData3();
        }else if (platNomer.equals("B 4583 RGY")){
            dummyData4();
        }

        setAdapter();
    }

    private void setAdapter(){
        adapter = new TransactionAdapter(activity, data);

        activity.getRcList().setLayoutManager(new LinearLayoutManager(activity));
        activity.getRcList().setItemAnimator(new DefaultItemAnimator());
        activity.getRcList().setAdapter(adapter);
    }

    private void dummyData1(){
        data.add(new TransactionModel(1, "Kampas Rem", 30000));
        data.add(new TransactionModel(2, "Oli", 25000));
        data.add(new TransactionModel(3, "Tali Rem", 15000));
        data.add(new TransactionModel(4, "Kopling", 15000));
        data.add(new TransactionModel(5, "Rantai", 20000));
    }

    private void dummyData2(){
        data.add(new TransactionModel(4, "Kopling", 15000));
        data.add(new TransactionModel(5, "Rantai", 20000));
    }

    private void dummyData3(){
        data.add(new TransactionModel(1, "Kampas Rem Belakang", 30000));
    }

    private void dummyData4(){
        data.add(new TransactionModel(5, "Rantai", 20000));
    }

    private void dummyData(){
        data.add(new TransactionModel(4, "Kopling", 15000));
        data.add(new TransactionModel(5, "Rantai", 20000));
    }

    private void operation(long time){
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat hourParser = new SimpleDateFormat("HH");
        SimpleDateFormat minuteParser = new SimpleDateFormat("mm");

        long jamLokal = Integer.parseInt(hourParser.format(calendar.getTime()));
        long minuteLokal = Integer.parseInt(minuteParser.format(calendar.getTime()));

        long jamServer = Integer.parseInt(hourParser.format(time));
        long minuteServer = Integer.parseInt(minuteParser.format(time));

        long jamFinal = jamServer - jamLokal;
        long minuteFinal = minuteServer - minuteLokal;

        if (minuteFinal < 0){
            minuteFinal = 60 + minuteFinal;
            jamFinal -= 1;
        }

        setTime(jamFinal, minuteFinal);
    }

    private void setTime(final long jam, final long menit){
        final long hour = jam * 60 * 60;
        long minute = menit * 60;
        final long total = hour + menit;

        CountDownTimer countDownTimer = new CountDownTimer(total * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long time = millisUntilFinished;
                long hours = (time / (1000 * 60 * 60)) % 24;
                long second = (time / 1000) % 60;
                long minute = (time / (1000 * 60)) % 60;
                activity.getTvTime().setText(twoDigitString(hours) + ":" + twoDigitString(minute) + ":" + twoDigitString(second));
                //checker = false;
            }

            @Override
            public void onFinish() {
                activity.getTvTime().setText("");
                activity.getTvStatus().setText("Service Telah Selesai");
                //checker = true;

                //blink
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(1000);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                activity.getTvStatus().startAnimation(anim);
            }
        }.start();
    }

    private String twoDigitString(long number) {
        if (number == 00) {
            return "00";
        } else if (number / 10 == 0) {
            return "0" + number;
        }
        return String.valueOf(number);
    }
}
