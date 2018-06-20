
package jp.mixi.assignment.controller;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * TODO: 課題4
 * この Activity 内で、メモリリークを引き起こす原因を特定し、リークしないように修正してください。
 * (Activity のライフサイクルを超えた参照によってメモリリークが引き起こされます。
 * 画面回転や、アプリの終了、他のアプリへの遷移等で動作を見てみましょう。)
 * <p>
 * Hint:
 * この Activity では、端末内全体に送られているメッセージを受け取るための仕組み（ブロードキャストレシーバ）
 * を利用しています。
 * ブロードキャスト等のメッセージングについての詳細は今後の研修で触れますが、
 * この Activity のライフサイクルの中でブロードキャストレシーバが動作している必要があります。
 * <p>
 * {@link Activity#registerReceiver(android.content.BroadcastReceiver, android.content.IntentFilter)}
 *
 * @author keishin.yokomaku
 */
public class Controller4Activity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller4);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // ヘッドセットの接続状態を監視し、接続状態の変化があった時のブロードキャストメッセージを受信する
        registerReceiver(new MyBroadcastReceiver(), new IntentFilter(Intent.ACTION_HEADSET_PLUG));
    }
    public void onStop() {

        unregisterReceiver(new MyBroadcastReceiver());

        super.onStop();
    }

    // ブロードキャストのメッセージを受け取るクラス
    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // ブロードキャストのメッセージが届いたらログに吐き出す
            Log.v(TAG, "Broadcast intent received.");
            Toast.makeText(Controller4Activity.this, "Headset broadcast received.", Toast.LENGTH_LONG).show();
        }

    }
}