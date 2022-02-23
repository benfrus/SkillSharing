package es.uji.ei1027.SkillSharing.model;

public class Peticion {
    private String id_Pet;
    private String fecha_Inicio;
    private String fecha_Fin;
    private String descripcion;
    private String id_Habilidad;
    private String id_Estudiante;
    public Peticion(){
        super();
    }
    public Peticion(String id_Pet, String fecha_Inicio, String fecha_Fin, String descripcion, String id_Habilidad, String id_Estudiante) {
        this.id_Pet = id_Pet;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_Fin = fecha_Fin;
        this.descripcion = descripcion;
        this.id_Habilidad = id_Habilidad;
        this.id_Estudiante = id_Estudiante;
    }

    public String getId_Pet() {
        return id_Pet;
    }

    public void setId_Pet(String id_Pet) {
        this.id_Pet = id_Pet;
    }

    public String getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(String fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public String getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(String fecha_Fin) {
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

    @Override
    public String toString() {
        return "Peticion{" +
                "id_Pet='" + id_Pet + '\'' +
                ", fecha_Inicio='" + fecha_Inicio + '\'' +
                ", fecha_Fin='" + fecha_Fin + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", id_Habilidad='" + id_Habilidad + '\'' +
                ", id_Estudiante='" + id_Estudiante + '\'' +
                '}';
    }
}
