package jp.mixi.practice.messagingandnotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);


        Intent intent = getIntent();
        String name = intent.getStringExtra("toast_message");

        TextView t1 = (TextView)findViewById(R.id.textView1);
        t1.setText(name);
    }

}
