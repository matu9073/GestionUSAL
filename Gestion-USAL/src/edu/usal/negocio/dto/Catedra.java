package edu.usal.negocio.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Catedra")
public class Catedra implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Catedra")
	private int id;
	@Column(name="Nombre_Catedra")
	private String nombre;
	@Column(name="Anio_Cursada")
	private int anio;
	@Column(name="Horario_Cursada")	
	private String horario;
	@Column(name="Dia_Cursada")
	private String dia;
	@Column(name="Turno_Cursada")
	private String turno;
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="catedra")
	List<Profesor> profesores;
	
	public Catedra() {
		
	}

	public Catedra(int id, String nombre, int anio, String horario, String dia, String turno) {		
		this.id = id;
		this.nombre = nombre;
		this.anio = anio;
		this.horario = horario;
		this.dia = dia;
		this.turno = turno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}	
	
}
