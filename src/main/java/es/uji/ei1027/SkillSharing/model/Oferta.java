package es.uji.ei1027.SkillSharing.model;

import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class Oferta {

    private String id_oferta;
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private LocalDate fecha_Inicio;
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private LocalDate fecha_Fin;
    private String descripcion;
    private String id_Habilidad;
    private String id_Estudiante;
    public Oferta(){
        super();
    }
    public Oferta(String id_oferta, LocalDate fecha_Inicio, LocalDate fecha_Fin, String descripcion, String id_Habilidad, String id_Estudiante) {
        this.id_oferta = id_oferta;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_Fin = fecha_Fin;
        this.descripcion = descripcion;
        this.id_Habilidad = id_Habilidad;
        this.id_Estudiante = id_Estudiante;
    }

    public String getId_oferta() {
        return id_oferta;
    }

    public String getFecha_Inicio() {
        return fecha_Inicio.toString();
    }

    public String getFecha_Fin() {
        return fecha_Fin.toString();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getId_Habilidad() {
        return id_Habilidad;
    }

    public String getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_oferta(String id_oferta) {
        this.id_oferta = id_oferta;
    }

    public void setFecha_Inicio(LocalDate fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public void setFecha_Fin(LocalDate   fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId_Habilidad(String id_Habilidad) {
        this.id_Habilidad = id_Habilidad;
    }

    public void setId_Estudiante(String id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    @Override
    public String toString() {
        return "oferta{" +
                "id_Oferta='" + id_oferta + '\'' +
                ", fecha_Inicio='" + fecha_Inicio + '\'' +
                ", fecha_Fin='" + fecha_Fin + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", id_Habilidad='" + id_Habilidad + '\'' +
                ", id_Estudiante='" + id_Estudiante + '\'' +
                '}';
    }

}
