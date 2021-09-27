package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.loopj.android.http.AsyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
import static com.example.myapplication.conductor.dnicon;
import static com.example.myapplication.acompanante.acompañantes;

import static com.example.myapplication.login.id_user;
import static com.example.myapplication.conductor.edtdni;
import static com.example.myapplication.login.localidad;
import static com.example.myapplication.login.user;
import static com.example.myapplication.vehiculo.edtdominio;
import static com.example.myapplication.vehiculo.id_veh;

public class registro2 extends Fragment {

    static Button btnVeh,btnVehy,btnCond,btnCondy,btnAcom,btnAcomy,btnCompl;
    View vistareg;
    String fecha;
    String id_vehi=id_veh+"";
    RadioButton Opcroja, Opcblanca;
    RadioGroup opcioneszona;
    static String condicionzona;
    TextView local;

    public registro2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vistareg = inflater.inflate(R.layout.fragment_registro2, container, false);
        btnVeh=vistareg.findViewById(R.id.button3);
        btnCond=vistareg.findViewById(R.id.button4);
        btnAcom=vistareg.findViewById(R.id.button6);
        btnCompl=vistareg.findViewById(R.id.button8);
        btnVehy=vistareg.findViewById(R.id.button33);
        btnAcomy=vistareg.findViewById(R.id.button66);
        btnCondy=vistareg.findViewById(R.id.button44);
        Opcroja=vistareg.findViewById(R.id.roja);
        Opcblanca=vistareg.findViewById(R.id.blanca);
        opcioneszona = vistareg.findViewById(R.id.opcioneszona);
        local = vistareg.findViewById(R.id.textView3);
        local.setText("Usted esta en: \n\n"+localidad);

        btnVehy.setVisibility(View.INVISIBLE);
        btnAcomy.setVisibility(View.VISIBLE);
        btnCondy.setVisibility(View.VISIBLE);


        btnCond.setEnabled(false);
        btnAcom.setEnabled(false);
        btnCompl.setEnabled(false);



        btnVeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validar();
                validarzona();
                // Crea el nuevo fragmento y la transacción.


            }
        });

        btnCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Crea el nuevo fragmento y la transacción.
                Fragment fragment = new conductor();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_principal, fragment);
                fragmentTransaction.addToBackStack(null);

                // Commit a la transacción
                fragmentTransaction.commit();

            }
        });

        btnAcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Crea el nuevo fragmento y la transacción.
                Fragment fragment = new acompanante();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_principal, fragment);
                fragmentTransaction.addToBackStack(null);

                // Commit a la transacción
                fragmentTransaction.commit();

            }
        });

        btnCompl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if (btnCond.isEnabled()) {

               // borrarvehiculo("http://sicopegnapol.atspace.cc/borrar_vehiculo.php");
                borrarvehiculo("https://sicopegna.000webhostapp.com/borrar_vehiculo.php");
                btnVeh.setEnabled(true);
                btnVeh.setVisibility(View.VISIBLE);
                btnVehy.setVisibility(View.INVISIBLE);
                btnCondy.setVisibility(View.VISIBLE);
                btnAcomy.setVisibility(View.VISIBLE);
            }

            else {

                Toast.makeText(getContext(), "REGISTRO COMPLETADO", Toast.LENGTH_SHORT).show();
                btnVeh.setEnabled(true);
                btnCond.setEnabled(false);
                btnAcom.setEnabled(false);
                btnCompl.setEnabled(false);
                btnVeh.setVisibility(View.VISIBLE);
                btnVehy.setVisibility(View.INVISIBLE);
                btnCond.setVisibility(View.INVISIBLE);
                btnCondy.setVisibility(View.VISIBLE);
                btnAcom.setVisibility(View.INVISIBLE);
                btnAcomy.setVisibility(View.VISIBLE);

                dnicon = "";
                acompañantes.clear();

                opcioneszona.clearCheck();
            }
            }
        });



        return vistareg;
    }

    private void validarveh(){
        if (dnicon.length()>0){
            dnicon="";
            acompañantes.clear();}

        //if (dnicon==null) borrarvehiculo("http://192.168.1.53/sicopegnapol/borrar_vehiculo.php?id_vehiculo="+id_vehi);

    }

    private void validar(){
        if (Opcroja.isChecked()==true) condicionzona = "1";
        if (Opcblanca.isChecked()==true) condicionzona = "0";

    }

    private void validarzona(){

        if (Opcroja.isChecked()==false & Opcblanca.isChecked()==false) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("DEBE TILDAR UNA DE LAS 2 OPCIONES");
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
        else {
            Fragment fragment = new vehiculo();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_principal, fragment);
            fragmentTransaction.addToBackStack(null);

            // Commit a la transacción
            fragmentTransaction.commit();

        }

    }

    private void borrarvehiculo(final String URL){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    btnCompl.setEnabled(false);
                    Toast.makeText(getContext(),"VEHICULO VACIO BORRADO:   "+edtdominio.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getContext(),"NO SE PUDO BORRAR VEHICULO VACIO, ERROR EN LA CONEXION", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("dominio",edtdominio.getText().toString().toUpperCase());

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }

}
