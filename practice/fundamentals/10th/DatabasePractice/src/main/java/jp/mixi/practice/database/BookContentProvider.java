
package jp.mixi.practice.database;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;

public class BookContentProvider extends ContentProvider {
    @SuppressWarnings("unused")
    private static final String TAG = BookContentProvider.class.getSimpleName();

    // 一意となる識別子にする
    private static final String AUTHORITY = "jp.mixi.practice.database.contentprovider.Book";

    // bookテーブル用のContentURI
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");

    private static final int BOOK = 1;

    // 利用者がメソッドを呼び出したURIに対応する処理を判定処理に使用します
    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY, Book.BOOK_TABLE_NAME, BOOK);
    }

    private BookOpenHelper bookOpenHelper;
    private ContentResolver contentResolver;

    // アプリケーション起動時にメインスレッド上で呼ばれます。そのため、時間がかかる処理は行うのは禁止されています。
    // ここで必要な初期化処理を行います。
    @Override
    public boolean onCreate() {
        bookOpenHelper = new BookOpenHelper(getContext());
        contentResolver = getContext().getContentResolver();
        return true;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        isValidUri(uri);

        // TODO bookOpenHelperを使用してinsertの処理を実装してください
        // TODO ContentUris#withAppendedIdを使用して追加された行のURIを生成してください
        // TODO ContentResolver#notifyChangeメソッドを使って設定したURIのデータに変更があったことを通知してください
        // return するRUIはContentUris#withAppendedIdで生成したURIをreturnしてください
        SQLiteDatabase db = bookOpenHelper.getWritableDatabase();
        long rowId = db.insert(Book.BOOK_TABLE_NAME, null, values);
        // 追加された行のURIを生成。content://jp.mixi.sample.contentprovider.Book/book/1
        Uri insertedUri = ContentUris.withAppendedId(uri, rowId);
        // 設定したURIのデータに変更があったことを通知します
        getContext().getContentResolver().notifyChange(insertedUri, null);
        return insertedUri;

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        isValidUri(uri);

        SQLiteDatabase db = bookOpenHelper.getReadableDatabase();
        // URIからテーブル名を取得
        String tableName = uri.getPathSegments().get(0);
        Cursor cursor = db.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
        // 設定したURIの変更を監視するように設定
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
        // TODO bookOpenHelperを使用して検索の処理を実装してください

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        isValidUri(uri);

        // TODO bookOpenHelperを使用してupdate処理を実装してください
        SQLiteDatabase db = bookOpenHelper.getWritableDatabase();
        // URIからテーブル名を取得
        String tableName = uri.getPathSegments().get(0);
        int updatedCount = db.update(tableName, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);

        // TODO ContentResolver#notifyChangeメソッドを使って設定したURIのデータに変更があったことを通知してください
        return updatedCount;
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        isValidUri(uri);

        // TODO bookOpenHelperを使用してdeleteを実装してください

        SQLiteDatabase db = bookOpenHelper.getWritableDatabase();
        int deletedCount = db.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);
        // 設定したURIのデータに変更があったことを通知します
        getContext().getContentResolver().notifyChange(uri, null);
        return deletedCount;
        // TODO ContentResolver#notifyChangeメソッドを使って設定したURIのデータに変更があったことを通知してください
    }

    // このContentProviderで使用可能なURIかを判定します。
    // 使用不可の場合はIllegalArgumentExceptionを投げます。
    private void isValidUri(Uri uri) {
        if (URI_MATCHER.match(uri) != BOOK) {
            throw new IllegalArgumentException("Unknown URI : " + uri);
        }
    }
}
