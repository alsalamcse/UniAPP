package com.example.owner.uniapp;

import android.app.usage.UsageEvents;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.owner.uniapp.new1.StudentEvent;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {
    CompactCalendarView compactCalendarView;
    private SimpleDateFormat dateFormatMonth=new SimpleDateFormat("MMM-YYY",Locale.getDefault());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);
        compactCalendarView=(CompactCalendarView)findViewById(R.id.compactcalendar_view);
        compactCalendarView.setUseThreeLetterAbbreviation(true);
        //set an event
       // StudentEvent ev1=new StudentEvent(Color.RED,Time);
    }
}
