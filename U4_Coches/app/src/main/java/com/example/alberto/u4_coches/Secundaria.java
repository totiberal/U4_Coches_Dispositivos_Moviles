package com.example.alberto.u4_coches;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Secundaria extends Activity {
    Spinner spinner;
    File rutaCompleta;
    File dirFicheiroSD;
    public static String nomeFicheiro = "coches.txt";
    ArrayList<String> coches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        spinner=(Spinner) findViewById(R.id.spinner_coches);
        dirFicheiroSD = getExternalFilesDir(null);
        rutaCompleta = new File(dirFicheiroSD.getAbsolutePath(), nomeFicheiro);
        String linea="";
        coches=new ArrayList<String>();
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
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Posicion: "+(position+1)+" Valor: "+((TextView) view).getText(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle estado) {
        estado.putStringArrayList("ARRAY", coches);
        super.onSaveInstanceState(estado);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        coches = savedInstanceState.getStringArrayList("ARRAY");
    }
}
