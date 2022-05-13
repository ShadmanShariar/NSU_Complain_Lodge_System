package com.example.nsucomplaintlodgementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Faculty extends AppCompatActivity {
private Button rr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        rr = (Button) findViewById(R.id.rr);
      rr.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent intent = new Intent(Faculty.this,AllComplain.class);
startActivity(intent);
          }
      });
    }
}