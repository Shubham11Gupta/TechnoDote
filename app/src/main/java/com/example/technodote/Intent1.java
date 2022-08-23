package com.example.technodote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Intent1 extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);
        tv1=(TextView)findViewById(R.id.id1);
        tv2=(TextView)findViewById(R.id.id2);
        tv3=(TextView)findViewById(R.id.id3);
        tv4=(TextView)findViewById(R.id.id4);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone="243118883";
                String dial="Dialing:"+phone;
                Intent i1=new Intent(Intent.ACTION_DIAL);
                i1.setData(Uri.parse("tel: 243118883"));
                startActivity(i1);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone="9830027975";
                String dial="Dialing:"+phone;
                Intent i2=new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel: 9830027975"));
                startActivity(i2);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone="044 2656 4444";
                String dial="Dialing:"+phone;
                Intent i3=new Intent(Intent.ACTION_DIAL);
                i3.setData(Uri.parse("tel: 044 2656 4444"));
                startActivity(i3);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone="9892003868";
                String dial="Dialing:"+phone;
                Intent i4=new Intent(Intent.ACTION_DIAL);
                i4.setData(Uri.parse("tel: 9892003868"));
                startActivity(i4);
            }
        });
    }
}