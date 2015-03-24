package com.stage.pfe.persistance;

public class Heure {
	private Integer idHeure;
	private Integer heure;
	
	
	public Heure() {
		super();
	}
	public Heure(Integer idHeure, Integer heure) {
		super();
		this.idHeure = idHeure;
		this.heure = heure;
	}
	public Integer getIdHeure() {
		return idHeure;
	}
	public void setIdHeure(Integer idHeure) {
		this.idHeure = idHeure;
	}
	public Integer getHeure() {
		return heure;
	}
	public void setHeure(Integer heure) {
		this.heure = heure;
	}
	@Override
	public String toString() {
		return "Heure [idHeure=" + idHeure + ", heure=" + heure + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heure == null) ? 0 : heure.hashCode());
		result = prime * result + ((idHeure == null) ? 0 : idHeure.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heure other = (Heure) obj;
		if (heure == null) {
			if (other.heure != null)
				return false;
		} else if (!heure.equals(other.heure))
			return false;
		if (idHeure == null) {
			if (other.idHeure != null)
				return false;
		} else if (!idHeure.equals(other.idHeure))
			return false;
		return true;
	}
	
	

}
