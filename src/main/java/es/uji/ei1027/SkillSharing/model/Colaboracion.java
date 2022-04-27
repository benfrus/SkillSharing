package es.uji.ei1027.SkillSharing.model;

import java.time.LocalTime;

public class Colaboracion {

    private String id_colab;
    private String fecha_inicio;
    private String fecha_fin;
    private int horas_totales;
    private  String evaluacion;
    private  String comenatio;
    private  String id_oferta;
    private  String id_pet;
    private  String estado;

    public Colaboracion(){ super(); }

    public Colaboracion(String id_colab, String fecha_inicio, String fecha_fin, int horas_totales,
                        String evaluacion, String comenatio, String id_oferta, String id_pet, String estado) {
        this.id_colab = id_colab;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.horas_totales = horas_totales;
        this.evaluacion = evaluacion;
        this.comenatio = comenatio;
        this.id_oferta = id_oferta;
        this.id_pet = id_pet;
        this.estado = estado;
    }


    public String getId_colab() {
        return id_colab;
    }

    public void setId_colab(String id_colab) {
        this.id_colab = id_colab;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
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

    public String getComenatio() {
        return comenatio;
    }

    public void setComenatio(String comenatio) {
        this.comenatio = comenatio;
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

    @Override
    public String toString() {
        return "Colaboracion{" +
                "Identificador de la colaboración='" + id_colab + "\'" +
                ", fecha de inicio='" + fecha_inicio + "\'" +
                ", fecha de fin='" + fecha_fin + "\'" +
                ", horas totales=" + horas_totales + "\'" +
                ", evaluacion='" + evaluacion + "\'" +
                ", comentario='" + comenatio + "\'" +
                ", identificador de la oferta=" + id_oferta + "\'" +
                ", identificador de la petición='" + id_pet + "\'" +
                ", estado='" + estado + "\'" +
                "}";
    }
}
