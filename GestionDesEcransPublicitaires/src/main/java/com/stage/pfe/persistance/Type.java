package com.stage.pfe.persistance;

public class Type {
	private Integer idType;
	private String nomType;
	
	
	public Type() {
		super();
	}
	public Type(Integer idType, String nomType) {
		super();
		this.idType = idType;
		this.nomType = nomType;
	}
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	public String getNomType() {
		return nomType;
	}
	public void setNomType(String nomType) {
		this.nomType = nomType;
	}
	@Override
	public String toString() {
		return "Type [idType=" + idType + ", nomType=" + nomType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((nomType == null) ? 0 : nomType.hashCode());
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
		Type other = (Type) obj;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (nomType == null) {
			if (other.nomType != null)
				return false;
		} else if (!nomType.equals(other.nomType))
			return false;
		return true;
	}
	
	

}
