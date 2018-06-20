
package jp.mixi.practice.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class SQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        findViewById(R.id.insert).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        findViewById(R.id.delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        findViewById(R.id.update).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        findViewById(R.id.query).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });

    }

    private void insert() {

        // TODO:ここにinsert処理を実装してください
        BookOpenHelper bookOpenHelper = new BookOpenHelper(getApplication());
        SQLiteDatabase db = bookOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Book.COLUMN_NAME_BOOK_TITLE, "TITLE1");
        values.put(Book.COLUMN_NAME_BOOK_PUBLISHER, "PUBLISHER1");
        values.put(Book.COLUMN_NAME_BOOK_PRICE, "PRICE1");

        // 戻り値はRowID（_ID）
        // エラーの場合は-1になる
        long rowId = db.insert(Book.BOOK_TABLE_NAME, null, values);
    }

    private void delete() {
        // TODO:ここにdelete処理を実装してください
        BookOpenHelper bookOpenHelper = new BookOpenHelper(getApplication());
        SQLiteDatabase db = bookOpenHelper.getWritableDatabase();

        // 条件を指定
        String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
        String[] selectionArgs = {
                "PRICE1"
        };
        int deletedCount = db.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);

    }

    private void update() {
        // TODO:ここにupdate処理を実装してください
        BookOpenHelper bookOpenHelper = new BookOpenHelper(getApplication());
        SQLiteDatabase db = bookOpenHelper.getWritableDatabase();
        // update情報を設定する
        ContentValues values = new ContentValues();
        values.put(Book.COLUMN_NAME_BOOK_TITLE, "NEW_TITLE");

        // 条件を指定
        String selection = Book.COLUMN_NAME_BOOK_TITLE + " LIKE ?";
        String[] selectionArgs = {
                "TITLE%"
        };

        int updatedCount = db.update(Book.BOOK_TABLE_NAME, values, selection, selectionArgs);
    }

    private void query() {
        // TODO:ここにquery処理を実装してください
        BookOpenHelper bookOpenHelper = new BookOpenHelper(getApplication());
        SQLiteDatabase db = bookOpenHelper.getReadableDatabase();

        // 取得する情報を指定
        String[] projection = {
                Book._ID,
                Book.COLUMN_NAME_BOOK_TITLE,
                Book.COLUMN_NAME_BOOK_PUBLISHER,
                Book.COLUMN_NAME_BOOK_PRICE
        };

        // 条件を指定
        String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
        String[] selectionArgs = {
                "PRICE1"
        };

        Cursor cursor = db.query(Book.BOOK_TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        boolean moveToFirst = cursor.moveToFirst();
        long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(Book._ID));
    }
}
