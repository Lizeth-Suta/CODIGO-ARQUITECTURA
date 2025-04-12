package org.example.Controlador;

import org.example.Modelo.*;

import java.util.ArrayList;

public class Elcontrolador {
    private Facultad facultad = new Facultad();
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Asistencia> asistencias = new ArrayList<>();

    public boolean crearFacultad(String nombre) {
        facultad.setNombre(nombre);
        return true;
    }

    public Facultad consultarFacultad() {
        return facultad;
    }

    public boolean modificarFacultad(String nombre) {
        facultad.setNombre(nombre);
        return true;
    }

    public boolean agregarAsignatura(String codigo, String seccion, String semestre, String nombre, String creditos) {
        facultad.agregarAsignatura(codigo, seccion, semestre, nombre, Integer.parseInt(creditos));
        return true;
    }

    public void registrarEstudianteFacultad(String nombre, String numeroDocumento, String tipoIdentidad) {
        Estudiante estudiante = new Estudiante(nombre, numeroDocumento, tipoIdentidad);
        estudiantes.add(estudiante);
        System.out.println("Estudiante registrado en la facultad.");
    }

    public void consultarAsignaturas() {
        for (Asignatura asignatura : facultad.getAsignaturas()) {
            System.out.println(asignatura);
        }
    }

    public void eliminarAsignatura(String codigo, String grupo, String semestre) {
        facultad.eliminarAsignatura(codigo, grupo, semestre);
        System.out.println("Asignatura eliminada si existía.");
    }

    public void registrarEstudianteAsignatura(String codigo, String grupo, String semestre, String numeroDocumento) {
        Asignatura asignatura = facultad.consultarAsignatura(codigo, grupo, semestre);
        Estudiante estudiante = buscarEstudiante(numeroDocumento);
        if (asignatura != null && estudiante != null) {
            // Aquí deberías guardar los estudiantes en la asignatura (se puede agregar esta lógica después)
            System.out.println("Estudiante " + estudiante.getNombre() + " registrado en la asignatura: " + asignatura.getNombre());
        } else {
            System.out.println("Asignatura o estudiante no encontrado.");
        }
    }

    public void crearAsistencia(String fecha, String horaInicio, String horaFin) {
        Asistencia asistencia = new Asistencia(fecha, horaInicio, horaFin);
        asistencias.add(asistencia);
        System.out.println("Lista de asistencia creada.");
    }

    public void llenarAsistencia(String fecha, String codigoEstudiante, String estado) {
        Asistencia asistencia = buscarAsistenciaPorFecha(fecha);
        if (asistencia != null) {
            asistencia.adicionarAsistencia(codigoEstudiante, estado);
            System.out.println("Asistencia registrada.");
        } else {
            System.out.println("No se encontró lista de asistencia para esa fecha.");
        }
    }

    public void actualizarAsistencia(String fecha, String codigoEstudiante, String nuevoEstado) {
        Asistencia asistencia = buscarAsistenciaPorFecha(fecha);
        if (asistencia != null && asistencia.modificarAsistencia(codigoEstudiante, nuevoEstado)) {
            System.out.println("Asistencia actualizada.");
        } else {
            System.out.println("No se pudo actualizar la asistencia.");
        }
    }

    public Estudiante consultarEstudiante(String tipo, String numero) {
        for (Estudiante e : estudiantes) {
            if (e.getTipoIdentidad().equalsIgnoreCase(tipo) &&
                    e.getNumeroDocumento().equalsIgnoreCase(numero)) {
                return e;
            }
        }
        return null;
    }

    public void consultarEstudiantesEnAsignatura(String codigo, String grupo, String semestre) {
        Asignatura asignatura = facultad.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            System.out.println("No hay estudiantes registrados directamente. (Funcionalidad simbólica)");
        } else {
            System.out.println("Asignatura no encontrada.");
        }
    }

    public void listarAsistencia(String fecha) {
        Asistencia asistencia = buscarAsistenciaPorFecha(fecha);
        if (asistencia != null) {
            System.out.println("Asistencia del " + fecha + ":");
            ArrayList<String> codigos = asistencia.getCodigos();
            ArrayList<String> estados = asistencia.getEstados();
            for (int i = 0; i < codigos.size(); i++) {
                System.out.println("Estudiante: " + codigos.get(i) + " - Estado: " + estados.get(i));
            }
        } else {
            System.out.println("No se encontró asistencia para esa fecha.");
        }
    }

    // Métodos auxiliares privados
    private Estudiante buscarEstudiante(String numeroDocumento) {
        for (Estudiante e : estudiantes) {
            if (e.getNumeroDocumento().equalsIgnoreCase(numeroDocumento)) {
                return e;
            }
        }
        return null;
    }

    private Asistencia buscarAsistenciaPorFecha(String fecha) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equalsIgnoreCase(fecha)) {
                return a;
            }
        }
        return null;
    }
}

