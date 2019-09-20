package com.sqlitedatabase.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDb extends SQLiteOpenHelper {

    private static final int DB_Version=1;
    private static String DB_NAME="mydb,db";
    private static String TABLE_NAME="mytable";
    private static String COLUMN1="id";
    private static String COLUMN2="name";
    private static String COLUMN3="cell";
    public SQLiteDb( Context context ) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query="CREATE TABLE " + TABLE_NAME+" (id INTEGER PRIMARY KEY,NAME text,cell Text) ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    //method for insert data
    public boolean insertData(String id,String name,String cell)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(COLUMN1,id);
        values.put(COLUMN2,name);
        values.put(COLUMN3,cell);
         long check=db.insert(TABLE_NAME,null,values);

         //1==if data not insert,1=data insert
         if(check==-1)
         {
             return false;
         }
         else{
             return true;
         }
    }
}
