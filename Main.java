package org.example.vista;

import org.example.Controlador.Elcontrolador;
import org.example.Modelo.Facultad;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elcontrolador controlador = new Elcontrolador();
        String opcion;

        while (true) {
            System.out.println("\n--- MENÚ ---" +
                    "\n1) Consultar Facultad" + // si 1
                    "\n2) Modificar Facultad" + //si 2
                    "\n3) Registrar Estudiante a Facultad" + //si 3
                    "\n4) Consultar Estudinate en Departamento" +
                    "\n5) Modificar Estudiante al Departamento " +
                    "\n6) Agregar Asignatura" + // si 6
                    "\n7) Consultar Asignaturas" + // si 7
                    "\n8) Modificar Asignatura " +
                    "\n9) Registrar Estudiante en Asignatura" + // si 9
                    "\n10) Consultar Estudiantes en Asignatura  "  +
                    "\n11) Crear Lista de Asistencia" + // s i11
                    "\n12) Llenar Lista de Asistencia" + // si12
                    "\n13) Actualizar Lista de Asistencia" + // si 13
                    "\n14) listar asistencia " +
                    "\n15) Salir" + // 15
                    "\nSeleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1": // Consultar Facultad
                    Facultad facultad = controlador.consultarFacultad();
                    if (facultad != null) {
                        System.out.println("Nombre de la Facultad: " + facultad.getNombre());
                    } else {
                        System.out.println("No hay facultad registrada.");
                    }
                    break;

                case "2": // Modificar Facultad
                    System.out.print("Ingrese el nuevo nombre de la facultad: ");
                    String nuevoNombre = scanner.nextLine();
                    controlador.modificarFacultad(nuevoNombre);
                    System.out.println("Facultad modificada.");
                    break;

                case "3": // Registrar Estudiante a Facultad
                    System.out.print("Nombre del estudiante: ");
                    String nombreEst = scanner.nextLine();
                    System.out.print("Tipo de documento: ");
                    String tipoId = scanner.nextLine();
                    System.out.print("Número de documento: ");
                    String numeroDoc = scanner.nextLine();
                    controlador.registrarEstudianteFacultad(nombreEst, numeroDoc, tipoId);
                    break;

                case "4": // Consultar Estudiante (a implementar si se desea)
                    System.out.println("Funcionalidad no implementada.");
                    break;

                case "5": // Modificar Estudiante (a implementar si se desea)
                    System.out.println("Funcionalidad no implementada.");
                    break;

                case "6": // Agregar Asignatura
                    System.out.print("Código de la asignatura: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    String grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    String semestre = scanner.nextLine();
                    System.out.print("Nombre de la asignatura: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Créditos: ");
                    String creditos = scanner.nextLine();
                    controlador.agregarAsignatura(codigo, grupo, semestre, nombre, creditos);
                    break;

                case "7": // Consultar Asignaturas
                    controlador.consultarAsignaturas();
                    break;

                case "8": // Eliminar Asignatura
                    System.out.print("Código de la asignatura a eliminar: ");
                    String codEliminar = scanner.nextLine();
                    System.out.print("Grupo: ");
                    String grupoEliminar = scanner.nextLine();
                    System.out.print("Semestre: ");
                    String semEliminar = scanner.nextLine();
                    controlador.eliminarAsignatura(codEliminar, grupoEliminar, semEliminar);
                    break;

                case "9": // Registrar Estudiante en Asignatura
                    System.out.print("Código de asignatura: ");
                    String codAsignatura = scanner.nextLine();
                    System.out.print("Grupo: ");
                    String grupoAsignatura = scanner.nextLine();
                    System.out.print("Semestre: ");
                    String semAsignatura = scanner.nextLine();
                    System.out.print("Número de documento del estudiante: ");
                    String docEst = scanner.nextLine();
                    controlador.registrarEstudianteAsignatura(codAsignatura, grupoAsignatura, semAsignatura, docEst);
                    break;

                case "10": // Consultar Estudiantes en Asignatura (no implementado aún)
                    System.out.println("Funcionalidad no implementada.");
                    break;

                case "11": // Crear Lista de Asistencia
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Hora de inicio: ");
                    String inicio = scanner.nextLine();
                    System.out.print("Hora de fin: ");
                    String fin = scanner.nextLine();
                    controlador.crearAsistencia(fecha, inicio, fin);
                    break;

                case "12": // Llenar Lista de Asistencia
                    System.out.print("Fecha de la asistencia: ");
                    String fechaLlenar = scanner.nextLine();
                    System.out.print("Documento del estudiante: ");
                    String docAsist = scanner.nextLine();
                    System.out.print("Estado (Presente/Ausente): ");
                    String estado = scanner.nextLine();
                    controlador.llenarAsistencia(fechaLlenar, docAsist, estado);
                    break;

                case "13": // Actualizar Lista de Asistencia
                    System.out.print("Fecha de la asistencia: ");
                    String fechaAct = scanner.nextLine();
                    System.out.print("Documento del estudiante: ");
                    String docUpdate = scanner.nextLine();
                    System.out.print("Nuevo estado: ");
                    String nuevoEstado = scanner.nextLine();
                    controlador.actualizarAsistencia(fechaAct, docUpdate, nuevoEstado);
                    break;

                case "14": // Listar asistencia (falta método en controlador)
                    System.out.println("Funcionalidad no implementada.");
                    break;

                case "15":
                    System.out.println("Saliendo del sistema...");
                    return;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        }
    }
}
//"\n1) Consultar Departamento" +   Nombre departamento
//"\n2) Modificar Departamento" + Nombre
//"\n3) Registrar Estudiante en Departamento " +  Nombre, tipo de documento y numero de documento
//"\n4) Consultar Estudinate en Departamento" + tipo de documento, numero de documento, muestra nombre completo
//"\n5) Modificar Estudiante al Departamento " + tipo de documento y numero , se pide NUMERO de documento, NOMBRE
//"\n6) Agregar asignatura " +  Nombre asignatura, codigo, creditos, seccion, semestre
//"\n7) Consultar Asignatura" + Nombre devuelve, codigo, semestre, seccion
//"\n8) Modificar Asignatura " +  codigo, seccion, semestre, se cambia el nombre y cantidad de creditos
//"\n9) Registrar Estudiante en la Asignatura " +  tipo de documento, numero de documento, codigo asignatura, seccion de asignatura, semestre
//"\n10) Consultar Estudiantes en Asignatura  "  + devuelve tipo de docuemtno y numero de documento de todos lod estuiantes  codigo semestre y seccion
//"\n11) Crear Lista de Asistencia Vacia  " + codigo, semestre, grupo, fecha u hora de inicio, con numero de documento
//"\n12) llenar asistencia " + presente, ausente, presente con retardo . devuelve cada fila de la lista asistencia la fecha y la hora asignatura
//"\n13) modificar asistencia " + modificar el estado - 3 asignatura 2 de asistneica 2 del estudiante tipo de documento y numero
//"\n14) listar asistencia " + 3 de asignatura 2 de la asistencia+
//"\n15)  salir " +
