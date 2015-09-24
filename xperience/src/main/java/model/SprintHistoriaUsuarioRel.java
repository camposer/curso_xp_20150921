package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SPRINT_HISTORIA_USUARIO_REL database table.
 * 
 */
@Entity
@Table(name="SPRINT_HISTORIA_USUARIO_REL")
@NamedQuery(name="SprintHistoriaUsuarioRel.findAll", query="SELECT s FROM SprintHistoriaUsuarioRel s")
public class SprintHistoriaUsuarioRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SprintHistoriaUsuarioRelPK id;
	
	@Column(name="ORDEN")
	private Integer orden;

	//bi-directional many-to-one association to HistoriaUsuario
	@ManyToOne()
	@JoinColumn(name="ID_HISTORIA", insertable=false, updatable=false)
	private HistoriaUsuario historiaUsuario;

	//bi-directional many-to-one association to Sprint
	@ManyToOne
	@JoinColumn(name="ID_SPRINT", insertable=false, updatable=false)
	private Sprint sprint;

	public SprintHistoriaUsuarioRel() {
	}

	public SprintHistoriaUsuarioRelPK getId() {
		return this.id;
	}

	public void setId(SprintHistoriaUsuarioRelPK id) {
		this.id = id;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public HistoriaUsuario getHistoriaUsuario() {
		return this.historiaUsuario;
	}

	public void setHistoriaUsuario(HistoriaUsuario historiaUsuario) {
		this.historiaUsuario = historiaUsuario;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

}