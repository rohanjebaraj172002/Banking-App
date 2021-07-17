package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1111,'Zacharia Rose', 'zach@gmail.com','SPARKS1111','7895641238', 150000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2222,'Elena Gilbert', 'elena@gmail.com','SPARKS2222','8995641238', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3333,'Surya Kumar', 'surya@gmail.com','SPARKS3333','7595645896', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4444,'Vikram Vedha', 'vikram@gmail.com','SPARKS4444','9995640038', 80000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5555,'Shivani Narayanan', 'shivani@gmail.com','SPARKS5555','9095648962', 75000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6666,'Adithya Joshi', 'adit@gmail.com','SPARKS6666','8855640238', 65000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7777,'Yash Micheal', 'yash@gmail.com','SPARKS7777','8895640215', 45000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8888,'Krithik Jain', 'krithi@gmail.com','SPARKS8888','9985021539', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9999,'Ritik Raj', 'ritik@gmail.com','SPARKS9999','9309565238', 105000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1010,'Rohit Arasan', 'rohit@gmail.com','SPARKS1010','8292591201', 99000)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}