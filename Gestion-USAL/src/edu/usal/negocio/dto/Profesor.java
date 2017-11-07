package edu.usal.negocio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Profesores")
public class Profesor implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Profesor")
	private int id;
	@Column(name="Nombres")
	private String nombre;
	@Column(name="Apellido")
	private String apellido;
	@Column(name="Telefono_Particular")
	private String telefonoParticular;
	@Column(name="Telefono_Celular")
	private String telefonoCelular;
	@Column(name="Direccion")
	private String direccion;
	@ManyToMany(cascade=CascadeType.ALL)	
	@JoinTable(name="ProfesorCatedra", joinColumns={@JoinColumn(name="Id_Profesor")}, inverseJoinColumns={@JoinColumn(name="Id_Catedra")})
	private List<Catedra> catedra;
	
	public Profesor() {
		
	}
	
	public Profesor(int id, String nombre, String apellido, String telefonoParticular, String telefonoCelular,
			String direccion) {		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonoParticular = telefonoParticular;
		this.telefonoCelular = telefonoCelular;
		this.direccion = direccion;
		this.catedra = new ArrayList<Catedra>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefonoParticular() {
		return telefonoParticular;
	}

	public void setTelefonoParticular(String telefonoParticular) {
		this.telefonoParticular = telefonoParticular;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Catedra> getCatedra() {
		return catedra;
	}

	public void setCatedra(List<Catedra> catedra) {
		this.catedra = catedra;
	}
		
}
