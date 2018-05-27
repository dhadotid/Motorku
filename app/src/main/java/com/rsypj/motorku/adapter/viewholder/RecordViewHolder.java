package com.rsypj.motorku.adapter.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rsypj.motorku.R;
import com.rsypj.motorku.helper.Helper;
import com.rsypj.motorku.model.RecordModel;
import com.rsypj.motorku.ui.TransactionActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class RecordViewHolder extends RecyclerView.ViewHolder {

    RelativeLayout rlMaster;
    TextView tvPlatNomer;
    TextView tvTime;
    TextView tvNote;
    long timeCount;

    public RecordViewHolder(View view) {
        super(view);
        rlMaster = view.findViewById(R.id.custom_record_rlMaster1);
        tvPlatNomer = view.findViewById(R.id.custom_record_tvPlatNomer);
        tvTime = view.findViewById(R.id.custom_record_tvTime);
        tvNote = view.findViewById(R.id.custom_record_tvNote);

        onRelativeLayoutClicked();
    }

    private void onRelativeLayoutClicked() {
        rlMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(itemView.getContext(), TransactionActivity.class);
                in.putExtra("PN", tvPlatNomer.getText().toString().trim());
                itemView.getContext().startActivity(in);
                //((Activity)itemView.getContext()).finish();
            }
        });
    }

    public void setDataToUI(RecordModel data){
        tvPlatNomer.setText(data.getPlatNomer());
        tvNote.setText(data.getNote());
        timeCount = data.getTime();
        operation(data.getTime());

        Helper.nama = data.getPlatNomer();
        Helper.status = data.getNote();
        Helper.time = data.getTime();
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
                tvTime.setText(twoDigitString(hours) + ":" + twoDigitString(minute) + ":" + twoDigitString(second));
                //checker = false;
            }

            @Override
            public void onFinish() {
                tvTime.setText("");
                tvNote.setText("Service Telah Selesai");
                //checker = true;

                //blink
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(1000);
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                tvNote.startAnimation(anim);
            }
        }.start();
//        countDownTimer.start();

//        while (total > 0){
//            total -= 1;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            finally {
//                txtTime.setText(ubahkeJam(total));
//            }
//        }
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
