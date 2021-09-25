package com.example.afternoonintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button cmdSetAlarm;
    EditText txtHour, txtMessage, txtMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refs();

        cmdSetAlarm.setOnClickListener(createAlarm);
    }

    View.OnClickListener createAlarm = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String msg = txtMessage.getText().toString();
            int hour = Integer.parseInt(txtHour.getText().toString());
            int min = Integer.parseInt(txtMinutes.getText().toString());

            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_HOUR, hour)
                    .putExtra(AlarmClock.EXTRA_MINUTES, min);

            intent.putExtra(AlarmClock.EXTRA_MESSAGE, msg);

            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
    };

    public void refs() {
        cmdSetAlarm = findViewById(R.id.cmdSetAlarm);
        txtHour = findViewById(R.id.txtHour);
        txtMinutes = findViewById(R.id.txtMinutes);
        txtMessage = findViewById(R.id.txtMessage);
    }

}