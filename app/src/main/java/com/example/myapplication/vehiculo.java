package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.myapplication.ScanConductor.apellidoenca;
import static com.example.myapplication.ScanConductor.dnienca;
import static com.example.myapplication.ScanConductor.nombreenca;
import static com.example.myapplication.login.id_user;
import static com.example.myapplication.registro2.btnCompl;
import static com.example.myapplication.registro2.btnCond;
import static com.example.myapplication.registro2.btnCondy;
import static com.example.myapplication.registro2.btnVeh;
import static com.example.myapplication.registro2.btnVehy;

/**
 * A simple {@link Fragment} subclass.
 */
public class vehiculo extends Fragment {

  static   EditText edtdominio,edtDesc;
    Button btnreg, btnvolver;
    View vista;
    RadioButton Opcparticular, Opctransporte;
    RadioGroup opciones;
    static String tipo;
    static String usuario=id_user+"";
    static int id_veh;
    String dominio,desc;
    static String dominio1;
    boolean valido;

    public vehiculo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_vehiculo, container, false);
        btnreg=vista.findViewById(R.id.buttonveh);
        btnvolver=vista.findViewById(R.id.button9);
        edtdominio=vista.findViewById(R.id.editDominio);
        edtDesc=vista.findViewById(R.id.editDesc);
        Opcparticular=vista.findViewById(R.id.particular);
        Opctransporte=vista.findViewById(R.id.transporte);
        opciones = vista.findViewById(R.id.opciones);


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validartipo();

                validarcampos();

            }
        });

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getParentFragmentManager().popBackStack();


            }
        });


        return vista;
    }

    private void validartipo(){
        if (Opcparticular.isChecked()==true) tipo = "0";
        if (Opctransporte.isChecked()==true) tipo = "1";

    }


    private void validarcampos(){

        dominio = edtdominio.getText().toString().toUpperCase();
        desc = edtDesc.getText().toString().toUpperCase();


        if ( dominio.matches("") || desc.matches("") || opciones.getCheckedRadioButtonId()==-1 ) {



            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("No ha ingresado los datos correctamente");
            builder.setTitle("CORROBORE LOS DATOS INGRESADOS");

            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

      //  else validarVehiculo("http://sicopegnapol.atspace.cc/registrar_vehiculo.php");
        else validarVehiculo("https://sicopegna.000webhostapp.com/registrar_vehiculo.php");
    }



    private void validarVehiculo(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){


                    Toast.makeText(getContext(),"VEHICULO REGISTRADO", Toast.LENGTH_SHORT).show();
                    getParentFragmentManager().popBackStack();
                    btnVeh.setVisibility(View.INVISIBLE);
                    btnVehy.setVisibility(View.VISIBLE);
                    btnCondy.setVisibility(View.INVISIBLE);
                    btnCond.setEnabled(true);
                    btnCompl.setEnabled(true);

                }else {
                    Toast.makeText(getContext(),"NO SE PUDO REGISTRAR, ERROR EN LA CONEXION", Toast.LENGTH_SHORT).show();
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
                parametros.put("descripcion",edtDesc.getText().toString().toUpperCase());
                parametros.put("tipo",tipo);
                parametros.put("id_user",usuario);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


}