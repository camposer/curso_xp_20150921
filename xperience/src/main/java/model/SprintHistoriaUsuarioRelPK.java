package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SPRINT_HISTORIA_USUARIO_REL database table.
 * 
 */
@Embeddable
public class SprintHistoriaUsuarioRelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_SPRINT", insertable=false, updatable=false)
	private int idSprint;

	@Column(name="ID_HISTORIA", insertable=false, updatable=false)
	private int idHistoria;

	public SprintHistoriaUsuarioRelPK() {
	}
	public int getIdSprint() {
		return this.idSprint;
	}
	public void setIdSprint(int idSprint) {
		this.idSprint = idSprint;
	}
	public int getIdHistoria() {
		return this.idHistoria;
	}
	public void setIdHistoria(int idHistoria) {
		this.idHistoria = idHistoria;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SprintHistoriaUsuarioRelPK)) {
			return false;
		}
		SprintHistoriaUsuarioRelPK castOther = (SprintHistoriaUsuarioRelPK)other;
		return 
			(this.idSprint == castOther.idSprint)
			&& (this.idHistoria == castOther.idHistoria);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idSprint;
		hash = hash * prime + this.idHistoria;
		
		return hash;
	}
}