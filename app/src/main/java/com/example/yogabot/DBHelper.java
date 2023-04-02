package com.example.yogabot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "YogaBotDB.db";
    public DBHelper(Context context) {
        super(context, "YogaBotDB.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table users (username TEXT, userAge INT, userWeight INT, userHeight INT, userPhoneNumber TEXT, userEmailAddress TEXT PRIMARY KEY, userPassword TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS users (username TEXT, userAge INT, userHeight INT, userPhoneNumber TEXT, userEmailAddress TEXT PRIMARY KEY, userPassword TEXT)");
        MyDB.execSQL("ALTER TABLE users ADD COLUMN userWeight INT DEFAULT 0");

    }
    public boolean insertData(String username, int userAge,int userWeight, int userHeight, String userPhoneNumber, String userEmailAddress, String userPassword ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username ", username);
        contentValues.put("userAge ", userAge);
        contentValues.put("userWeight ", userWeight);
        contentValues.put("userHeight ", userHeight);
        contentValues.put("userPhoneNumber", userPhoneNumber);
        contentValues.put("userEmailAddress", userEmailAddress);
        contentValues.put("userPassword", userPassword);
        long result = MyDB.insert("users",null,contentValues);
        if(result ==-1) return false;
        else
            return true;

    }
    public boolean checkuserEmailAddress(String userEmailAddress){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users WHERE userEmailAddress = ?", new String[] {userEmailAddress});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public boolean checkuserEmailpassword( String userEmailAddress, String userPassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users WHERE userEmailAddress = ? and userPassword = ?", new String[] {userEmailAddress, userPassword});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }
    public ArrayList<UserDetail> fetchData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from users" , null);
        ArrayList<UserDetail> arrUser = new ArrayList<>();
        while (cursor.moveToNext()){
            UserDetail user = new UserDetail();
            user.setName(cursor.getString(0));
            user.setAge(cursor.getInt(1));
            user.setHeight(cursor.getInt(2));
            user.setPhoneNumber(cursor.getString(4));
            user.setEmail(cursor.getString(5));
            user.setWeight(cursor.getInt(3));
            arrUser.add(user);


        }
        return arrUser;
    }
    public boolean updateProfileHelper(String name, int age,int weight, int height, String phonenumber,String email){
        this.getWritableDatabase();
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",name);
        values.put("userAge",age);
        values.put("userHeight",height);
        values.put("userWeight",weight);
        values.put("userPhoneNumber",phonenumber);
        values.put("userEmailAddress", email);
        int i = sqLiteDatabase.update("users",values,"userEmailAddress = ?",new String[]{email});
        if (i>0){
            return true;
        }

        return false;
    }


}