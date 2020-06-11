package com.example.roomdatabaseexample.dao;

import com.example.roomdatabaseexample.entity.Student;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentDao {

    @Insert
    long insertStudent(Student student);

    @Insert
    long[] insertStudents(Student... students);

    @Query("select * from tlb_student")
    List<Student> getAllStudents();

    @Query("select * from tlb_student where studentId like:id")
    Student getStudentById(int id);

    @Update
    int updateStudent(Student student);

    @Delete
    int deleteStudent(Student student);
}
