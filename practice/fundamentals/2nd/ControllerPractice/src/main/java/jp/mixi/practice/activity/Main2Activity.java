package jp.mixi.practice.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyFragmentActivity mf = new MyFragmentActivity();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.commit();

    }

}
