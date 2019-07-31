package com.example.inicioactivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class terceiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String pais = bundle.getString("paisEscolhido");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(pais);
    }

    public void pronto(View v) {
        Intent intent = new Intent(this, finalActivity.class);
        startActivity(intent);
    }
}
