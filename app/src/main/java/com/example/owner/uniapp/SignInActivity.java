package com.example.owner.uniapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owner.uniapp.dashboard.DashboardTabActivity;
import com.example.owner.uniapp.dashboard.DashboardTabActivity2;
import com.example.owner.uniapp.new1.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    private EditText edEmail, edPassWord;
    private Button btnLogIN, btnSignUp;
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edEmail = (EditText) findViewById(R.id.edEmail);
        edPassWord = (EditText) findViewById(R.id.edPass);
        btnLogIN = (Button) findViewById(R.id.btnLogIn);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();//
        btnLogIN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dataHandler();

                    }
                });


            }


            private void dataHandler() {
                boolean isok = true;// if all the fields filled well
                if (edEmail.getText().toString().length() !=0 || edPassWord.getText().toString().length() !=0) {
                    String email = edEmail.getText().toString();
                    String passWord = edPassWord.getText().toString();

                    if (email.length() < 4 ||
                            email.indexOf('@') < 0 || email.indexOf('.') < 0) {
                        edEmail.setError("Wrong Email");
                        isok = false;

                    }
                    if (passWord.length() < 8) {
                        edPassWord.setError("Have to be at least 8 char ");
                        isok = false;

                    }
                    if (isok) {
                        SignIn(email, passWord);

                    }
                }else {
                    edEmail.setError("Enter Email");
                    edPassWord.setError("Enter Password");
                }
            }

            private void SignIn(String email, String Pass) {
                auth.signInWithEmailAndPassword(email, Pass).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignInActivity.this, "signIn successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SignInActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();

                        }


                    }
                });

            }
    }

