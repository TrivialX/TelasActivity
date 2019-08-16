package com.example.inicioactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        final Bundle bundle = new Bundle();
        final Intent intent = new Intent(getBaseContext(), TerceiraActivity.class);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atenção!!");
        builder.setMessage("A escolha não poderá ser trocada, deseja continuar?");

        DialogInterface.OnClickListener positivo = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        };
        DialogInterface.OnClickListener negativo = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Escolha um país para continuar", Toast.LENGTH_SHORT).show();
            }
        };
        builder.setNegativeButton("Voltar", negativo);
        builder.setPositiveButton("Continuar", positivo);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listview, View itemView, int position, long id) {
                String time = "";
                if (position == 0) {
                    time = "Escolheu -> Brasil";
                    builder.create().show();
                    bundle.putString("paisEscolhido", time);
                    intent.putExtras(bundle);


                } else if (position == 1) {
                    time = " Escolher -> Portugal";
                    builder.create().show();
                    bundle.putString("paisEscolhido", time);
                    intent.putExtras(bundle);
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.paisesID);
        listView.setOnItemClickListener(itemClickListener);
        {
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