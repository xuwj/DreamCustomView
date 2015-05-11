package com.xwj.customview.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xwj.customview.Entity.Student;
import com.xwj.customview.Entity.Teacher;
import com.xwj.customview.R;

import java.util.List;

/**
 * Created by user on 2015/4/24.
 */
public class LvAdapter extends BaseAdapter {
    private Context context;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private int currentTeacher = 0;
    private int currentTeacherSum;
    private int currentType;


    public LvAdapter(Context context, List<Student> studentList, List<Teacher> teacherList) {
        this.context = context;
        this.studentList = studentList;
        this.teacherList = teacherList;
        currentTeacherSum = teacherList.size();
    }

    public LvAdapter() {
    }

    @Override
    public int getCount() {
        return studentList.size() + teacherList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("-----------", (-1 % 5) + "");


        View firstItemView = null;
        View secondItemView = null;
        //获取到当前位置所对应的Type


        currentType = getItemViewType(position);

        if (currentType == RECOMMEND_FIRST_TYPE) {
//

            firstItemView = convertView;
            FirsrViewhodler firsrViewhodler = null;
            if (firstItemView == null) {
                firstItemView = LayoutInflater.from(context).inflate(R.layout.item_lv_first, null);
                firsrViewhodler = new FirsrViewhodler();
                firsrViewhodler.tv0 = (TextView) firstItemView.findViewById(R.id.tv_first_0);
                firsrViewhodler.tv1 = (TextView) firstItemView.findViewById(R.id.tv_first_1);
                firsrViewhodler.tv2 = (TextView) firstItemView.findViewById(R.id.tv_first_2);
                firstItemView.setTag(firsrViewhodler);
            } else {
                firsrViewhodler = (FirsrViewhodler) firstItemView.getTag();
            }
            Teacher teacher = teacherList.get(position / 5);
            firsrViewhodler.tv0.setText(teacher.getName());
            firsrViewhodler.tv1.setText(teacher.getDesc());
            firsrViewhodler.tv2.setText(teacher.getNick());

            convertView = firstItemView;
//            currentTeacher++;


        } else {
            secondItemView = convertView;
            SecondViewHodler secondViewHodler = null;
            if (secondItemView == null || convertView.getTag() instanceof FirsrViewhodler) {
                secondItemView = LayoutInflater.from(context).inflate(R.layout.item_lv_second, null);
                secondViewHodler = new SecondViewHodler();
                secondViewHodler.tv0 = (TextView) secondItemView.findViewById(R.id.tv_second_0);
                secondViewHodler.tv1 = (TextView) secondItemView.findViewById(R.id.tv_second_1);
                secondViewHodler.tv2 = (TextView) secondItemView.findViewById(R.id.tv_second_2);
                secondItemView.setTag(secondViewHodler);
            } else {
                secondViewHodler = (SecondViewHodler) secondItemView.getTag();
            }
            Student student;
//            if ((position + 1) % 5 == 0 && (position +1) / 5 < currentTeacherSum) {
//                student = studentList.get(position-1);
//            } else {
//                Log.i("------position-----1111---", "" + position);
//                student = studentList.get(position);
//            }

            if ((position + 1) / 5 < currentTeacherSum) {
                student = studentList.get(position - position / 5);
            } else {
                student = studentList.get(position - currentTeacherSum);
            }

            Log.i("------currentTeacher---studentList--", currentTeacher + "--------" + studentList.size());
            secondViewHodler.tv0.setText(student.getName());
            secondViewHodler.tv1.setText(student.getDesc());
            secondViewHodler.tv2.setText(student.getNick());
            convertView = secondItemView;
        }

        return convertView;
    }

    public static class FirsrViewhodler {
        private TextView tv0;
        private TextView tv1;
        private TextView tv2;
    }

    public static class SecondViewHodler {
        private TextView tv0;
        private TextView tv1;
        private TextView tv2;
    }

    int RECOMMEND_FIRST_TYPE = 1;
    int RECOMMEND_SECOND_TYPE = 2;

    @Override
    public int getItemViewType(int position) {
        Log.i("-----getItemViewType-----position----", position + "-------currentTeacherSum--------" + currentTeacherSum);
        if ((position + 1) % 5 == 0 && (position + 1) / 5 <= currentTeacherSum) {
            return RECOMMEND_FIRST_TYPE;  // 老师
        } else {
            return RECOMMEND_SECOND_TYPE;  // 学生
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;   // 返回的值一定要比定义的type类型RECOMMEND_FIRST_TYPE、RECOMMEND_SECOND_TYPE大
    }
}
