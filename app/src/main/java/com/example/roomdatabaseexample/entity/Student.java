package com.example.roomdatabaseexample.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tlb_student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int studentId;
    @ColumnInfo(name = "student_name")
    private String name;
    @ColumnInfo(name = "student_city")
    private String city;

    @Ignore
    public Student(int studentId, String name, String city) {
        this.studentId = studentId;
        this.name = name;
        this.city = city;
    }

    public Student(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Ignore
    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
