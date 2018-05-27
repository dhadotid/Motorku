package com.rsypj.motorku.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by dhadotid on 15/03/2018.
 */

public abstract class MotorBaseApplication extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initiateItem();

        progressDialog = new ProgressDialog(this);
    }

    public void showToast(String message){
        Toast.makeText(this, "" + message, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog(String title, String message, Boolean isCancelable){
        if (progressDialog.isShowing()){
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(isCancelable);
            progressDialog.show();
        }
    }

    public void dismisProgressDialog(){
        if (progressDialog.isShowing() && progressDialog != null){
            progressDialog.dismiss();
        }
    }
    public abstract int getLayoutId();
    public abstract void initiateItem();
}
