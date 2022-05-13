package com.example.nsucomplaintlodgementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
private Button lc,update ,update2;
private EditText date, rv, ag, cm;
private String _AGAIN,_DATES,_REVIEW,_COMP;
DatabaseReference databaseReference;
private static int num =1  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ag = (EditText)findViewById(R.id.ag);
        date = (EditText)findViewById(R.id.date);
        rv = (EditText)findViewById(R.id.rv);
        cm = (EditText)findViewById(R.id.cm);
        lc = (Button) findViewById(R.id.lc);
        update = (Button) findViewById(R.id.update);
        update2 = (Button) findViewById(R.id.update2);
        databaseReference = FirebaseDatabase.getInstance().getReference("complaints");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

String tmp = getIntent().getStringExtra("em");
String [] kk= tmp.split("@");

databaseReference.child(kk[0]+"").child("comp").setValue(cm.getText().toString().trim());

                Toast.makeText(MainActivity3.this, "Complain Edited Successfully", Toast.LENGTH_LONG).show();
            }
        });
update2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String tmp3 = getIntent().getStringExtra("em");
        String [] kk= tmp3.split("@");
        databaseReference.child(kk[0]+"").child("review").setValue(rv.getText().toString().trim());
        Toast.makeText(MainActivity3.this, "Reviewer Changed Successfully", Toast.LENGTH_LONG).show();
    }
});
        lc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String again = ag.getText().toString().trim();
                String dates = date.getText().toString().trim();
                String review = rv.getText().toString().trim();
                String comp = cm.getText().toString().trim();
String key = databaseReference.push().getKey();
Complain cm = new Complain(again,dates,review,comp);
String tmpp = getIntent().getStringExtra("em");

String [] ss = tmpp.split("@");

databaseReference.child(ss[0]).setValue(cm);
                Toast.makeText(MainActivity3.this, "Complaint Successfully Submitted", Toast.LENGTH_LONG).show();
num++;

            }
        });
    }

}