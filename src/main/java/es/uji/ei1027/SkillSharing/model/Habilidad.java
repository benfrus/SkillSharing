package es.uji.ei1027.SkillSharing.model;

public class Habilidad {

        private String id_hab;
        private String nombre;
        private String tipo;
        private String descripcion;
        private String nivel;
        private String estado;

        public Habilidad() {
        }

        public String getId_hab() {
            return id_hab;
        }

        public void setId_hab(String id_hab) {
            this.id_hab = id_hab;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getNivel() {
            return nivel;
        }
        public void setNivel(String nivel){
            this.nivel=nivel;
        }
        public String getEstado(){
            return estado;
        }
        public void setEstado(String estado) {
            this.estado = estado;
        }

        @Override
        public String toString() {
            return "Habilidad{" +
                    "id_hab='" + id_hab + "\'" +
                    ", nombre='" + nombre + "\'" +
                    ", tipo='" + tipo + "\'" +
                    ", descripcion=" + descripcion +
                    ", nivel=" + nivel +
                    ", estado='" + estado + "\'" +
                    "}";
        }
    }


