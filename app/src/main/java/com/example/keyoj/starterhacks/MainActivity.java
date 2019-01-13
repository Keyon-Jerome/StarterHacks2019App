package com.example.keyoj.starterhacks;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // this is a comment guys.
    // I'M ADDING ANOTHER COMMENT!
    //YAY

    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;

    String number;
    String message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.emergencyButton);
        System.out.print("Emergency!");

        number = "6139866798";
        message = "Emergency!!!";
        send = findViewById(R.id.emergencyButton);

        send.setEnabled(false);

        if(checkPermission(Manifest.permission.SEND_SMS)){
            send.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
        }


    }

    public void onSend(View v){
        String phoneNumber = number;
        String smsMessage = message;

        if(checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, smsMessage, null, null);
            Toast.makeText(this, "message Sent!", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

}
