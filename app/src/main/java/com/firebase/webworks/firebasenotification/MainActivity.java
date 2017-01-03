package com.firebase.webworks.firebasenotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String token = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this,token,Toast.LENGTH_SHORT).show();
        TextView textView=(TextView)findViewById(R.id.text1);
        textView.setText(R.string.name);

    }
    public void Send(View view)
    {
        try
        {
            FirebaseMessaging fm = FirebaseMessaging.getInstance();
            fm.send(new RemoteMessage.Builder("719512183742" + "@gcm.googleapis.com")
                    .setMessageId(Integer.toString(1))
                    .addData("my_message", "Hello World")
                    .addData("my_action","SAY_HELLO")
                    .build());
        }catch (Exception e)
        {

        }
        int msgId=1;

    }

}
