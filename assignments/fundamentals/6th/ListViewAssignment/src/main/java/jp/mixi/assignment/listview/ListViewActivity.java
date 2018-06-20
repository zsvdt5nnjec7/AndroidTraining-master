
package jp.mixi.assignment.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // データの作成
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Book("タイトル" + i, "出版社" + i, i * 10));
        }

        // TODO:BookArrayAdapterを作成して下さい。
        // (リストアイテムのレイアウトは用意されているlist_item_book.xmlをしてください。)
         BookArrayAdapter bookArrayAdapter = new BookArrayAdapter(this,R.layout.list_item_book, list);

        mListView = (ListView) findViewById(R.id.BookList);

        // TODO:ListViewにBookArrayAdapterをセットしてください。
        // TODO:ListViewをタップしたとき、BookActivityに遷移するようにしてください。遷移するときにBookクラスのtitleを渡してください。
        // (BookActivityは用意されているものを使用してください)
        mListView.setAdapter(bookArrayAdapter);

       /** findViewById(R.id.Icon).setOnItemClickListener(new View.OnItemClickListener() {
            public void onClick(View view) {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Adapterからタップした位置のデータを取得する
                    String str = (String) parent.getItemAtPosition(position);
            }

        });*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerForContextMenu(mListView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        // ContextMenuを設定
        getMenuInflater().inflate(R.menu.context_menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() != R.id.DeleteListItem && item.getItemId() != R.id.AddListItem) {
            return false;
        }

        // MenuItemからContextMenuInfoを取得し、AdapterContextMenuInfoにキャストします
        ContextMenuInfo menuInfo = item.getMenuInfo();
        AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) menuInfo;

        // AdapterContextMenuInfoから長押ししたリストアイテムのpositionを取得します
        int position = adapterInfo.position;

        // ListViewから長押しされたリストアイテムを取得します
        Book book = (Book) mListView.getItemAtPosition(position);
        // ListViewからセットされているAdapterを取得します
        // BookArrayAdapter adapter = (BookArrayAdapter) mListView.getAdapter();

        if (item.getItemId() == R.id.DeleteListItem) {
            // TODO:Adapterを使用して長押ししたデータを削除してください
        } else if (item.getItemId() == R.id.AddListItem) {
            // TODO:Adapterを使用して長押ししたデータを追加してください
        }
        // TODO:Adapterを使用して表示されているデータを更新してください

        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterForContextMenu(mListView);
    }

}
