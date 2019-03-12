package com.example.owner.uniapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingUpActivity extends AppCompatActivity {
    private EditText edFirstName,edLastName,edPhone,edEmail2,edPassWord2,edPassWord3;
    private Button btnSave;
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user
    private boolean isok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        edFirstName=(EditText)findViewById(R.id .edFirstName) ;
        edLastName=(EditText)findViewById(R.id .edLastName) ;
        edPhone=(EditText) findViewById(R.id .edPhone) ;
        edEmail2=(EditText) findViewById(R.id .edEmail2) ;
        edPassWord2=(EditText)findViewById(R.id .edPassWord2) ;
        btnSave=(Button)findViewById(R.id .btnSave) ;
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();//
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

            }

        });
        //
    }
    private  void  dataHandler(){
        boolean isk=true;// if all the fields filled well
        String email=edEmail2.getText().toString();
        String pass1=edPassWord2.getText().toString();
        String fname=edFirstName.getText().toString();
        String lname=edLastName.getText().toString();
        String phone=edPhone.getText().toString();
        boolean isok=true;
        if (email.length()<4||
                email.indexOf('@') <0 || email.indexOf('.')<0)
        {
            edEmail2.setError("Wrong Email");
            isok = false;

        }
        if (pass1.length()<8)
        {
            edPassWord2.setError("Have to be at least 8 char ");
            isok = false;

        }

        if (isok)
        {
            creatAcount(email,pass1);
        }

    }

    /**
     * crete firebase user  useing email and password
     * @param email user email
     * @param passw user password
     */
    private void creatAcount(String email,String passw){
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SingUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SingUpActivity.this,"Authentication successful",Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser();
                    finish();
                    Intent intent=new Intent(SingUpActivity.this,AddCourseActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SingUpActivity.this, "Authentication failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }}});



    }
}
