package com.example.nsucomplaintlodgementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity2 extends AppCompatActivity {
private EditText ed1 , ed2;
private Button btn ;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
ed1 = (EditText)findViewById(R.id.signinemailedittext);
ed2 = (EditText)findViewById(R.id.signinpasswordedittext);
btn = (Button) findViewById(R.id.login);
mAuth = FirebaseAuth.getInstance();
String sel = getIntent().getStringExtra("pos").toString();
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(sel.equals("Faculty")||sel.equals("Student")||sel.equals("Non Teaching Faculty")||
                sel.equals("Admin Stuff")){

            if(!ed1.getText().toString().contains("@northsouth.edu")){

                Toast.makeText(MainActivity2.this, "Enter your NSU email", Toast.LENGTH_SHORT).show();
            }
            else{

                userlogin();
            }
        }
        else{
            userlogin();
        }
    }
});
    }
    private void userlogin() {
        String email = ed1.getText().toString().trim();
        String password = ed2.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    if(getIntent().getStringExtra("pos").toString().trim().equals("Faculty")){

                        Intent intent = new Intent(MainActivity2.this,Faculty.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra("em", email);
                        startActivity(intent);
                    }
                } else {

                    Toast.makeText(MainActivity2.this, "Register an account first", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


}