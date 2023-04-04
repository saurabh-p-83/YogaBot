package com.example.yogabot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "YogaBotDB.db";

    // Constructor for the DBHelper class
    public DBHelper(Context context) {
        super(context, "YogaBotDB.db", null, 3);
    }

    @Override
    // Called when the database is created for the first time
    public void onCreate(SQLiteDatabase MyDB) {
        // Create the 'users' table with the specified columns
        MyDB.execSQL("create table users (username TEXT, userAge INT, userWeight INT, userHeight INT, userPhoneNumber TEXT, userEmailAddress TEXT PRIMARY KEY, userPassword TEXT)");

    }

    @Override
    // Called when the database needs to be upgraded to a new version
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        // Drop the 'users' table if it exists
        MyDB.execSQL("drop Table if exists users");
        // Create a new 'users' table with the specified columns
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS users (username TEXT, userAge INT, userHeight INT, userPhoneNumber TEXT, userEmailAddress TEXT PRIMARY KEY, userPassword TEXT)");
        // Add a new column 'userWeight' to the 'users' table
        MyDB.execSQL("ALTER TABLE users ADD COLUMN userWeight INT DEFAULT 0");

    }

    // Insert a new row in the 'users' table
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

    // Check if a user with the specified email address exists in the 'users' table
    public boolean checkuserEmailAddress(String userEmailAddress){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users WHERE userEmailAddress = ?", new String[] {userEmailAddress});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // Check if a user with the specified email address and password exists in the 'users' table
    public boolean checkuserEmailpassword( String userEmailAddress, String userPassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users WHERE userEmailAddress = ? and userPassword = ?", new String[] {userEmailAddress, userPassword});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }
    // This method fetches all user details from the database and returns them as an ArrayList.
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
    // This method updates the profile details of a user in the database.
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