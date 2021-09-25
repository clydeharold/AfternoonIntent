package com.example.afternoonintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button cmdExplicit;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmdExplicit = findViewById(R.id.cmdExplicit);
        txtMessage = findViewById(R.id.txtMessage);

        cmdExplicit.setOnClickListener(startSecondActivity);
    }

    View.OnClickListener startSecondActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String msg = txtMessage.getText().toString();
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

            intent.putExtra("message", msg);

            startActivity(intent);

        }
    };
}