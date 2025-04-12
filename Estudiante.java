package org.example.Modelo;

public class Estudiante {
    private String nombre;
    private String numeroDocumento;
    private String tipoIdentidad;

    public Estudiante(String nombre, String numeroDocumento, String tipoIdentidad) {
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.tipoIdentidad = tipoIdentidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    public String getTipoIdentidad() { return tipoIdentidad; }
    public void setTipoIdentidad(String tipoIdentidad) { this.tipoIdentidad = tipoIdentidad; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", tipoIdentidad='" + tipoIdentidad + '\'' +
                '}';
    }
}
