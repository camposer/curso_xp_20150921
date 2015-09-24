package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	private Integer id;

	private String descripcion;

	private Integer esfuerzo;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Integer prioridad;

	private String titulo;
	
	private Integer orden;

	//bi-directional many-to-many association to Sprint
//	@ManyToMany(mappedBy="historiaUsuarios")
//	private List<Sprint> sprints;

	//bi-directional many-to-one association to SprintHistoriaUsuarioRel
	@OneToMany(mappedBy="historiaUsuario")
	private List<SprintHistoriaUsuarioRel> sprintHistoriaUsuarioRels;

	public HistoriaUsuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer s) {
		this.estatus = s;
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

//	public List<Sprint> getSprints() {
//		return this.sprints;
//	}
//
//	public void setSprints(List<Sprint> sprints) {
//		this.sprints = sprints;
//	}

	public List<SprintHistoriaUsuarioRel> getSprintHistoriaUsuarioRels() {
		return this.sprintHistoriaUsuarioRels;
	}

	public void setSprintHistoriaUsuarioRels(List<SprintHistoriaUsuarioRel> sprintHistoriaUsuarioRels) {
		this.sprintHistoriaUsuarioRels = sprintHistoriaUsuarioRels;
	}

	public SprintHistoriaUsuarioRel addSprintHistoriaUsuarioRel(SprintHistoriaUsuarioRel sprintHistoriaUsuarioRel) {
		getSprintHistoriaUsuarioRels().add(sprintHistoriaUsuarioRel);
		sprintHistoriaUsuarioRel.setHistoriaUsuario(this);

		return sprintHistoriaUsuarioRel;
	}

	public SprintHistoriaUsuarioRel removeSprintHistoriaUsuarioRel(SprintHistoriaUsuarioRel sprintHistoriaUsuarioRel) {
		getSprintHistoriaUsuarioRels().remove(sprintHistoriaUsuarioRel);
		sprintHistoriaUsuarioRel.setHistoriaUsuario(null);

		return sprintHistoriaUsuarioRel;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	

}