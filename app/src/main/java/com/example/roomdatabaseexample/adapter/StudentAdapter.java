package com.example.roomdatabaseexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roomdatabaseexample.R;
import com.example.roomdatabaseexample.entity.Student;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentAdapter extends ArrayAdapter<Student> {
    Context context;
    List<Student> students;

    public StudentAdapter(@NonNull Context context, List<Student> students) {
        super(context, R.layout.student_sample, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.student_sample, parent, false);

        TextView tv_name = view.findViewById(R.id.tvname);
        TextView tv_city = view.findViewById(R.id.tvcity);

        tv_name.setText(students.get(position).getName());
        tv_city.setText(students.get(position).getCity());

        return view;
      }
}
