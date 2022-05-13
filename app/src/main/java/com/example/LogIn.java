package com.example.nsucomplaintlodgementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
private RadioGroup rg;
private RadioButton rb;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


         btn = (Button) findViewById(R.id.button2);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 rg = (RadioGroup) findViewById(R.id.radioGroup);
                 int id = rg.getCheckedRadioButtonId();

                 rb = (RadioButton) findViewById(id);
                 Intent intent = new Intent(LogIn.this,MainActivity2.class);

                 intent.putExtra("pos",(rb.getText()+""));

                 startActivity(intent);

             }
         });







    }
}