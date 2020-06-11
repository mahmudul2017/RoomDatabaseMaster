package com.example.roomdatabaseexample;

import android.content.Context;

import com.example.roomdatabaseexample.dao.StudentDao;
import com.example.roomdatabaseexample.entity.Student;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase db;
    public abstract StudentDao getStudentDao();

    public static StudentDatabase getInstance(Context context){
        if (db != null){
            return db;
        } else {
            db = Room.databaseBuilder(context, StudentDatabase.class, "student_db")
                    .allowMainThreadQueries()
                    .build();
            return db;
        }
    }
}
