package com.example.alberto.u4_coches;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by alberto on 17/10/15.
 */
public class Dialogos extends android.support.v4.app.DialogFragment{
    AlertDialog.Builder venta;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int numero = getArguments().getInt("MENSAXE");
        if(numero==1){
            venta = new AlertDialog.Builder(getActivity());
            venta.setTitle("Ler");
            venta.setMessage("Seleciona a maneira que queres en que se mostren os datos");
            venta.setCancelable(false);
            venta.setPositiveButton("Spinner", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                    startActivity(new Intent(getActivity(),Secundaria.class));
                }
            });
            venta.setNegativeButton("ListVIew", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int boton) {
                    startActivity(new Intent(getActivity(), Terceira.class));
                }
            });
            return venta.create();
        }
        return null;
    }

}
