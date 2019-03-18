package com.example.owner.uniapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.owner.uniapp.dashboard.Exams;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddExamActivity extends AppCompatActivity {
    private  static final String TAG="AddExamActivity";
    private TextView tvAddExam,tvExamHour1,TvHour2,tvDate2,tvSave;
    private EditText edExamName;

    private Button btnExamDate,btnTimePicker1,btnTimePicker2;
    //private DatePickerDialog.OnDateSetListener mDateSetListener;
    //private TimePickerDialog.OnTimeSetListener timeSetListener1,onTimeSetListener1;
    private int mYear,mMonth,mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam3);
       btnExamDate=(Button)findViewById(R.id.btnExamDate);
       btnTimePicker1=(Button)findViewById(R.id.btnTimePicker1);
        btnTimePicker2=(Button)findViewById(R.id.btnTimePicker2);
       tvAddExam=(TextView)findViewById(R.id.tvAddExam);
        tvSave=(TextView)findViewById(R.id.tvSave);
        tvExamHour1=(TextView)findViewById(R.id.tvExamHour1);
        TvHour2=(TextView)findViewById(R.id.TvHour2);
       tvDate2=(TextView)findViewById(R.id.tvDate2);
        edExamName=(EditText)findViewById(R.id.edExamName);

        btnTimePicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);
                TimePickerDialog dialog1=new TimePickerDialog(AddExamActivity.this,onTimeSetListener1,hour,minute, true);

                //todo ClipDrawable
                // dialog.getWindow().setBackgroundDrawable(new ClipDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });
        btnTimePicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar  calendar1 =Calendar.getInstance();
                int hour1= calendar1.get(Calendar.HOUR_OF_DAY);
                int minute1= calendar1.get(Calendar.MINUTE);
                TimePickerDialog dialog2=new TimePickerDialog(AddExamActivity.this,timeSetListener1,minute1,hour1, true);

                dialog2.show();
            }
        });
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });



        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i3, int i2) {


            }
        };
        timeSetListener1=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }




        };
         onTimeSetListener1 =new TimePickerDialog.OnTimeSetListener() {
             @Override
             public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

             }





        };
    }
    private void dataHandler() {
        boolean isok=true;
        String ExamName=edExamName.getText().toString();
        if(ExamName.length()==0){
            edExamName.setError("Name can not be empty");
            isok=false;
        }
        if(isok){
            Exams exams=new Exams();
            exams.setExamDate(Exam);
            exams.setExamStartHour(ExamStartHour);
            exams.setExamEndHour(ExamEndHour);
            exams.setExamName(ExamName);
            //get user email to set is as the owner fo this exam
            FirebaseAuth auth=FirebaseAuth.getInstance();
            //to get the database root reference
            DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
            //to get uid
            String key=reference.child("MyExams").push().getKey();
            exams.setKey(key);
            reference.child("My Exams").child(key).setValue(exams).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(AddExamActivity.this,"Add Successful",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(AddExamActivity.this,"Add Faild"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
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
                            c.set(Calendar.MONTH,monthOfYear);
                            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                            tvDate2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }


    }
    }