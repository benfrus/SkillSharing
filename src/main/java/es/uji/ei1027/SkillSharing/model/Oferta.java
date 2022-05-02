package es.uji.ei1027.SkillSharing.model;

public class Oferta {
    private String id_Oferta;
    private String fecha_Inicio;
    private String fecha_Fin;
    private String descripcion;
    private String id_Habilidad;
    private String id_Estudiante;
    public Oferta(){
        super();
    }
    public Oferta(String id_Oferta, String fecha_Inicio, String fecha_Fin, String descripcion, String id_Habilidad, String id_Estudiante) {
        this.id_Oferta = id_Oferta;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_Fin = fecha_Fin;
        this.descripcion = descripcion;
        this.id_Habilidad = id_Habilidad;
        this.id_Estudiante = id_Estudiante;
    }

    public String getId_Oferta() {
        return id_Oferta;
    }

    public String getFecha_Inicio() {
        return fecha_Inicio;
    }

    public String getFecha_Fin() {
        return fecha_Fin;
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

    public void setId_Oferta(String id_Oferta) {
        this.id_Oferta = id_Oferta;
    }

    public void setFecha_Inicio(String fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public void setFecha_Fin(String fecha_Fin) {
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
                "id_Oferta='" + id_Oferta + '\'' +
                ", fecha_Inicio='" + fecha_Inicio + '\'' +
                ", fecha_Fin='" + fecha_Fin + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", id_Habilidad='" + id_Habilidad + '\'' +
                ", id_Estudiante='" + id_Estudiante + '\'' +
                '}';
    }

}
