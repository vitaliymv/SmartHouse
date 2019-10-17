package com.example.kursova;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

public class Room3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room3);
        final ToggleButton tgl = findViewById(R.id.toggleButton);
        final TextView txt1 = findViewById(R.id.textView1);
        final LinearLayout lay = findViewById(R.id.lay2);
        final TextView txt = findViewById(R.id.txt);
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                    txt1.setText("\t\t\t\t\t" + room_5.room + "\n" + "Температура:  " + room_5.temp + "\u2103");
                    tgl.setVisibility(View.VISIBLE);
                    lay.setVisibility(View.VISIBLE);
                    txt.setVisibility(View.VISIBLE);
                    txt.setText(room_5.name + "\n" + room_5.status);
                    tgl.setTextOn("ON");
                    tgl.setTextOff("OFF");
                    if(room_5.status.equals("Enable")){
                        tgl.setChecked(true);
                } else {
                        tgl.setChecked(false);
                    }

                    tgl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(tgl.isChecked()){
                                AsyncHttpClient client = new AsyncHttpClient();
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_5.serial + "&status=1", new JsonHttpResponseHandler() {
                                    @Override
                                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                                        if (response != null) {

                                        }
                                    }

                                    @Override
                                    public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {

                                    }
                                });
                            } else {
                                AsyncHttpClient client = new AsyncHttpClient();
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_5.serial + "&status=0", new JsonHttpResponseHandler() {
                                    @Override
                                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                                        if (response != null) {


                                        }
                                    }

                                    @Override
                                    public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                                    }
                                });
                            }
                        }
                    });

            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();









//1111111111111
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(room_5.room.equals(room_3.room)){
                    tgl.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();
//2222222222222
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();
//33333333333333
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();
//44444444444444
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();
//55555555555555
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();
//666666666666666
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();
//777777777777777
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                start();
            }
        }.start();
    }
}
