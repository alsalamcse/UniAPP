package com.example.owner.uniapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class AddExamActivity extends AppCompatActivity {
    private  static final String TAG="AddExamActivity";
    private TextView tvAddExam,tvExamHour1,TvHour2,tvDate2,tvSave;
    private EditText edExamName;
    private Button btnExamDate,btnTimePicker1,btnTimePicker2;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener1,onTimeSetListener1;


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
        btnExamDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year= calendar.get(calendar.YEAR);
                int month= calendar.get(calendar.MONTH);
                int day= calendar.get(calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(AddExamActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
               //todo ClipDrawable
                // dialog.getWindow().setBackgroundDrawable(new ClipDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        btnTimePicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);
                TimePickerDialog dialog1=new TimePickerDialog(AddExamActivity.this,TimePickerDialog.OnTimeSetListener lis,mDateSetListener,hour,minute,boolean is24HourView);
                //todo ClipDrawable
                // dialog.getWindow().setBackgroundDrawable(new ClipDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });
        btnTimePicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar  calendar1 =Calendar.getInstance();
                int year= calendar1.get(Calendar.HOUR_OF_DAY);
                int month= calendar1.get(Calendar.MINUTE);
                TimePickerDialog dialog2=new TimePickerDialog(AddExamActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month);

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
            public void onDateSet(DatePicker view, int i, int i3, int i2) {


            }
        };
         onTimeSetListener1 =new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i3, int i2) {


            }
        };
    }
    private void dataHandler() {
        String ExamName=edExamName.getText().toString();
        Date date=Calendar.getInstance().getTime();
        Integer ExamStartHour=

    }
}
