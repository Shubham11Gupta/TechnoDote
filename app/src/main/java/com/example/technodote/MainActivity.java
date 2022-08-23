package com.example.technodote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int count=0;
    ImageButton b2,b3;
    TextView tv;
    String items[]= {"You are loved. You are wonderfully made. You are beautiful. You are a masterpiece. God has a great plan for you. ",
            "Don't lose hope. When the sun goes down, the stars come out.",
            "Life isn't about waiting for the storm to pass. It's about learning how to DANCE IN THE RAIN.",
            "The wish for healing has always been half of health.",
            "You can't smooth out the surf, but you can learn to ride the waves.",
            "When you get to the end of your rope, tie a knot and hang on."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b2=(ImageButton) findViewById(R.id.id3);
        b3=(ImageButton) findViewById(R.id.id4);
        tv=(TextView) findViewById(R.id.id6);
        Random random=new Random();
        int i=random.nextInt(items.length);
        tv.setText(items[i]);
        tv.setSelected(true);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("PRJ");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String v=snapshot.getValue(String.class);
                if(v=="1"){
                    count=1;
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        if(count ==1){
            String phone="9968528863";
            String message="HELP!!!";
            SmsManager smg = SmsManager.getDefault();
            smg.sendTextMessage(phone, null, message,null,null);
            Toast.makeText(getApplicationContext(),"Message Sent,",Toast.LENGTH_LONG).show();
        }
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone="9968528863";
                String sos="HELP!!!";
                SmsManager smg = SmsManager.getDefault();
                smg.sendTextMessage(phone, null, sos,null,null);
                Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone="9968528863";
                String dial="Dialing:"+phone;
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel: 9968528863"));
                startActivity(i);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem Item){
        switch (Item.getItemId()){
            case R.id.id1:
                Intent intent2=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.nhp.gov.in/national-" +
                        "mental-health-programme_pg"));
                startActivity(intent2);
                return true;
            case R.id.id2:
                Intent intent=new Intent(MainActivity.this,Intent1.class);
                startActivity(intent);
                return true;
            default:
                throw new IllegalStateException("Unexpected value: " + Item.getItemId());
        }
    }
}
