package jp.mixi.practice.messagingandnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

/**
 * Created by suino on 2015/02/26.
 */
public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // TODO ここで通知を表示する
        Intent intent = new Intent(this, NewActivity3.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
         builder.setContentTitle("通知だヨ！");
        builder.setContentText("通知の詳しい内容をここに書きます。");
                // 通知のタイト
                // 通知の詳細メッセージ

                // 通知のアイコン
        builder.setSmallIcon(R.drawable.ic_launcher);
                // 通知を表示した瞬間、通知バーに表示するショートメッセージ
        builder.setContentIntent(pendingIntent);
                // この通知が未だ表示されていない時だけ、音やバイブレーション、ショートメッセージの表示を行う
        builder .setOnlyAlertOnce(true);


                // 直接インスタンス化せず、Context を経由してインスタンスを取得する
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // 通知の種類に応じて id を割当てることが出来る。
        // id の異なる通知は違うものとして扱われる。
        manager.notify(0,builder.build());
    }
}
