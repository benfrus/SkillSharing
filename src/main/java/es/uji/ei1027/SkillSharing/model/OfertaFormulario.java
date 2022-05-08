package es.uji.ei1027.SkillSharing.model;

public class OfertaFormulario {
    private String descripcion;
    private String habilidad;
    private int mesesExpiracion;

    public OfertaFormulario() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getMesesExpiracion() {
        return mesesExpiracion;
    }

    public void setMesesExpiracion(int mesesExpiracion) {
        this.mesesExpiracion = mesesExpiracion;
    }
}
