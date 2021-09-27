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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import static com.example.myapplication.conductor.dnicon;
import static com.example.myapplication.login.condicion;
import static com.example.myapplication.registro2.condicionzona;
import static com.example.myapplication.vehiculo.usuario;


/**
 * A simple {@link Fragment} subclass.
 */
public class acompanante extends Fragment {

    static EditText edtape,edtnombre,edtdni,edtlugar,edttiempo;
    Button btnreg, btnvolver, btnEscanerA;
    View vista;
    int tipoveh,reincidente,contador,id_persona,tipopersona = 0,zona;
    String fecha=null,fechaactual=null,dniacom;
    String apellido,nombre,dni,lugar,tiempo,reincidente1,id_persona1;

    static ArrayList<String> acompañantes = new ArrayList<String>();

    public acompanante() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_acompanante, container, false);
        btnreg=vista.findViewById(R.id.acomreg);
        btnvolver=vista.findViewById(R.id.acomvolver);
        edtape=vista.findViewById(R.id.acomape);
        edtnombre=vista.findViewById(R.id.acomnom);
        edtdni=vista.findViewById(R.id.acomdni);
        edtlugar=vista.findViewById(R.id.acomlugar);
        edttiempo=vista.findViewById(R.id.acomtime);
        btnEscanerA=vista.findViewById(R.id.button10);



        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  buscarfechapersona("http://192.168.1.53/sicopegnapol/buscar_persona.php?dni="+edtdni.getText());
                    validarcampos();

            }
        });

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getParentFragmentManager().popBackStack();


            }
        });

        btnEscanerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ScanAcompañante.class);

                startActivity(intent);


            }
        });





        return vista;
    }

    private void validarcampos(){

        apellido = edtape.getText().toString().toUpperCase();
        nombre = edtnombre.getText().toString().toUpperCase();
        dni = edtdni.getText().toString().toUpperCase();
        lugar = edtlugar.getText().toString().toUpperCase();
        tiempo = edttiempo.getText().toString().toUpperCase();

        if ( apellido.matches("") || nombre.matches("") || dni.matches("") || lugar.matches("")
                || tiempo.matches("") || apellido.length()<3 || nombre.length()<3 || dni.length()<7 || lugar.length()<3  ) {



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


        else validar2();

    }

    private void validar2(){


        if (dni.equals(dnicon)){

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("EL DNI ES EL MISMO QUE EL DEL CONDUCTOR");
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



        else validar3();

    }

    private void validar3(){


        if (acompañantes.contains(dni)){

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());       //MENSAJE DE ALERTA DE DNI REPETIDO
            builder.setMessage("YA INGRESO ESTE DNI EN EL VEHICULO");
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

    //    else buscarfechapersona("http://192.168.1.53/sicopegnapol/buscar_persona.php?dni="+dni);
        else buscarfechapersona("https://sicopegna.000webhostapp.com/buscar_persona.php?dni="+dni);
    }

    private void registrarpersona(String URL){

        acompañantes.add(dni);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){

                    Toast.makeText(getContext(),"ACOMPAÑANTE REGISTRADO", Toast.LENGTH_SHORT).show();
                    getParentFragmentManager().popBackStack();
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
                parametros.put("apellido",edtape.getText().toString().toUpperCase());
                parametros.put("nombre",edtnombre.getText().toString().toUpperCase());
                parametros.put("dni",edtdni.getText().toString().toUpperCase());
                parametros.put("lugar_residencia",edtlugar.getText().toString().toUpperCase());
                parametros.put("tiempo_permanencia",edttiempo.getText().toString().toUpperCase());
                parametros.put("tipo", String.valueOf(tipopersona));
                parametros.put("id_usuario",usuario);
                parametros.put("condicion_pers",condicion);
                parametros.put("zona",condicionzona);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


    private void registrarreincidencia(final String URL){



        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){

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
                parametros.put("id_persona",id_persona1);
                parametros.put("reincidente",reincidente1);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


    private void buscarfechapersona(String URL){




        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override


            public void onResponse(JSONArray response) {


                JSONObject jsonObject = null;



                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);




                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = new Date();
                        fechaactual = dateFormat.format(date);

                        fecha = jsonObject.getString("fecha_persona");
                        tipoveh = jsonObject.getInt("tipo_vehiculo");
                        reincidente = jsonObject.getInt("reincidente");
                        id_persona = jsonObject.getInt("id_persona");
                        zona = jsonObject.getInt("zona");

                        id_persona1 = Integer.toString(id_persona);



                        /*    if (zona == 0)
                                registrarpersona("http://192.168.1.53/sicopegnapol/registrar_persona.php");*/

                        if (zona==0) registrarpersona("https://sicopegna.000webhostapp.com/registrar_persona.php");

                            else if (zona == 1) {


                                //fecha =("2020-06-15 03:03:32");
                                Date ahora = dateFormat.parse(fechaactual);
                                Date inicio = dateFormat.parse(fecha);
                                int dias = (int) ((ahora.getTime() - inicio.getTime()) / 86400000);

                                if (tipoveh == 0) {
                                    int falta = 14 - dias;
                                    if (dias < 14 & reincidente == 0) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                        builder.setMessage("LE FALTA " + String.valueOf(falta) + " DIAS PARA CUMPLIR CUARENTENA");
                                        builder.setTitle("VIOLACION DE CUARENTENA");

                                        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        AlertDialog dialog = builder.create();
                                        dialog.show();

                                        // Toast.makeText(getContext(), "LE FALTA " + String.valueOf(falta) + " DIAS PARA CUMPLIR CUARENTENA", Toast.LENGTH_SHORT).show();
                                        contador = reincidente + 1;
                                        reincidente1 = contador + "";
                                    //    registrarreincidencia("http://192.168.1.53/sicopegnapol/registrar_reincidente.php");
                                        registrarreincidencia("https://sicopegna.000webhostapp.com/registrar_reincidente.php");

                                    } else if (dias < 14 & reincidente > 0) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                        builder.setMessage("LE FALTA " + String.valueOf(falta) + " DIAS PARA CUMPLIR CUARENTENA. PERSONA REINCIDENTE. NUMERO DE REINCIDENCIA: " + reincidente);
                                        builder.setTitle("VIOLACION DE CUARENTENA");

                                        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        AlertDialog dialog = builder.create();
                                        dialog.show();

                                        //Toast.makeText(getContext(), "LE FALTA " + String.valueOf(falta) + " DIAS PARA CUMPLIR CUARENTENA. PERSONA REINCIDENTE. NUMERO DE REINCIDENCIA: "+reincidente, Toast.LENGTH_SHORT).show();
                                        contador = reincidente + 1;
                                        reincidente1 = contador + "";
                                    //    registrarreincidencia("http://192.168.1.53/sicopegnapol/registrar_reincidente.php");
                                        registrarreincidencia("https://sicopegna.000webhostapp.com/registrar_reincidente.php");
                                    } else
                                    //    registrarpersona("http://192.168.1.53/sicopegnapol/registrar_persona.php");
                                        registrarpersona("https://sicopegna.000webhostapp.com/registrar_persona.php");
                                    // Toast.makeText(getContext(),"LA PERSONA CUMPLIO LA CUARENTENA", Toast.LENGTH_SHORT).show();
                                }

                                if (tipoveh == 1) {
                                    int falta = dias;
                                    if (dias < 1) {
                                    //    registrarpersona("http://192.168.1.53/sicopegnapol/registrar_persona.php");
                                        registrarpersona("https://sicopegna.000webhostapp.com/registrar_persona.php");

                                    } else if (dias > 0 & reincidente == 0) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                        builder.setMessage("SE EXCEDIO " + String.valueOf(falta) + " DIA/S DE LA CUARENTENA");
                                        builder.setTitle("VIOLACION DE CUARENTENA");

                                        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        AlertDialog dialog = builder.create();
                                        dialog.show();

                                        //Toast.makeText(getContext(), "SE EXCEDIO " + String.valueOf(falta) + " DIA/S DE LA CUARENTENA", Toast.LENGTH_SHORT).show();
                                        contador = reincidente + 1;
                                        reincidente1 = contador + "";
                                    //    registrarreincidencia("http://192.168.1.53/sicopegnapol/registrar_reincidente.php");
                                        registrarreincidencia("https://sicopegna.000webhostapp.com/registrar_reincidente.php");

                                    } else if (dias > 0 & reincidente > 0) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                        builder.setMessage("SE EXCEDIO " + String.valueOf(falta) + " DIA/S DE LA CUARENTENA. PERSONA REINCIDENTE. NUMERO DE REINCIDENCIA: " + reincidente);
                                        builder.setTitle("VIOLACION DE CUARENTENA");

                                        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        AlertDialog dialog = builder.create();
                                        dialog.show();

                                        //Toast.makeText(getContext(), "SE EXCEDIO " + String.valueOf(falta) + " DIA/S DE LA CUARENTENA. PERSONA REINCIDENTE. NUMERO DE REINCIDENCIA: "+reincidente, Toast.LENGTH_SHORT).show();
                                        contador = reincidente + 1;
                                        reincidente1 = contador + "";
                                    //    registrarreincidencia("http://192.168.1.53/sicopegnapol/registrar_reincidente.php");
                                        registrarreincidencia("https://sicopegna.000webhostapp.com/registrar_reincidente.php");
                                    }


                                }

                            }


                    } catch (JSONException | ParseException e) {

                        //registrarpersona("http://192.168.1.53/sicopegnapol/registrar_persona.php");
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }




                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            //    registrarpersona("http://192.168.1.53/sicopegnapol/registrar_persona.php");
                registrarpersona("https://sicopegna.000webhostapp.com/registrar_persona.php");
                // Toast.makeText(getContext(),error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);

    }


}