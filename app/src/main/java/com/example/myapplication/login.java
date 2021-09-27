package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

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

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.AllowAllHostnameVerifier;
import cz.msebera.android.httpclient.conn.ssl.SSLConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.SSLContextBuilder;
import cz.msebera.android.httpclient.conn.ssl.TrustStrategy;
import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.client.HttpClients;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;


public class login extends AppCompatActivity {

    EditText edtusuario,edtpassword;
    Button btnlogin;

    static int id_user;
    static boolean sesion=false;
    RadioButton OpcEntrada, OpcSalida;
    static RadioGroup opciones;
    static String condicion,user,localidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin=(Button) findViewById(R.id.buttonlogin);
        edtusuario=(EditText) findViewById(R.id.editText);
        edtpassword=(EditText) findViewById(R.id.editText2);
        OpcEntrada=(RadioButton) findViewById(R.id.entrada);
        OpcSalida=(RadioButton) findViewById(R.id.salida);
        opciones = (RadioGroup) findViewById(R.id.opcionesLog);




        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validar();
                validarcond();
             //   validarUsuario("http://192.168.1.53/sicopegnapol/validar_usuario.php");


            }
        });






    }
    private void validar(){
        if (OpcEntrada.isChecked()==true) condicion = "0";
        if (OpcSalida.isChecked()==true) condicion = "1";
    }

    private void validarcond(){

        if (OpcEntrada.isChecked()==false & OpcSalida.isChecked()==false) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
        else if (edtusuario.getText().toString().isEmpty() || edtpassword.getText().toString().isEmpty() ){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("INGRESE USUARIO Y CONTRASEÑA");
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

        else validarUsuario("https://sicopegna.000webhostapp.com/validar_usuario.php");

        //   validarUsuario("https://controlcuarentena.ddns.net/sicopegnapol/validar_usuario.php");
    }

    private void validarUsuario(String URL){



        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (!response.isEmpty()){

                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        id_user = jsonObject.getInt("id");
                        localidad = jsonObject.getString("id_local");
                        user = id_user+"";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                    Intent i = new Intent(login.this, tabs.class);

                    //Intent i = new Intent(login.this, TabActivity.class);

                    startActivity(i);

                    edtusuario.setText("");
                    edtpassword.setText("");



                    sesion = true;



                }else {
                    Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("usuario",edtusuario.getText().toString());
                parametros.put("password",edtpassword.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }




    public void onBackPressed() {


            //super.onBackPressed();
            //additional code

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Que desea hacer?");
            builder.setTitle("SICOPEGNAPOL");


            if (sesion==false) {
                builder.setNeutralButton("Salir de la Aplicacion", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        edtusuario.setText("");
                        edtpassword.setText("");
                        opciones.clearCheck();
                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory(Intent.CATEGORY_HOME);
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                    }
                });
            }

            builder.setNegativeButton("Nada", new DialogInterface.OnClickListener() {
            @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
        });

            AlertDialog dialog = builder.create();
            dialog.show();



        /*else {
            getSupportFragmentManager().popBackStack();
        }*/


    }


    private void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }});
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager(){
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {}
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {}
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }}}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());
        } catch (Exception e) { // should never happen
            e.printStackTrace();
        }
    }










}
