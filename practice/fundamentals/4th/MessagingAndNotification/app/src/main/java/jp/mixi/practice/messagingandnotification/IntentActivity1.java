package jp.mixi.practice.messagingandnotification;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

/**
 * Created by suino on 2015/02/25.
 */
public class IntentActivity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_1);

        View button1 = findViewById(R.id.CallActivity1);
        View button2 = findViewById(R.id.CallActivity2);
        View button3 = findViewById(R.id.CallActivity3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentActivity1.this,NewActivity1.class);
                startActivity(intent);
                // TODO ここに、NewActivity1 を呼び出す処理を書く

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentActivity1.this,NewActivity2.class);
                // TODO ここに、NewActivity2 を呼び出す処理を書く
                // TODO NewActivity2 は、toast_message をキーとした Extra のデータを必要としているので、適宜 Intent に含めること
                intent.putExtra("toast_message","push");
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            /**Activityがスタックに追加されずに開始される*/
            @Override
            public void onClick(View v) {
                // TODO ここに、NewActivity3 を呼び出す処理を書く
                // TODO Intent に、Intent.FLAG_ACTIVITY_NO_HISTORY という flag をセットするとどうなるかレポートすること
                Intent intent = new Intent(IntentActivity1.this,NewActivity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        });
    }

}
