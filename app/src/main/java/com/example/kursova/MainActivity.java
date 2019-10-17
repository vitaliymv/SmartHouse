package com.example.kursova;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING) {
            Toast.makeText(MainActivity.this, "Hey your online ^_^", Toast.LENGTH_SHORT).show();
        } else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
            Toast.makeText(MainActivity.this, "Your device offline -_-", Toast.LENGTH_SHORT).show();
        }


        Button btn = findViewById(R.id.button5);
        username = findViewById(R.id.edit_user);
        password = findViewById(R.id.edit_password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                final String ed1 = username.getText().toString();
                final String ed2 = password.getText().toString();
                v.setEnabled(false);
                AsyncHttpClient client = new AsyncHttpClient();
                //final String url_glob = "http://smartdevgroup.hopto.org/service/mobile_data.php?api_key=123456789";
                client.get(Data.url_autor + ed1 + "&pass=" + ed2, new TextHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Data.key = responseString;
                        int ed1_len = ed1.length();
                        int ed2_len = ed2.length();
                        if (!Data.key.equals("false_login") & !Data.key.equals("false_pass")) {
                            Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MainMenu.class);
                            startActivity(intent);
                        } else if (ed1_len <= 1 || ed2_len <= 1) {
                            Toast.makeText(MainActivity.this, "Enter data", Toast.LENGTH_SHORT).show();
                            v.setEnabled(true);
                        } else if (Data.key.equals("false_login")) {
                            Toast.makeText(MainActivity.this, "False login", Toast.LENGTH_SHORT).show();
                        } else if (Data.key.equals("false_pass")) {
                            Toast.makeText(MainActivity.this, "False password", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                        }
                        v.setEnabled(true);
                    }
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Not connected into server", Toast.LENGTH_SHORT).show();
                        v.setEnabled(true);
                    }
                });
            }

        });
    }
}