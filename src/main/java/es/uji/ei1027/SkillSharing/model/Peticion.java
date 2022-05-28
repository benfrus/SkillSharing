package es.uji.ei1027.SkillSharing.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Peticion {
    private String id_Pet;
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private LocalDate fecha_Inicio;
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private LocalDate fecha_Fin;
    private String descripcion;
    private String id_Habilidad;
    private String id_Estudiante;
    private String estado;
    public Peticion(){
        super();
    }

    public String getId_Pet() {
        return id_Pet;
    }

    public void setId_Pet(String id_Pet) {
        this.id_Pet = id_Pet;
    }

    public LocalDate getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(LocalDate fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public LocalDate getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(LocalDate fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_Habilidad() {
        return id_Habilidad;
    }

    public void setId_Habilidad(String id_Habilidad) {
        this.id_Habilidad = id_Habilidad;
    }

    public String getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(String id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
