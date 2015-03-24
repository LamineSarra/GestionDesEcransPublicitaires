package com.stage.pfe.persistance;

public class Ville {
	private Integer idVille;
	private String nomVille;
	
	
	public Ville() {
		super();
	}
	public Ville(Integer idVille, String nomVille) {
		super();
		this.idVille = idVille;
		this.nomVille = nomVille;
	}
	public Integer getIdVille() {
		return idVille;
	}
	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", nomVille=" + nomVille + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVille == null) ? 0 : idVille.hashCode());
		result = prime * result
				+ ((nomVille == null) ? 0 : nomVille.hashCode());
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
		Ville other = (Ville) obj;
		if (idVille == null) {
			if (other.idVille != null)
				return false;
		} else if (!idVille.equals(other.idVille))
			return false;
		if (nomVille == null) {
			if (other.nomVille != null)
				return false;
		} else if (!nomVille.equals(other.nomVille))
			return false;
		return true;
	}
	
	
}
