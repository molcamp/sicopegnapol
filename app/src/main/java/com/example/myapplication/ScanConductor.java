package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.example.myapplication.conductor.edtape;
import static com.example.myapplication.conductor.edtdni;
import static com.example.myapplication.conductor.edtnombre;


public class ScanConductor extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView ScannerView;
    String enca;
    String [] cadena;
    char caracter;
    int numeroDeVeces;
    TextView toastText;
    View layout;
    Toast toast;
    static String apellidoenca;
    static String nombreenca;
    static String dnienca;
    static String ejemplar;
    static String celular = "1";
    @Override
    protected  void  onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);
        // ScannerView.setResultHandler(this);
        // ScannerView.startCamera();
    }



    @Override
    public void handleResult(Result result) {


        ScannerView.resumeCameraPreview(this);

        if (result.getText().length()<45) {

            ScannerView.resumeCameraPreview(this);

        }
        if (result.getText().length()>=45){

            enca = result.getText();
            caracter = '@';
            numeroDeVeces = contarCaracteres(enca,caracter);

            if (numeroDeVeces < 10) {


                cadena = enca.split("@");
                apellidoenca = cadena[1];
                nombreenca = cadena[2];
                ejemplar = cadena[5];
                dnienca = cadena[4];
                //dnienca = Integer.parseInt(cadena[4]);
            }

            if (numeroDeVeces > 10){

                cadena = enca.split("@");
                apellidoenca = cadena[4];
                nombreenca = cadena[5];
                ejemplar = cadena[2];
                dnienca = cadena[1];


            }

            edtape.setText(apellidoenca);
            edtnombre.setText(nombreenca);
            edtdni.setText(dnienca);
            //WebView.loadUrl("http://192.168.10.200:80/dbescusub/sala8.php?variable="+apellidoenca+"&variable1="+nombreenca+"&variable2="+dnienca+"&variable3="+ejemplar+"&variable4="+celular);
            onPause();
            onBackPressed();
            //Intent i = new Intent(ScanEnca.this, ChequeoEnca.class);
          //  finish();
          //  startActivity(new Intent(getApplicationContext(),ChequeoEnca.class));
            //startActivity(i);

        }


    }

    public static int contarCaracteres(String cad, char caracter) {
        int posicion, contador = 0;
        //se busca la primera vez que aparece
        posicion = cad.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = cad.indexOf(caracter, posicion + 1);
        }
        return contador;
    }



    protected void onPause() {
        super.onPause();

        ScannerView.stopCamera();
    }

    protected void onResume(){
        super.onResume();
        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
        Toast.makeText(getBaseContext(), "INGRESE DOCUMENTO",Toast.LENGTH_SHORT).show();

    }







}