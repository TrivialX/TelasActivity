package com.example.inicioactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class terceiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String color = bundle.getString("paisEscolhido");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(color);
    }
}
