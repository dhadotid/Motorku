package com.rsypj.motorku.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rsypj.motorku.R;
import com.rsypj.motorku.helper.Helper;
import com.rsypj.motorku.model.TransactionModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class TransactionFooterViewHolder extends RecyclerView.ViewHolder{

    TextView tvTotal;
    Button btnBayar;
    ArrayList<TransactionModel> data = new ArrayList<>();
    int totBay;

    public TransactionFooterViewHolder(View view){
        super(view);

        tvTotal = view.findViewById(R.id.custom_footbar_tvTotal);
        btnBayar = view.findViewById(R.id.custom_footbar_btnBayar);

        setUpDataToUI();
    }

    private void setUpDataToUI(){

//        for (int i = 0; i < data.size(); i++){
//            totBay += data.get(i).getHarga();
//        }
        tvTotal.setText("Rp. " + Helper.totalBayar);

    }
}
