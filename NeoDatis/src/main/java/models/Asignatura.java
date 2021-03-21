package models;

import java.util.List;

public class Asignatura {

	private int cod_asignatura;
	private String nombre;

	public Asignatura(int cod_asignatura, String nombre) {
		this.cod_asignatura = cod_asignatura;
		this.nombre = nombre;
	}

	public int getCod_asignatura() {
		return cod_asignatura;
	}

	public void setCod_asignatura(int cod_asignatura) {
		this.cod_asignatura = cod_asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Asignatura codigo de asignatura=" + cod_asignatura + ", nombre=" + nombre;
	}
}
