package com.example.jeetsimeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn=findViewById(R.id.btn1);
         edt=findViewById(R.id.ed1);
        URL server;
        try {
            server= new URL("https://meet.jit.si");
             JitsiMeetConferenceOptions defoptions= new  JitsiMeetConferenceOptions.Builder()
                     .setServerURL(server)
                     .setFeatureFlag("welcomepage.enabled",false)
                     .build();
            JitsiMeet.setDefaultConferenceOptions(defoptions);







        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JitsiMeetConferenceOptions options= new JitsiMeetConferenceOptions.Builder()
                        .setFeatureFlag("welcomepage.enabled",false)
                        .setRoom(edt.getText().toString()).build();
                JitsiMeetActivity.launch(MainActivity.this,options);

            }
        });

    }
}