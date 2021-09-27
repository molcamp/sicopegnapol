package com.example.myapplication;

public class persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String lugar;
    private String fecha;
    private String dominio;
    private String DescAuto;
    private String tipo;
    private String zona;
   private String condicion_pers;

    public persona(){
    }

    public persona (String nombre,String apellido,String dni,String lugar, String fecha,String dominio,String DescAuto, String tipo, String zona, String condicion_pers){
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.lugar = lugar;
            this.fecha = fecha;
            this.dominio = dominio;
            this.DescAuto = DescAuto;
            this.tipo = tipo;
            this.zona = zona;
            this.condicion_pers = condicion_pers;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getDescAuto() {
        return DescAuto;
    }

    public void setDescAuto(String descAuto) {
        DescAuto = descAuto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCondicion_pers() {
        return condicion_pers;
    }

    public void setCondicion_pers(String condicion_pers) {
        this.condicion_pers = condicion_pers;
    }

    @Override
    public String toString() {
        return tipo+nombre+apellido+dni+lugar+fecha+dominio+DescAuto+zona+condicion_pers;
    }
}
