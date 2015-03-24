package com.stage.pfe.persistance;

public class Jour {
	private Integer idJour;
	private Integer numJour;
	
	
	public Jour() {
		super();
	}
	public Jour(Integer idJour, Integer numJour) {
		super();
		this.idJour = idJour;
		this.numJour = numJour;
	}
	public Integer getIdJour() {
		return idJour;
	}
	public void setIdJour(Integer idJour) {
		this.idJour = idJour;
	}
	public Integer getNumJour() {
		return numJour;
	}
	public void setNumJour(Integer numJour) {
		this.numJour = numJour;
	}
	@Override
	public String toString() {
		return "Jour [idJour=" + idJour + ", numJour=" + numJour + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idJour == null) ? 0 : idJour.hashCode());
		result = prime * result + ((numJour == null) ? 0 : numJour.hashCode());
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
		Jour other = (Jour) obj;
		if (idJour == null) {
			if (other.idJour != null)
				return false;
		} else if (!idJour.equals(other.idJour))
			return false;
		if (numJour == null) {
			if (other.numJour != null)
				return false;
		} else if (!numJour.equals(other.numJour))
			return false;
		return true;
	}
	
	
}
