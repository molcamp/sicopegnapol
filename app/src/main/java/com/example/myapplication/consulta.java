package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

import static com.example.myapplication.login.localidad;


/**
 * A simple {@link Fragment} subclass.
 */
public class consulta extends Fragment {

    View vista;
    EditText edni,edom;
    Button consultadni,consultadom;
    ListView listadni,listaveh;
    String tipo,zona,condicion_pers;
    private AsyncHttpClient cliente;
    String local = localidad.replace(" ","%20");
    public consulta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_consulta, container, false);
        edni = vista.findViewById(R.id.dni);
        edom = vista.findViewById(R.id.dominio);
        consultadni = vista.findViewById(R.id.consultardni);
        consultadom = vista.findViewById(R.id.consultardom);
        listadni = vista.findViewById(R.id.listadni);
        listaveh = vista.findViewById(R.id.listadom);
        cliente = new AsyncHttpClient();



        consultadni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               obtenerlista();


            }
        });

        consultadom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                obtenerlistaveh();


            }
        });


        return vista;
    }



    private void obtenerlista(){
       // String url = "http://sicopegnapol.atspace.cc/consulta_persona.php?dni="+edni.getText()+"&id_local="+local;
        String url = "https://sicopegna.000webhostapp.com/consulta_persona.php?dni="+edni.getText()+"&id_local="+local;

        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200){
                    listarPersona(new String(responseBody));
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void obtenerlistaveh(){
       // String url = "http://sicopegnapol.atspace.cc/consulta_vehiculo.php?dominio="+edom.getText()+"&id_local="+local;
        String url = "https://sicopegna.000webhostapp.com/consulta_vehiculo.php?dominio="+edom.getText()+"&id_local="+local;

        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200){
                    listarVehiculo(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void listarPersona (String respuesta){
        ArrayList <persona> lista = new ArrayList<persona>();

        try {
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for (int i=0; i<jsonArreglo.length();i++){

                if (jsonArreglo.getJSONObject(i).getInt("tipo")==1)tipo = "Conductor";
                else if (jsonArreglo.getJSONObject(i).getInt("tipo")==0)tipo = "Acompañante";
                if (jsonArreglo.getJSONObject(i).getInt("zona")==0)zona = "Blanca";
                else if (jsonArreglo.getJSONObject(i).getInt("zona")==1)zona = "Roja";
                if (jsonArreglo.getJSONObject(i).getInt("condicion_pers")==0)condicion_pers = "Entrada";
                else if (jsonArreglo.getJSONObject(i).getInt("condicion_pers")==1)condicion_pers = "Salida";

                persona p = new persona();
                p.setTipo("\n"+tipo+"\n");
                p.setApellido("Apellido:   "+jsonArreglo.getJSONObject(i).getString("apellido")+"\n");
                p.setNombre("Nombre:   "+jsonArreglo.getJSONObject(i).getString("nombre")+"\n");
                p.setDni("DNI:   "+jsonArreglo.getJSONObject(i).getString("dni")+"\n");
                p.setLugar("Lugar:   "+jsonArreglo.getJSONObject(i).getString("lugar_residencia")+"\n");
                p.setFecha("Fecha:   "+jsonArreglo.getJSONObject(i).getString("fecha_persona")+"\n");
                p.setDominio("Dominio:   "+jsonArreglo.getJSONObject(i).getString("dominio")+"\n");
                p.setDescAuto("Vehiculo:   "+jsonArreglo.getJSONObject(i).getString("descripcion")+"\n");
                p.setZona("Zona:   "+zona+"\n");
                p.setCondicion_pers("Condicion:   "+condicion_pers+"\n");

                lista.add(p);

            }
            ArrayAdapter <persona> a = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,lista);
            listadni.setAdapter(a);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (lista.isEmpty()) {

            listadni.setAdapter(null);
           // Toast.makeText(getContext(),"DNI NO ENCONTRADO EN LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("DNI NO ENCONTRADO EN LA BASE DE DATOS");
            builder.setTitle("SICOPEGNAPOL");
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void listarVehiculo (String respuesta){
        ArrayList <persona> lista = new ArrayList<persona>();
        try {
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for (int i=0; i<jsonArreglo.length();i++){

                if (jsonArreglo.getJSONObject(i).getInt("tipo")==1)tipo = "Conductor";
                else if (jsonArreglo.getJSONObject(i).getInt("tipo")==0)tipo = "Acompañante";
                if (jsonArreglo.getJSONObject(i).getInt("zona")==0)zona = "Blanca";
                else if (jsonArreglo.getJSONObject(i).getInt("zona")==1)zona = "Roja";
                if (jsonArreglo.getJSONObject(i).getInt("condicion_pers")==0)condicion_pers = "Entrada";
                else if (jsonArreglo.getJSONObject(i).getInt("condicion_pers")==1)condicion_pers = "Salida";

                persona p = new persona();
                p.setTipo("\n"+tipo+"\n");
                p.setApellido("Apellido:   "+jsonArreglo.getJSONObject(i).getString("apellido")+"\n");
                p.setNombre("Nombre:   "+jsonArreglo.getJSONObject(i).getString("nombre")+"\n");
                p.setDni("DNI:   "+jsonArreglo.getJSONObject(i).getString("dni")+"\n");
                p.setLugar("Lugar:   "+jsonArreglo.getJSONObject(i).getString("lugar_residencia")+"\n");
                p.setFecha("Fecha:   "+jsonArreglo.getJSONObject(i).getString("fecha_persona")+"\n");
                p.setDominio("Dominio:   "+jsonArreglo.getJSONObject(i).getString("dominio")+"\n");
                p.setDescAuto("Vehiculo:   "+jsonArreglo.getJSONObject(i).getString("descripcion")+"\n");
                p.setZona("Zona:   "+zona+"\n");
                p.setCondicion_pers("Condicion:   "+condicion_pers+"\n");

                lista.add(p);

            }
            ArrayAdapter <persona> a = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,lista);
            listaveh.setAdapter(a);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (lista.isEmpty()) {

            listaveh.setAdapter(null);
          //  Toast.makeText(getContext(),"DOMINIO NO ENCONTRADO EN LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("DOMINIO NO ENCONTRADO EN LA BASE DE DATOS");
            builder.setTitle("SICOPEGNAPOL");
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }
}
