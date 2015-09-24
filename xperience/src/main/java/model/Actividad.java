package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ACTIVIDAD database table.
 * 
 */
@Entity
@Table(name="ACTIVIDAD")
@NamedQuery(name="Actividad.findAll", query="SELECT h FROM Actividad h")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=1000)
	private String descripcion = "";

	private Integer esfuerzo;

	@Column
	private Short estatus = 0;

	@Column(name="usuario_id")
	private Integer usuarioId = 0;

	@Column(name="historia_usuario_id")
	private Integer historiaUsuarioId = 0;

	private Integer prioridad;

	@Column(length=250)
	private String titulo = "";

	public Actividad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEsfuerzo() {
		return this.esfuerzo;
	}

	public void setEsfuerzo(Integer esfuerzo) {
		this.esfuerzo = esfuerzo;
	}

	public Short getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Short estatus) {
		this.estatus = estatus;
	}

	public Integer getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getHistoriaUsuarioId() {
		return historiaUsuarioId;
	}

	public void setHistoriaUsuarioId(Integer historiaUsuarioId) {
		this.historiaUsuarioId = historiaUsuarioId;
	}

}