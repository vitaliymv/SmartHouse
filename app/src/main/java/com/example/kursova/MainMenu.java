package com.example.kursova;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button btn = findViewById(R.id.button);
        final Button btn2 = findViewById(R.id.button2);
        final Button btn3 = findViewById(R.id.button3);
        final Button btn4 = findViewById(R.id.button4);
        final Button btn5 = findViewById(R.id.button5);
        final Button btn6 = findViewById(R.id.button6);
        final Button btn7 = findViewById(R.id.button7);
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                final String url_glob = Data.url_resp_data + Data.key;
                AsyncHttpClient client = new AsyncHttpClient();
                client.get(url_glob, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        if (response != null) {
//room1
                            try {
                                JSONObject obj = response.getJSONObject(0);
                                room_1.status = obj.getString("status");
                                room_1.serial = obj.getString("serial");
                                room_1.name = obj.getString("name");
                                room_1.room = obj.getString("room");
                                room_1.number = obj.getString("number");
                                room_1.temp = obj.getDouble("temp");

                                if(room_1.room.length() <= 0){
                                    btn.setVisibility(View.GONE);
                                } else {btn.setVisibility(View.VISIBLE); btn.setText(room_1.room+ "\n\n" + room_1.temp + "\u2103");}
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
//room2
                            try {
                                JSONObject obj = response.getJSONObject(1);
                                room_2.status = obj.getString("status");
                                room_2.serial = obj.getString("serial");
                                room_2.name = obj.getString("name");
                                room_2.room = obj.getString("room");
                                room_2.number = obj.getString("number");
                                room_2.temp = obj.getDouble("temp");

                                if(room_2.room.equals(room_1.room) || room_2.room.equals(room_5.room) || room_2.room.equals(room_6.room) || room_2.room.equals(room_7.room)){
                                    btn2.setVisibility(View.GONE);
                                }else {btn2.setVisibility(View.VISIBLE);btn2.setText(room_2.room + "\n\n" + room_2.temp + "\u2103");}
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
//room3
                            try {
                                JSONObject obj = response.getJSONObject(2);
                                room_3.status = obj.getString("status");
                                room_3.serial = obj.getString("serial");
                                room_3.name = obj.getString("name");
                                room_3.room = obj.getString("room");
                                room_3.number = obj.getString("number");
                                room_3.temp = obj.getDouble("temp");
                                if(room_3.room.length() <= 0 || room_3.room.equals(room_4.room) || room_3.room.equals(room_5.room)){
                                    btn3.setVisibility(View.GONE);
                                } else {btn3.setVisibility(View.VISIBLE); btn3.setText(room_3.room + "\n\n" + room_3.temp + "\u2103");}
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                JSONObject obj = response.getJSONObject(3);
                                room_4.status = obj.getString("status");
                                room_4.serial = obj.getString("serial");
                                room_4.name = obj.getString("name");
                                room_4.room = obj.getString("room");
                                room_4.number = obj.getString("number");
                                room_4.temp = obj.getDouble("temp");

                                if(room_4.room.equals(room_1.room) || room_4.room.equals(room_3.room) || room_4.room.equals(room_2.room) ||
                                        room_4.room.equals(room_5.room) || room_4.room.equals(room_6.room) || room_4.room.equals(room_7.room)){
                                    btn4.setVisibility(View.GONE);
                                }else {btn4.setVisibility(View.VISIBLE);btn4.setText(room_2.room + "\n\n" + room_4.temp + "\u2103");}
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                JSONObject obj = response.getJSONObject(4);
                                room_5.status = obj.getString("status");
                                room_5.serial = obj.getString("serial");
                                room_5.name = obj.getString("name");
                                room_5.room = obj.getString("room");
                                room_5.number = obj.getString("number");
                                room_5.temp = obj.getDouble("temp");
                                if(room_5.room.length() <= 0){
                                    btn5.setVisibility(View.GONE);
                                } else btn5.setVisibility(View.VISIBLE); btn5.setText(room_5.room + "\n\n" + room_5.temp + "\u2103");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                JSONObject obj = response.getJSONObject(5);
                                room_6.status = obj.getString("status");
                                room_6.serial = obj.getString("serial");
                                room_6.name = obj.getString("name");
                                room_6.room = obj.getString("room");
                                room_6.number = obj.getString("number");
                                room_6.temp = obj.getDouble("temp");

                                if(room_6.room.length() <= 0){
                                    btn6.setVisibility(View.GONE);
                                }else btn6.setVisibility(View.VISIBLE);btn6.setText(room_6.room + "\n\n" + room_6.temp + "\u2103");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                JSONObject obj = response.getJSONObject(6);
                                room_7.status = obj.getString("status");
                                room_7.serial = obj.getString("serial");
                                room_7.name = obj.getString("name");
                                room_7.room = obj.getString("room");
                                room_7.number = obj.getString("number");
                                room_7.temp = obj.getDouble("temp");
                                if(room_1.room.length() <= 0){
                                    btn7.setVisibility(View.GONE);
                                }else btn7.setVisibility(View.VISIBLE);btn7.setText(room_7.room + "\n\n" + room_7.temp + "\u2103");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }



                        }
                    }
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                        Toast.makeText(MainMenu.this, "Not connected to server", Toast.LENGTH_SHORT).show();

                    }
                });
            }
            @Override
            public void onFinish() {
            start();
            }
        }.start();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Room1.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Room2.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Room5.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Room4.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Room3.class);
                startActivity(intent);
            }
        });
//
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainMenu.this, Room6.class);
//                startActivity(intent);
//            }
//        });
//
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainMenu.this, Room7.class);
//                startActivity(intent);
//            }
//        });

    }
}