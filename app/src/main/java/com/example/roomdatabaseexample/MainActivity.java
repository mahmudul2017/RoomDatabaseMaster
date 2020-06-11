package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabaseexample.adapter.StudentAdapter;
import com.example.roomdatabaseexample.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtCity;
    Button btnSave;
    TextView tvShow;
    Student student;
    ListView listView;
    List<Student> studentList = new ArrayList<>();
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtCity = findViewById(R.id.edtCity);
        tvShow = findViewById(R.id.tvShow);
        btnSave = findViewById(R.id.btnSave);
        listView = findViewById(R.id.listview);

        dataSaveToRoomDatabase();
        updateStudentList();
    }

    private void dataSaveToRoomDatabase() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String city = edtCity.getText().toString();

                Student student = new Student();
                student.setName(name);
                student.setCity(city);

                long insertStudentRow = StudentDatabase.getInstance(MainActivity.this).getStudentDao().insertStudent(student);

                if (insertStudentRow > 0) {
                    Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
                    updateStudentList();
                } else {
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void updateStudentList(){
        student = new Student();
        studentList = StudentDatabase.getInstance(this).getStudentDao().getAllStudents();
        adapter = new StudentAdapter(this, studentList);
        listView.setAdapter(adapter);
    }

    public void saveData(View view) {
        String name = edtName.getText().toString();
        String city = edtCity.getText().toString();

        Student student = new Student();
        student.setName(name);
        student.setCity(city);

        long insertStudentRow = StudentDatabase.getInstance(this).getStudentDao().insertStudent(student);

        if (insertStudentRow > 0) {
            Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
        }
    }
}
