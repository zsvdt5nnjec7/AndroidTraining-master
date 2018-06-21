package jp.mixi.practice.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        findViewById(R.id.buttonGet).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditText urlForm = (EditText) findViewById(R.id.access_url);
                String url = urlForm.getText().toString();
                callHttpGet(url);

            }
        });
        findViewById(R.id.buttonPost).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditText urlForm = (EditText) findViewById(R.id.access_url);
                String url = urlForm.getText().toString();
                EditText httpBody = (EditText) findViewById(R.id.http_body);
                String body = httpBody.getText().toString();
                callHttpPost(url, body);
            }
        });
    }

    private void callHttpGet(String url) {
        // TODO GETアクセス実装
        URL ul = null;
        try {
            ul = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) ul.openConnection();
            connection.setDoOutput(false);
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            InputStream is = connection.getInputStream();

            StringBuilder src = new StringBuilder();
            while (true) {
                byte[] line = new byte[1024];
                int size = is.read(line);
                if (size <= 0)
                    break;
                src.append(new String(line, "euc-jp"));
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }


    }

    private void callHttpPost(String url, String postBody) {
        // TODO POSTアクセス実装
    }


}
