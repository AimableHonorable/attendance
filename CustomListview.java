package com.example.attendance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListview extends ArrayAdapter<String> {

    private String[] regNo;
    private String[] StdCard;
    private String[] WId;
    private Activity context;
    private boolean status;
    public CustomListview(Activity context, String[] regNo, String[] StdCard, String[] WId, boolean status) {
        super(context, R.layout.layout,StdCard);
        this.context = context;
        this.regNo = regNo;
        this.StdCard = StdCard;
        this.WId = WId;
        this.status = status;
    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)r.getTag();
        }

        viewHolder.tvw1.setText(regNo[position]);
        viewHolder.tvw2.setText(StdCard[position]);
        viewHolder.tvw3.setText(WId[position]);


         viewHolder.aSwitch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if (((Switch)v).isChecked()){
                     status = true;
                 }else{
                     status = false;
                 }
                 Toast.makeText(v.getContext(),"StudentId:"+StdCard[position]+" WorkloadId:"+WId[position]+" Status:"+status, Toast.LENGTH_SHORT).show();

             }
         });

        return r;
    }
    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        Switch aSwitch;

        ViewHolder(View v){
            tvw1 = (TextView)v.findViewById(R.id.tv_regNo);
            tvw2 = (TextView)v.findViewById(R.id.tv_stCard);
            tvw3 = (TextView)v.findViewById(R.id.tv_wId);
            aSwitch = (Switch)v.findViewById(R.id.sw_student);
        }
    }
}
