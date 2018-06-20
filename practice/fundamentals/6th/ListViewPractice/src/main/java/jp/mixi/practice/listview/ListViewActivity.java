
package jp.mixi.practice.listview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);



        // データの作成
        final List<String> listData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listData.add("タイトル" + i); }

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        CustomListItemAdapter adapter = new CustomListItemAdapter(this,R.layout.custom_list_item, listData);

        final ListView listView = (ListView) findViewById(R.id.list_view);
        //TODO ここでセットするadapterがCustomListItemAdapterになるように変更してください
        listView.setAdapter(adapter);

        findViewById(R.id.scroll_to_top_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @TargetApi(Build.VERSION_CODES.FROYO)
                    @Override
                    public void run() {
                        //リストアイテムの総数-1（0番目から始まって最後のアイテム）にフォーカスさせる
                        listView.smoothScrollToPosition(0);
                    }
                };
                handler.postDelayed(runnable, 500);
            }
        });
    }



}
