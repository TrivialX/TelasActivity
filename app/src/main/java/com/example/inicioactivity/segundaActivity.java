package com.example.inicioactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class segundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listview, View itemView, int position, long id) {
                String time = "";
                AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                builder.setTitle("Titulo");
                builder.setMessage("Qualifique este software");
                builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(segundaActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                    }
                }).show();
                if (position == 0) {
                    time = "Escolheu -> Brasil";
                } else if (position == 1) {
                    time = " Escolher -> Portugal";
                }
                Bundle bundle = new Bundle();
                bundle.putString("paisEscolhido", time);
                Intent intent = new Intent(getBaseContext(), terceiraActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        ListView listView = (ListView) findViewById(R.id.paisesID);
        listView.setOnItemClickListener(itemClickListener);{
        }
        ArrayList<String> paises = new ArrayList<String>();
        paises.add("Brasil");
        paises.add("Portugal");
        ListView lista = findViewById(R.id.paisesID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                paises);

        lista.setAdapter(adapter);
    }
    }


