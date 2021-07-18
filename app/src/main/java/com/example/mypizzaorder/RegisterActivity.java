package com.example.mypizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {

    TextView inputUsername;
    TextView inputEmail;
    TextView inputPassword;
    TextView inputConfirmPassword;
    Button btnRegister;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();
       // maikara();


        TextView btn=findViewById(R.id.AlreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

            }
        });

        inputUsername=findViewById(R.id.inputUsername);
        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        inputConfirmPassword=findViewById(R.id.inputConfirmPassword);
        btnRegister=findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered(); registerNewuser();
            }
        });

    }
    boolean isinputEmail(TextView text){
        CharSequence email=text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    boolean isEmpty(TextView text){
        CharSequence str=text.getText().toString();
        return  TextUtils.isEmpty(str);
    }
    void registerNewuser(){

        String username;
        String email;
        String password;
        String confirm_password;

        password=inputPassword.getText().toString();
        email=inputEmail.getText().toString();
        password=inputPassword.getText().toString();
        confirm_password=inputConfirmPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Registration Successiful !", Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                    }
                });

    }
    void checkDataEntered(){
        if (isEmpty(inputUsername)){
            Toast.makeText(this, "Username Required", Toast.LENGTH_SHORT).show();
        }
        if (isEmpty(inputPassword)){
            inputPassword.setError("Password Required");
        }
        if (isEmpty(inputConfirmPassword)){
            inputConfirmPassword.setError("Please confirm password");

        }
        if (isinputEmail(inputEmail)==false){
        inputEmail.setError("Enter a valid Email");
    }
        //password and confirm password should be the same
       if (!inputPassword.getText().toString().equals(inputConfirmPassword.getText().toString())) {
           Toast.makeText(this,"Password do not match",Toast.LENGTH_SHORT).show();
       }
       else {

           Toast.makeText(getApplicationContext(),"Registration Failed! Try again.",Toast.LENGTH_LONG).show();
       }

    }
}