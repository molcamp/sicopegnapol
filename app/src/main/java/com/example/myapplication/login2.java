package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * A simple {@link Fragment} subclass.
 */
public class login2 extends Fragment {

    EditText edtusuario,edtpassword;
    Button btnlogin;
    View vista;
    static int id_user;




    public login2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_login2, container, false);
        btnlogin=vista.findViewById(R.id.buttonlogin);
        edtusuario=vista.findViewById(R.id.editText);
        edtpassword=vista.findViewById(R.id.editText2);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarUsuario("http://sicopegnapol.atspace.cc/validar_usuario.php");
             //   validarUsuario("http://192.168.1.53/sicopegnapol/validar_usuario.php");


            }
        });


        return vista;
    }




    private void validarUsuario(String URL){



        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (!response.isEmpty()){

                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        id_user = jsonObject.getInt("id");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.pestañas);

                  //  TabLayout tabhost1 = (TabLayout) getActivity().findViewById(R.id.viewpager);



                LinearLayout tabStrip = ((LinearLayout)tabhost.getChildAt(0));
                //LinearLayout tabStrip1 = ((LinearLayout)tabhost1.getChildAt(0));

                tabStrip.getChildAt(2).setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                    }
                });
                tabStrip.getChildAt(1).setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                    }
                });
                tabStrip.getChildAt(0).setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return true;
                    }
                });







                tabhost.getTabAt(1).select();


            }else {
                Toast.makeText(getContext(),"Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
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
                parametros.put("usuario",edtusuario.getText().toString());
                parametros.put("password",edtpassword.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }






}
