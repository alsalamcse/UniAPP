package com.example.owner.uniapp.new1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.owner.uniapp.R;

public class Adapter extends ArrayAdapter<StudentEvent> {
    public Adapter(Context context, int resource) {
        super(context, resource);
    }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null)
                convertView=LayoutInflater.from(getContext()).inflate(R.layout.studentevent_item,parent,false);
          StudentEvent studentEvent=getItem(position);//return data object number " posotion "

           TextView edEventName1=convertView.findViewById(R.id.edEventName1);
            TextView edCourseTitle1=convertView.findViewById(R.id. edCourseTitle1);
           TextView ed112 =convertView.findViewById(R.id.ed112);
          TextView edFreeText1=convertView.findViewById(R.id.edFreeText1);
           TextView LecturerName1=convertView.findViewById(R.id.LecturerName1);
           // EditText LecturerName=convertView.findViewById(R.id.lecturerName);
           /// EditText LecturerName=convertView.findViewById(R.id.lecturerName);



            //ImageButton ibPicture=convertView.findViewById(R.id.ibPicture);
            TextView TvSave=convertView.findViewById(R.id.tvSave);
            // put the data of the object on the view
            edEventName1.setText(studentEvent.getType());
            edCourseTitle1.setText(studentEvent.getCourseTitle());
            ed112.setText(studentEvent.getEventTime());
            edFreeText1.setText(studentEvent.getFreeText());
            LecturerName1.setText(studentEvent.getLecturerName());

          //  tvSave .setOnClickListener(new View.OnClickListener() {
               // @Override
            //    public void onClick(View  v)
            // Toast.makeText(getContext(),"Del",Toast.LENGTH_SHORT).show();
              //  }
          // });




            return convertView;
        }
    }

