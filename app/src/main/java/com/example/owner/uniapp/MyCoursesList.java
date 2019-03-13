package com.example.owner.uniapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyCoursesList extends AppCompatActivity {

    private ListView MyCoursesList;
    private static String[]courses=new String[]{"English Course","Physics Course","Mathmatics Course","Statistics Course"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses_list);
        listView();
    }
    public void listView(){
        MyCoursesList=(ListView)findViewById(R.id.MyCoursesList);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.my_courses_list,courses);
        MyCoursesList.setAdapter(adapter);
        MyCoursesList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value=(String)MyCoursesList.getItemAtPosition(position);
                        Toast.makeText(MyCoursesList.this,"position:"+position+"value:"+value,Toast.LENGTH_LONG).show();

                    }

                }
        );


    }
}
