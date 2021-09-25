package com.example.afternoonintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView msg;
    Button cmdBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        msg = findViewById(R.id.lblMessage);
        cmdBack = findViewById(R.id.cmdBack);

        Bundle extras = getIntent().getExtras();

        msg.setText(extras.getString("message"));

        cmdBack.setOnClickListener(backToPrev);
    }

    View.OnClickListener backToPrev = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };
}