package jp.mixi.assignment.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public  static final String DATABASE_NAME = "plactice.dp";
    private static final String TABLE_CREATE = "create table android_code_name(_id integer primary key autoincrement,name integer not null,version integer);";

    public MySQLiteOpenHelper(Context context){
        super();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
