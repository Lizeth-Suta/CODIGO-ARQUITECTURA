package org.example.Modelo;

import java.util.ArrayList;

public class Facultad {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;

    public Facultad() {
        this.nombre = "";
        this.asignaturas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<Asignatura> getAsignaturas() { return asignaturas; }
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) { this.asignaturas = asignaturas; }

    public void agregarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        Asignatura asignatura = new Asignatura(codigo, grupo, semestre, nombre, creditos);
        asignaturas.add(asignatura);
        System.out.println("Asignatura agregada exitosamente...");
    }

    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre) {
        for (Asignatura asignatura : asignaturas) {
            if (codigo.equalsIgnoreCase(asignatura.getCodigo()) &&
                    grupo.equalsIgnoreCase(asignatura.getGrupo()) &&
                    semestre.equalsIgnoreCase(asignatura.getSemestre())) {
                return asignatura;
            }
        }
        return null;
    }

    public boolean actualizarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        Asignatura asignatura = this.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.setNombre(nombre);
            asignatura.setCreditos(creditos);
            return true;
        }
        return false;
    }

    public void eliminarAsignatura(String codigo, String grupo, String semestre) {
        asignaturas.removeIf(asignatura ->
                codigo.equalsIgnoreCase(asignatura.getCodigo()) &&
                        grupo.equalsIgnoreCase(asignatura.getGrupo()) &&
                        semestre.equalsIgnoreCase(asignatura.getSemestre()));
    }
}
