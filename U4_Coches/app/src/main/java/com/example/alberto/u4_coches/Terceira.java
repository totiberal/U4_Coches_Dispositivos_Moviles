package com.example.alberto.u4_coches;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Terceira extends Activity {
    File rutaCompleta;
    File dirFicheiroSD;
    public static String nomeFicheiro = "coches.txt";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        listView=(ListView) findViewById(R.id.lista);
        dirFicheiroSD = getExternalFilesDir(null);
        rutaCompleta = new File(dirFicheiroSD.getAbsolutePath(), nomeFicheiro);
        String linea="";
        ArrayList<String> coches=new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rutaCompleta)));
            linea=br.readLine();
            while(linea != null){
                coches.add(linea+"\n");
                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, coches);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Posicion: " + (position + 1) + " Valor: " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
