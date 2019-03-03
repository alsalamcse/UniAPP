package com.example.owner.uniapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;

public class SignInActivity extends AppCompatActivity {
    private EditText edEmail, edPassWord;
    private Button btnLogIN, btnSignUp;
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



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

            }

            private void SignIn(String email, String Pass) {
                auth.signInWithEmailAndPassword(email, Pass).addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(loginActivity.this, "signIn successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(loginActivity.this, MainTabsActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(loginActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();

                        }


                    }
                });

            }
    }
}
