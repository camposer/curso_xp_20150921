package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HISTORIA_USUARIO database table.
 * 
 */
@Entity
@Table(name="HISTORIA_USUARIO")
@NamedQuery(name="HistoriaUsuario.findAll", query="SELECT h FROM HistoriaUsuario h")
public class HistoriaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=1000)
	private String descripcion;

	private Integer esfuerzo;

	@Column(nullable=false)
	private Short estatus;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	private Integer prioridad;

	@Column(nullable=false, length=250)
	private String titulo;

	public HistoriaUsuario() {
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

}