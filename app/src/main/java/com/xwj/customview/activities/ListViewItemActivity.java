package com.xwj.customview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.xwj.customview.Entity.Student;
import com.xwj.customview.Entity.Teacher;
import com.xwj.customview.R;
import com.xwj.customview.adapters.LvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/4/24.
 */
public class ListViewItemActivity extends Activity {

    private ListView mListView;
    private List<Student> studentList;
    private List<Teacher> teacherList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        initData();
        initListview();

    }

    private void initListview() {
        mListView = (ListView) findViewById(R.id.lv_diff_item);
        View view = LayoutInflater.from(this).inflate(R.layout.item_lv_head, null);
        //mListView.addHeaderView(view);
        mListView.setAdapter(new LvAdapter(this, studentList, teacherList));
    }

    private void initData() {
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.setDesc("student------desc" + i);
            student.setName("student------name" + i);
            student.setNick("student------nick" + i);
            studentList.add(student);
        }
        for (int i = 0; i < 7; i++) {
            Teacher teacher = new Teacher();
            teacher.setDesc("teacher------desc" + i);
            teacher.setName("teacher------name" + i);
            teacher.setNick("teacher------nick" + i);
            teacherList.add(teacher);
        }
    }
}
