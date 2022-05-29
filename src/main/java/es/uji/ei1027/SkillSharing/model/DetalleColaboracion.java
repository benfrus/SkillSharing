package es.uji.ei1027.SkillSharing.model;

public class DetalleColaboracion {
    String idColaboracion;
    String estudianteOferta;
    String descripcionOferta;
    String estudiantePeticion;
    String descripcionPeticion;

    public DetalleColaboracion() {
    }

    public String getIdColaboracion() {
        return idColaboracion;
    }

    public void setIdColaboracion(String idColaboracion) {
        this.idColaboracion = idColaboracion;
    }

    public String getEstudianteOferta() {
        return estudianteOferta;
    }

    public void setEstudianteOferta(String estudianteOferta) {
        this.estudianteOferta = estudianteOferta;
    }

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }

    public String getEstudiantePeticion() {
        return estudiantePeticion;
    }

    public void setEstudiantePeticion(String estudiantePeticion) {
        this.estudiantePeticion = estudiantePeticion;
    }

    public String getDescripcionPeticion() {
        return descripcionPeticion;
    }

    public void setDescripcionPeticion(String descripcionPeticion) {
        this.descripcionPeticion = descripcionPeticion;
    }
}
