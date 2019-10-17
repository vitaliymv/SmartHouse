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

import java.util.logging.Handler;

import cz.msebera.android.httpclient.Header;

public class Room2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);
        final ToggleButton tgl = findViewById(R.id.toggleButton);
        final ToggleButton tgl1 = findViewById(R.id.toggleButton1);
        final ToggleButton tgl2 = findViewById(R.id.toggleButton2);
        final TextView txt_main = findViewById(R.id.textView1);
        final LinearLayout lay = findViewById(R.id.lay);
        final LinearLayout lay1 = findViewById(R.id.lay2);
        final LinearLayout lay2 = findViewById(R.id.lay3);
        final TextView txt = findViewById(R.id.txt);
        final TextView txt2 = findViewById(R.id.txt1);
        final TextView txt3 = findViewById(R.id.txt3);
        if (room_2.status.equals("Enable")) {
            tgl.setChecked(true);
        } else {
            tgl.setChecked(false);
        }
        if(room_3.status.equals("Enable")){
            tgl1.setChecked(true);
        } else {
            tgl1.setChecked(false);
        }
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txt_main.setText("\t\t\t\t\t" + room_2.room + "\n" + "Температура:  " + room_2.temp + "\u2103");

                tgl.setVisibility(View.VISIBLE);
                lay.setVisibility(View.VISIBLE);
                txt.setVisibility(View.VISIBLE);
                txt.setText(room_2.name + "\n" + room_2.status);



                tgl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (tgl.isChecked()) {
                            AsyncHttpClient client = new AsyncHttpClient();
                            client.get(Data.url_send_ker + Data.key + "&serial=" + room_2.serial + "&status=1", new JsonHttpResponseHandler() {
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
                            client.get(Data.url_send_ker + Data.key + "&serial=" + room_2.serial + "&status=0", new JsonHttpResponseHandler() {
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
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tgl2.setVisibility(View.VISIBLE);
                lay2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt3.setText(room_4.name + "\n" + room_4.status);
                tgl2.setTextOn("ON");
                tgl2.setTextOff("OFF");
                if(room_4.status.equals("Enable")){
                    tgl2.setChecked(true);
                } else {
                    tgl2.setChecked(false);
                }

                tgl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(tgl2.isChecked()){
                            AsyncHttpClient client = new AsyncHttpClient();
                            client.get(Data.url_send_ker + Data.key + "&serial=" + room_4.serial + "&status=1", new JsonHttpResponseHandler() {
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
                            client.get(Data.url_send_ker + Data.key + "&serial=" + room_4.serial + "&status=0", new JsonHttpResponseHandler() {
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
////////////////////////////////
        if (room_2.room.equals(room_1.room)) {
            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tgl1.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt2.setText(room_1.name + "\n" + room_1.status);
                    tgl1.setTextOn("ON");
                    tgl1.setTextOff("OFF");
                    if(room_1.status.equals("Enable")){
                        tgl1.setChecked(true);
                    } else {
                        tgl1.setChecked(false);
                    }

                    tgl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(tgl1.isChecked()){
                                AsyncHttpClient client = new AsyncHttpClient();
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_1.serial + "&status=1", new JsonHttpResponseHandler() {
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
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_1.serial + "&status=0", new JsonHttpResponseHandler() {
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
////////////////////////////////
        } else if (room_2.room.equals(room_3.room)) {
            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tgl1.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt2.setText(room_3.name + "\n" + room_3.status);
                    tgl1.setTextOn("ON");
                    tgl1.setTextOff("OFF");
                    if(room_3.status.equals("Enable")){
                        tgl1.setChecked(true);
                    } else {
                        tgl1.setChecked(false);
                    }

                    tgl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(tgl1.isChecked()){
                                AsyncHttpClient client = new AsyncHttpClient();
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_3.serial + "&status=1", new JsonHttpResponseHandler() {
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
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_3.serial + "&status=0", new JsonHttpResponseHandler() {
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

//     ///////////////////////////
        } else if (room_2.room.equals(room_4.room)) {

// ////////////////  ////////////////
        } else if (room_2.room.equals(room_5.room)) {
            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tgl2.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.VISIBLE);
                    txt3.setVisibility(View.VISIBLE);
                    txt3.setText(room_5.name + "\n" + room_5.status);
                    tgl2.setTextOn("ON");
                    tgl2.setTextOff("OFF");
                    if(room_5.status.equals("Enable")){
                        tgl2.setChecked(true);
                    } else {
                        tgl2.setChecked(false);
                    }

                    tgl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(tgl2.isChecked()){
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
// //////////////////////////////////
        } else if (room_2.room.equals(room_6.room)) {
            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tgl1.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt2.setText(room_6.name + "\n" + room_6.status);
                    tgl1.setTextOn("ON");
                    tgl1.setTextOff("OFF");
                    if(room_6.status.equals("Enable")){
                        tgl1.setChecked(true);
                    } else {
                        tgl1.setChecked(false);
                    }

                    tgl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(tgl1.isChecked()){
                                AsyncHttpClient client = new AsyncHttpClient();
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_6.serial + "&status=1", new JsonHttpResponseHandler() {
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
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_6.serial + "&status=0", new JsonHttpResponseHandler() {
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
/////////////////////////////////
        } else if (room_2.room.equals(room_7.room)) {
            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tgl1.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt2.setText(room_7.name + "\n" + room_7.status);
                    tgl1.setTextOn("ON");
                    tgl1.setTextOff("OFF");
                    if(room_7.status.equals("Enable")){
                        tgl1.setChecked(true);
                    } else {
                        tgl1.setChecked(false);
                    }

                    tgl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(tgl1.isChecked()){
                                AsyncHttpClient client = new AsyncHttpClient();
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_7.serial + "&status=1", new JsonHttpResponseHandler() {
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
                                client.get(Data.url_send_ker + Data.key + "&serial=" + room_7.serial + "&status=0", new JsonHttpResponseHandler() {
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
        }

    }



}

