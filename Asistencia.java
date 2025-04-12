package org.example.Modelo;

import java.util.ArrayList;

public class Asistencia {
    private String fecha = "";
    private String horainicial = "";
    private String horafinal = "";
    private ArrayList<String> codigos = new ArrayList<>();
    private ArrayList<String> estados = new ArrayList<>();

    public Asistencia() {}

    public Asistencia(String fecha, String horainicial, String horafinal) {
        this.fecha = fecha;
        this.horainicial = horainicial;
        this.horafinal = horafinal;
    }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getHorainicial() { return horainicial; }
    public void setHorainicial(String horainicial) { this.horainicial = horainicial; }
    public String getHorafinal() { return horafinal; }
    public void setHorafinal(String horafinal) { this.horafinal = horafinal; }
    public ArrayList<String> getCodigos() { return codigos; }
    public void setCodigos(ArrayList<String> codigos) { this.codigos = codigos; }
    public ArrayList<String> getEstados() { return estados; }
    public void setEstados(ArrayList<String> estados) { this.estados = estados; }

    public boolean adicionarAsistencia(String codigo, String estado) {
        codigos.add(codigo);
        estados.add(estado);
        return true;
    }

    public String consultarAsistencia(String codigo) {
        for (int vc = 0; vc < codigos.size(); vc++) {
            if (codigos.get(vc).equalsIgnoreCase(codigo)) {
                return estados.get(vc);
            }
        }
        return null;
    }

    public boolean modificarAsistencia(String codigo, String estado) {
        for (int vc = 0; vc < codigos.size(); vc++) {
            if (codigos.get(vc).equalsIgnoreCase(codigo)) {
                estados.set(vc, estado);
                return true;
            }
        }
        return false;
    }
}
