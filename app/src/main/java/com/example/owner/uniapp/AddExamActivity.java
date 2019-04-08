package com.example.owner.uniapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.uniapp.new1.MainActivity;
import com.example.owner.uniapp.new1.StudentEvent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddExamActivity extends AppCompatActivity {
    private static String[]Type=new String[]{"Exam","HomeWork","Assingment","Meet"};

    private static final String TAG = "AddExamActivity";
    private TextView tvAddEvent, tvDate2, tvSave;
    private EditText edEventName,ed1,edCourseTitle,lecturerName,edFreeText;

    private Button btnExamDate;

    private TimePickerDialog.OnTimeSetListener timeSetListener1, onTimeSetListener1;
    private int mYear, mMonth, mDay;
    private long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam3);
        btnExamDate = (Button) findViewById(R.id.btnExamDate);
        tvAddEvent= (TextView) findViewById(R.id.tvAddEvent);
        tvSave = (TextView) findViewById(R.id.tvSave);
        edEventName = (EditText) findViewById(R.id.edEventName);
        ed1 = (EditText) findViewById(R.id.ed1);
        edCourseTitle= (EditText) findViewById(R.id.edCourseTitle);
       lecturerName= (EditText) findViewById(R.id.lecturerName);
        edFreeText= (EditText) findViewById(R.id.edFreeText);
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }

    private void dataHandler() {
        boolean isok = true;
        String Type = edEventName.getText().toString();
        String CourseTitle = edCourseTitle.getText().toString();
        String LecturerName=lecturerName.getText().toString();
        String FreeText=edFreeText.getText().toString();
        String Time=ed1.getText().toString();
        if (Type.length() == 0) {
            edEventName.setError("Name can not be empty");
            isok = false;
        }
        if (isok) {
            final StudentEvent studentEvent=new StudentEvent();
            studentEvent.setCourseTitle(CourseTitle);
            studentEvent.setFreeText(FreeText);
            studentEvent.setLecturerName(LecturerName);
            studentEvent.setType(Type);
            studentEvent.setEventTime(time);
            //get user email to set is as the owner fo this exam
            FirebaseAuth auth = FirebaseAuth.getInstance();
            //to get the database root reference
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            //to get uid
            String key = reference.child("MyEvents").push().getKey();
            studentEvent.setKey(key);

            reference.child("MyEvents").child(auth.getUid()).child(key).setValue(studentEvent).addOnCompleteListener(new OnCompleteListener<Void>() {

                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(AddExamActivity.this, "Add Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(AddExamActivity.this,MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddExamActivity.this, "Add Faild" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    public void onClick(View v) {

        if (v == btnExamDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            c.set(Calendar.YEAR, year);
                            c.set(Calendar.MONTH, monthOfYear);
                            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            time=c.getTimeInMillis();
                            ed1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }


    }

}







