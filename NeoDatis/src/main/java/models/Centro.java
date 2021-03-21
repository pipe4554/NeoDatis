package models;

import java.util.*;

public class Centro {

	private int cod_centro;
	private String nombre, direccion, localidad, provincia;
	private Profesor director;
	private List<Profesor> profesores;

	public Centro(int cod_centro, String nombre, String direccion, String localidad, String provincia) {
		this.cod_centro = cod_centro;
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		director = null;
		profesores = new ArrayList<Profesor>();
	}

	public int getCod_centro() {
		return cod_centro;
	}

	public void setCod_centro(int cod_centro) {
		this.cod_centro = cod_centro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Profesor getDirector() {
		return director;
	}

	public void setDirector(Profesor director) {
		this.director = director;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Centro codigo de centro=" + cod_centro + ", nombre=" + nombre + ", direccion=" + direccion + ", localidad="
				+ localidad + ", provincia=" + provincia + ", director=" + director + ", profesores=" + profesores;
	}
}
