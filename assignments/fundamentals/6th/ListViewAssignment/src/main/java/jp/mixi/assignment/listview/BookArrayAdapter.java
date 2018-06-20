package jp.mixi.assignment.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookArrayAdapter extends ArrayAdapter<Book> {
    @SuppressWarnings("unused")
    private static final String TAG = BookArrayAdapter.class.getSimpleName();

    private LayoutInflater mLayoutInflater;

    public BookArrayAdapter(Context context, int list_item_book, List<Book>objects) {
        // 第2引数はtextViewResourceIdとされていますが、カスタムリストアイテムを使用する場合は特に意識する必要のない引数です
        super(context, 0, objects);
        // レイアウト生成に使用するインフレーター
        mLayoutInflater = LayoutInflater.from(context);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        // ListViewに表示する分のレイアウトが生成されていない場合レイアウトを作成する
        if (convertView == null) {
            // レイアウトファイルからViewを生成する
            view = mLayoutInflater.inflate(R.layout.list_item_book, parent, false);

        } else {
            // レイアウトが存在する場合は使いまわす
            view = convertView;
        }


        //Book book = new Book();
        // リストアイテムに対応するデータを取得する
        Book item1 = getItem(position);
        //Book item2 = getItem(position);
        //Book item3 = getItem(position);


        // 各Viewに表示する情報を設定
        TextView text1 = (TextView) view.findViewById(R.id.Title);
        text1.setText("" + item1);
        TextView text2 = (TextView) view.findViewById(R.id.Publisher);
        text2.setText(""+R.id.Publisher);
        TextView text3 = (TextView) view.findViewById(R.id.Price);
        text3.setText(""+ R.id.Price);

        return view;
    }
}
