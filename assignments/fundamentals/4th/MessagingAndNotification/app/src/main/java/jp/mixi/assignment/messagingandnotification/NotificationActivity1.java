package jp.mixi.assignment.messagingandnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.NotificationCompat;

/**
 * Created by suino on 2015/02/26.
 */
public class NotificationActivity1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification1);

        // TODO
        Intent intent = new Intent(this, NotificationActivity1.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("通知だヨ！");
        builder.setContentText("通知の詳しい内容をここに書きます。");
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setVibrate(new long[]{0, 1000});
        builder.setTicker("通知だヨ！");

        // 直接インスタンス化せず、Context を経由してインスタンスを取得する
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // 通知の種類に応じて id を割当てることが出来る。
        manager.notify(0,builder.build());
    }

}
