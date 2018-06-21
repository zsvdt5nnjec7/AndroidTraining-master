
package jp.mixi.practice.dialog.med;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends FragmentActivity {
    private int  po = 0;
    private String aa = null;
    private ListView listView = null;
    private ListItemSelectionDialogFragment listItemSelectionDialogFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.ListView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        adapter.add("hoge");
        adapter.add("fuga");
        adapter.add("piyo");
        adapter.add("foo");
        adapter.add("bar");
        adapter.add("baz");
        list.setAdapter(adapter);
        listView = list;

    }

    @Override
    protected void onStart() {
        super.onStart();
        listView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        ;
                        return false;
                    }
                }
        );


        //ロングタップでコンテキストメニューが表示される
        registerForContextMenu(findViewById(R.id.ListView));
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        po = position;
                        // aa = adapter.getItem(position);

                    }
                }
        );
    }

    @Override
    protected void onStop() {
        //指定したビューに対してコンテキストメニューが表示されないようにする。
        unregisterForContextMenu(findViewById(R.id.ListView));

        super.onStop();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
         AdapterView.AdapterContextMenuInfo adapter = (AdapterView.AdapterContextMenuInfo)menuInfo;
        // TODO: 長押しメニューに、削除・キャンセル、の 2 つの項目を表示する

        getMenuInflater().inflate(R.menu.main, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO: 長押しメニューの、削除、の項目の選択をハンドリングして、確認のためのダイアログを

        String title = (String) item.getTitle();
        switch (title) {
            case "CANCEL":
                DialogFragment lsdf = new ListItemSelectionDialogFragment();
                lsdf.show(getSupportFragmentManager(), "my_dialog_fragment");
            break;
            case "OK":
                break;
            default:
                break;
        }

        return super.onContextItemSelected(item);
    }
    public  void deleteItem() {
        System.out.println(po);
        System.out.println(po);
        // simple_list_item_1 は、 もともと用意されている定義済みのレイアウトファイルのID
       // adapter.remove(aa);
        //adapter.notifyDataSetChanged();

    }
}
