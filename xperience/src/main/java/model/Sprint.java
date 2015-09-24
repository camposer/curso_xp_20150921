package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SPRINT database table.
 * 
 */
@Entity
@NamedQuery(name="Sprint.findAll", query="SELECT s FROM Sprint s")
public class Sprint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ESFUERZO_TOTAL")
	private Integer esfuerzoTotal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FIN")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INI")
	private Date fechaIni;

	private String nombre;

//	//bi-directional many-to-many association to HistoriaUsuario
//	@ManyToMany
//	@JoinTable(
//		name="SPRINT_HISTORIA_USUARIO_REL"
//		, joinColumns={
//			@JoinColumn(name="ID_SPRINT")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="ID_HISTORIA")
//			}
//		)
//	private List<HistoriaUsuario> historiaUsuarios;

	//bi-directional many-to-one association to SprintHistoriaUsuarioRel
	@OneToMany(mappedBy="sprint")
	private List<SprintHistoriaUsuarioRel> sprintHistoriaUsuarioRels;

	public Sprint() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEsfuerzoTotal() {
		return this.esfuerzoTotal;
	}

	public void setEsfuerzoTotal(Integer esfuerzoTotal) {
		this.esfuerzoTotal = esfuerzoTotal;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIni() {
		return this.fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public List<HistoriaUsuario> getHistoriaUsuarios() {
//		return this.historiaUsuarios;
//	}
//
//	public void setHistoriaUsuarios(List<HistoriaUsuario> historiaUsuarios) {
//		this.historiaUsuarios = historiaUsuarios;
//	}

	public List<SprintHistoriaUsuarioRel> getSprintHistoriaUsuarioRels() {
		return this.sprintHistoriaUsuarioRels;
	}

	public void setSprintHistoriaUsuarioRels(List<SprintHistoriaUsuarioRel> sprintHistoriaUsuarioRels) {
		this.sprintHistoriaUsuarioRels = sprintHistoriaUsuarioRels;
	}

	public SprintHistoriaUsuarioRel addSprintHistoriaUsuarioRel(SprintHistoriaUsuarioRel sprintHistoriaUsuarioRel) {
		getSprintHistoriaUsuarioRels().add(sprintHistoriaUsuarioRel);
		sprintHistoriaUsuarioRel.setSprint(this);

		return sprintHistoriaUsuarioRel;
	}

	public SprintHistoriaUsuarioRel removeSprintHistoriaUsuarioRel(SprintHistoriaUsuarioRel sprintHistoriaUsuarioRel) {
		getSprintHistoriaUsuarioRels().remove(sprintHistoriaUsuarioRel);
		sprintHistoriaUsuarioRel.setSprint(null);

		return sprintHistoriaUsuarioRel;
	}

}