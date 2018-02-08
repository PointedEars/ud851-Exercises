package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.example.android.waitlist.data.WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME;
import static com.example.android.waitlist.data.WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE;
import static com.example.android.waitlist.data.WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP;
import static com.example.android.waitlist.data.WaitlistContract.WaitlistEntry.TABLE_NAME;

// DONE (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {
    // DONE (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    static final String DATABASE_NAME = "waitlist.db";

    // DONE (3) Create a static final int called DATABASE_VERSION and set it to 1
    static final int DATABASE_VERSION = 1;

    // DONE (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // DONE (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // DONE (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        String SQL_CREATE_WAITLIST_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                + _ID + " UNSIGNED INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_GUEST_NAME + " TEXT NOT NULL,"
                + COLUMN_PARTY_SIZE + " UNSIGNED INTEGER NOT NULL,"
                + COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";
        // DONE (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // DONE (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // DONE (9) Inside, execute a drop table query, and then call onCreate to re-create it
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }
}