package com.example.nsucomplaintlodgementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button fbtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbtn = (Button) findViewById(R.id.button);

        Toast.makeText(MainActivity.this, "Welcome To NSU Complain Lodge System", Toast.LENGTH_LONG).show();

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LogIn.class);
                startActivity(intent);

            }

        });

    }
}