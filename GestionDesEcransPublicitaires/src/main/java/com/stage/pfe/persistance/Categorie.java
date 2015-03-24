package com.stage.pfe.persistance;

public class Categorie {
	private Integer idCategorie;
	private String nomCategorie;
	
	
	public Categorie() {
		super();
	}
	public Categorie(Integer idCategorie, String nomCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
	}
	public Integer getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie="
				+ nomCategorie + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCategorie == null) ? 0 : idCategorie.hashCode());
		result = prime * result
				+ ((nomCategorie == null) ? 0 : nomCategorie.hashCode());
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
		Categorie other = (Categorie) obj;
		if (idCategorie == null) {
			if (other.idCategorie != null)
				return false;
		} else if (!idCategorie.equals(other.idCategorie))
			return false;
		if (nomCategorie == null) {
			if (other.nomCategorie != null)
				return false;
		} else if (!nomCategorie.equals(other.nomCategorie))
			return false;
		return true;
	}
	
	

}
