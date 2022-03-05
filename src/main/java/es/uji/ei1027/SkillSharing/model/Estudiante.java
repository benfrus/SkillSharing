package es.uji.ei1027.SkillSharing.model;

public class Estudiante {
    String id_estudiante;
    String nombre_usuario;
    String contraseña;
    String nombre;
    String apellidos;
    String email;
    String grado;
    int curso;

    public Estudiante(){

    }

    public String getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(String id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "estudiante{" +
                "id_estudiante='" + id_estudiante + '\'' +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", grado='" + grado + '\'' +
                ", curso=" + curso +
                '}';
    }
}
