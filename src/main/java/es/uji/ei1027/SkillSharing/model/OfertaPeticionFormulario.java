package es.uji.ei1027.SkillSharing.model;

public class OfertaPeticionFormulario {
    private String descripcionOferta;
    private String habilidadOferta;
    private int mesesExpiracionOferta;
    private String descripcionPeticion;
    private String habilidadPeticion;
    private int mesesExpiracionPeticion;


    public OfertaPeticionFormulario() {
    }

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }

    public String getHabilidadOferta() {
        return habilidadOferta;
    }

    public void setHabilidadOferta(String habilidadOferta) {
        this.habilidadOferta = habilidadOferta;
    }

    public int getMesesExpiracionOferta() {
        return mesesExpiracionOferta;
    }

    public void setMesesExpiracionOferta(int mesesExpiracionOferta) {
        this.mesesExpiracionOferta = mesesExpiracionOferta;
    }

    public String getDescripcionPeticion() {
        return descripcionPeticion;
    }

    public void setDescripcionPeticion(String descripcionPeticion) {
        this.descripcionPeticion = descripcionPeticion;
    }

    public String getHabilidadPeticion() {
        return habilidadPeticion;
    }

    public void setHabilidadPeticion(String habilidadPeticion) {
        this.habilidadPeticion = habilidadPeticion;
    }

    public int getMesesExpiracionPeticion() {
        return mesesExpiracionPeticion;
    }

    public void setMesesExpiracionPeticion(int mesesExpiracionPeticion) {
        this.mesesExpiracionPeticion = mesesExpiracionPeticion;
    }


    @Override
    public String toString() {
        return "OfertaPeticionFormulario{" +
                "descripcionOferta='" + descripcionOferta + '\'' +
                ", habilidadOferta='" + habilidadOferta + '\'' +
                ", mesesExpiracionOferta=" + mesesExpiracionOferta +
                ", descripcionPeticion='" + descripcionPeticion + '\'' +
                ", habilidadPeticion='" + habilidadPeticion + '\'' +
                ", mesesExpiracionPeticion=" + mesesExpiracionPeticion +
                '}';
    }
}
