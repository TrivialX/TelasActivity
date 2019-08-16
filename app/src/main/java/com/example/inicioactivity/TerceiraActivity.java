package com.example.inicioactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TerceiraActivity extends AppCompatActivity {

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
        Intent intent = new Intent(this, FinalActivity.class);
        startActivity(intent);
    }
}
