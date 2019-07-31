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
                builder.setTitle("Aviso");
                builder.setMessage("Não poderá mudar, desejar continuar?");

                DialogInterface.OnClickListener btnSim = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(getApplicationContext(), terceiraActivity.class);
                        startActivity(intent);
                    }
                };
                DialogInterface.OnClickListener btnNao = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                };
                builder.setPositiveButton("Sim", btnSim);
                builder.setNegativeButton("Sim", btnNao);
                builder.create().show();

                if (position == 0) {
                    time = "Escolheu -> Brasil";
                } else if (position == 1) {
                    time = " Escolher -> Portugal";
                }
                Bundle bundle = new Bundle();
                bundle.putString("paisEscolhido", time);
                Intent intent = new Intent(getBaseContext(), segundaActivity.class);
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


