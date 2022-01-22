package com.babulgam.facebookdemo.sqllogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Details_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button showdataB,deletedatab,uppdatedataB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        showdataB=findViewById(R.id.showlist_id);
        deletedatab=findViewById(R.id.delete_id);
        uppdatedataB=findViewById(R.id.updatedata_id);

        showdataB.setOnClickListener(this);
        deletedatab.setOnClickListener(this);
        uppdatedataB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.showlist_id:


                break;


            case R.id.delete_id:


                break;


            case R.id.updatedata_id:


                break;


        }

    }
}