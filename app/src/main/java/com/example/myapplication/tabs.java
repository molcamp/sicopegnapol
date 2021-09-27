package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


import java.util.HashMap;
import java.util.Map;

import static com.example.myapplication.login.opciones;
import static com.example.myapplication.login.sesion;
import static com.example.myapplication.login.condicion;
import static com.example.myapplication.registro2.btnCond;
import static com.example.myapplication.registro2.btnCompl;
import static com.example.myapplication.vehiculo.dominio1;
import static com.example.myapplication.vehiculo.edtdominio;

public class tabs extends AppCompatActivity {


    final private int REQUEST_CODE_ASK_PERMISSION=111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        TabLayout tabLayout =findViewById(R.id.pestañas);

        TabItem tabregistro = findViewById(R.id.tab1);
        TabItem consulta = findViewById(R.id.tab2);

        final ViewPager viewPager = findViewById(R.id.viewpager);

        final PagerCan pagerCan = new PagerCan(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(pagerCan);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                /*if (tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                else if (tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                else if (tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }*/


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        solicitarpermisos();

    }

    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            //super.onBackPressed();
            //additional code

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Que desea hacer?");
        builder.setTitle("SICOPEGNAPOL");

        if (sesion==true) {
            builder.setPositiveButton("Cerrar Sesion", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    if (btnCond.isEnabled()) {

                        if (btnCompl.isEnabled())
                    //    borrarvehiculo("http://192.168.1.53/sicopegnapol/borrar_vehiculo.php");
                          borrarvehiculo("https://sicopegna.000webhostapp.com/borrar_vehiculo.php");

                    }

                    opciones.clearCheck();
                    sesion = false;
                    condicion = "";
                    finish();

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

        }

        else {
            getSupportFragmentManager().popBackStack();
        }


    }

    private void solicitarpermisos() {
        int permisoCamara = ActivityCompat.checkSelfPermission(tabs.this, Manifest.permission.CAMERA);

        if (permisoCamara!= PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CODE_ASK_PERMISSION);

            }

        }
    }


    private void borrarvehiculo(final String URL){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Toast.makeText(getApplicationContext(),"VEHICULO VACIO BORRADO:   "+edtdominio.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(),"NO SE PUDO BORRAR VEHICULO VACIO, ERROR EN LA CONEXION", Toast.LENGTH_SHORT).show();
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
                parametros.put("dominio",edtdominio.getText().toString().toUpperCase());

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }
    /*public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Queres Cerrar la Sesion?");
        builder.setTitle("App ESCUSUB");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //Intent i = new Intent(TabActivity.this, login.class);

               // startActivity(i);
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


    }*/
}
