package com.example.mrrs.schoolhelper;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.mrrs.schoolhelper.adapter.Schedule_Expandable_Adapter;
import com.example.mrrs.schoolhelper.models.TitleChild;
import com.example.mrrs.schoolhelper.models.TitleCreator;
import com.example.mrrs.schoolhelper.models.TitleParent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    Toolbar toolbarSchedule;
    CalendarView calendarView;
    TextView txtshowTime, txtshowBlock, txtTime;
    RecyclerView recyclerView;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((Schedule_Expandable_Adapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        AnhXa();
        //Back ActionBar
        setSupportActionBar(toolbarSchedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Calender Listener
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                String date = dayOfMonth + "/" + month + "/" + (year + 1);
//                txtshowTime.setText(date);
//            }
//        });
        //RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Schedule_Expandable_Adapter adapter = new Schedule_Expandable_Adapter(this,initData());
        adapter.setParentAndIconExpandOnClick(true);
        recyclerView.setAdapter(adapter);
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObjects = new ArrayList<>();
        for(TitleParent titleParent:titles){
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("Add to Contacts","Send messenge","Share"));
            titleParent.setChildObjectList(childList);
            parentObjects.add(titleParent);
        }
        return parentObjects;
    }

    private void AnhXa() {
        toolbarSchedule = findViewById(R.id.toolbarSchedule);
        calendarView = findViewById(R.id.calendarView);
//        txtshowTime = (TextView) findViewById(R.id.txt_showTime);
        txtshowBlock = (TextView) findViewById(R.id.txt_showBlock);
//        txtTime = (TextView) findViewById(R.id.txtTime);
        recyclerView = findViewById(R.id.myRecyclerView);
    }
    //Back Item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    //Chon Ngay
//    public void ChonNgay(){
//        final Calendar calendar = Calendar.getInstance();
//        int ngay = calendar.get(Calendar.DATE);
//        int thang = calendar.get(Calendar.MONTH);
//        int nam = calendar.get(Calendar.YEAR);
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                calendar.set(year,month,dayOfMonth);
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                txtshowTime.setText(simpleDateFormat.format(calendar.getTime()));
//            }
//        },nam,thang,ngay);
//        datePickerDialog.show();
//    }
}
