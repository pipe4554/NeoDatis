package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Profesor {

    private int cod_profesor;
    private String nombre, apellidos, sexo, fechaNacimiento;
    private List<Asignatura> asignaturas;

    public Profesor(int cod_profesor, String nombre, String apellidos, String sexo, String fechaNacimiento) {
        this.cod_profesor = cod_profesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        asignaturas = new ArrayList<Asignatura>();
    }

    public int getCod_profesor() {
        return cod_profesor;
    }

    public void setCod_profesor(int cod_profesor) {
        this.cod_profesor = cod_profesor;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Profesor cod de profesor=" + cod_profesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo="
                + sexo + ", fechaNacimiento=" + fechaNacimiento + ", asignaturas=" + asignaturas;
    }
}
