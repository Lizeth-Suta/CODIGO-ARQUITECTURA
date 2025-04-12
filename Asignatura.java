package org.example.Modelo;

import java.util.ArrayList;

public class Asignatura {
    private String codigo = "";
    private String grupo = "";
    private String semestre = "";
    private String nombre = "";
    private int creditos = 0;
    private ArrayList<Asistencia> asistencias = new ArrayList<>();
    private ArrayList<String> estudiantes = new ArrayList<>(); // Lista de documentos de estudiantes

    public Asignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.semestre = semestre;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() { return codigo; }
    public String getGrupo() { return grupo; }
    public String getNombre() { return nombre; }
    public String getSemestre() { return semestre; }
    public int getCreditos() { return creditos; }
    public ArrayList<String> getEstudiantes() { return estudiantes; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public void agregarEstudiante(String numeroDocumento) {
        if (!estudiantes.contains(numeroDocumento)) {
            estudiantes.add(numeroDocumento);
        }
    }

    public boolean adicionAsistencia(String fecha, String horainicial, String horafinal, ArrayList<String> codigos, ArrayList<String> estados) {
        Asistencia asistencia = new Asistencia(fecha, horainicial, horafinal);
        for (int vc = 0; vc < codigos.size(); vc++) {
            String codigo = codigos.get(vc);
            String estado = estados.get(vc);
            asistencia.adicionarAsistencia(codigo, estado);
        }
        asistencias.add(asistencia);
        return true;
    }

    public Asistencia consultarAsistencia(String fecha, String horainicial, String horafinal) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equalsIgnoreCase(fecha) &&
                    a.getHorainicial().equalsIgnoreCase(horainicial) &&
                    a.getHorafinal().equalsIgnoreCase(horafinal)) {
                return a;
            }
        }
        return null;
    }

    public Asistencia modificarAsistencia(String fecha, String horainicial, String horafinal, ArrayList<String> codigos, ArrayList<String> estados) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equalsIgnoreCase(fecha) &&
                    a.getHorainicial().equalsIgnoreCase(horainicial) &&
                    a.getHorafinal().equalsIgnoreCase(horafinal)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ASIGNATURA - Código: " + codigo + ", Grupo: " + grupo + ", Semestre: " + semestre + ", Nombre: " + nombre + ", Créditos: " + creditos;
    }
}
