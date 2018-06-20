package jp.mixi.assignment.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

/**
 * TODO: 課題1
 * {@link Toast#makeText(Context, CharSequence, int)} または
 * {@link Toast#makeText(Context, int, int)} を利用して、各ライフサイクルメソッドがどのような順番で
 * 実行されているかを確認してください。
 * 確認したら、assignments/fundamentals/2nd/Report.md にその順番を記述してください。
 *
 * @author keishin.yokomaku
 */
public class Controller1Activity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller1);

        Toast ts =Toast.makeText(this,"onCreate()",Toast.LENGTH_LONG);
        ts.setGravity(Gravity.CENTER,0,0);
        ts.setGravity(Gravity.TOP,0,0);
        ts.show();
    }
    public void onStart(){
        super.onStart();
        Toast ts = Toast.makeText(this,"onStart()",Toast.LENGTH_LONG);
        ts.setGravity(Gravity.CENTER,0,0);
        ts.show();
    }
    public void onResume() {
        super.onResume();

        Toast.makeText(this,"onResume()",Toast.LENGTH_LONG).show();

    }
    public void onPause() {
        super.onPause();
        Toast ts = Toast.makeText(this,"onPause()",Toast.LENGTH_LONG);
        ts.setGravity(Gravity.TOP,0,0);
        ts.show();

    }
    public void onStop() {
        super.onStop();
        Toast ts = Toast.makeText(this,"onStop",Toast.LENGTH_LONG);
        ts.setGravity(Gravity.CENTER,0,0);
        ts.show();

    }
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

    public void onRestart() {
        super.onRestart();
        Toast ts = Toast.makeText(this,"onRestart()",Toast.LENGTH_LONG);
        ts.setGravity(Gravity.TOP,0,0);
        ts.show();
    }


}
