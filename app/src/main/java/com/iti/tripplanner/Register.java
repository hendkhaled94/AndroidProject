package com.iti.tripplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Hossam on 3/24/2018.
 */

public class Register extends Activity implements View.OnClickListener {


    EditText name,pass;
    TextView Login;
    Button Register;
    Intent incomingIntent;

    private FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register);

        incomingIntent = getIntent();


        name =(EditText)findViewById(R.id.Email);
        pass = (EditText)findViewById(R.id.Pass);
        Login = (TextView)findViewById(R.id.Login);
        Register =(Button)findViewById(R.id.Register);
        firebaseAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);


    }


    private void  registerUser(){

        String email = name.getText().toString().trim();
        String password = pass.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(Register.this,"please enter email",Toast.LENGTH_SHORT).show();

            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(Register.this,"please enter password",Toast.LENGTH_SHORT).show();

            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //profile
                    Toast.makeText(Register.this,"Success Rigester",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Register.this,"Field Rigester",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view == Login){
            incomingIntent = new Intent(Register.this,MainActivity.class);
            startActivity(incomingIntent);
        }

        if(view == Register){
            registerUser();
        }

    }
}
