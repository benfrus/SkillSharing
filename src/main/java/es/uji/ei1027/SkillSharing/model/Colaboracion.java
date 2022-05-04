package es.uji.ei1027.SkillSharing.model;

import ch.qos.logback.core.joran.util.StringToObjectConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalTime;

public class Colaboracion {


    private String id_colab;
    private String fecha_inicio;
    private String fecha_fin;
    private int horas_totales;
    private  String evaluacion;
    private  String comentario;
    private  String id_oferta;
    private  String id_pet;
    private  String estado;



    public String getId_colab() {
        return id_colab;
    }

    public void setId_colab(String id_colab) {
        this.id_colab = id_colab;
    }

    public String getFecha_inicio() { return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getHoras_totales() {
        return horas_totales;
    }

    public void setHoras_totales(int horas_totales) {
        this.horas_totales = horas_totales;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(String id_oferta) {
        this.id_oferta = id_oferta;
    }

    public String getId_pet() {
        return id_pet;
    }

    public void setId_pet(String id_pet) {
        this.id_pet = id_pet;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Colaboracion(){

    }

    @Override
    public String toString() {
        return "Colaboracion{" +
                "id_colab='" + id_colab + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_fin='" + fecha_fin + '\'' +
                ", horas_totales=" + horas_totales +
                ", evaluacion='" + evaluacion + '\'' +
                ", comentario='" + comentario + '\'' +
                ", id_oferta='" + id_oferta + '\'' +
                ", id_pet='" + id_pet + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
