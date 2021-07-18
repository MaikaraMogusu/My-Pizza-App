package com.example.mypizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private TextView inputEmail;
   private TextView inputPassword;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });


        TextView btn=findViewById(R.id.signUp);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

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

    void loginUserAccount() {
        String email;
        String password;

        email=inputEmail.getText().toString();
        password=inputPassword.getText().toString();

        if (isEmpty(inputEmail)){
            Toast.makeText(this, "please Enter E-mail", Toast.LENGTH_SHORT).show();
        return;
        }
        if (isEmpty(inputPassword)){
            Toast.makeText(this, "Password Required", Toast.LENGTH_SHORT).show();
       return;
        }
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login Succesiful!", Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Login Failed! Try again", Toast.LENGTH_LONG).show();
                        }

                    }
                });



    }

    void initializeUI(){
        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        btnLogin=findViewById(R.id.btnLogin);
    }
}