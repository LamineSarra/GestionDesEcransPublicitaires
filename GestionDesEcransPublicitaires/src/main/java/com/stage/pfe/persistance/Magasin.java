package com.stage.pfe.persistance;

public class Magasin {
	private Integer idMagasin;
	private String nomMagasin;
	private String adresseMagasin;
	private String codeMagasin;
	
	
	public Magasin() {
		super();
	}
	public Magasin(Integer idMagasin, String nomMagasin, String adresseMagasin,
			String codeMagasin) {
		super();
		this.idMagasin = idMagasin;
		this.nomMagasin = nomMagasin;
		this.adresseMagasin = adresseMagasin;
		this.codeMagasin = codeMagasin;
	}
	public Integer getIdMagasin() {
		return idMagasin;
	}
	public void setIdMagasin(Integer idMagasin) {
		this.idMagasin = idMagasin;
	}
	public String getNomMagasin() {
		return nomMagasin;
	}
	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
	}
	public String getAdresseMagasin() {
		return adresseMagasin;
	}
	public void setAdresseMagasin(String adresseMagasin) {
		this.adresseMagasin = adresseMagasin;
	}
	public String getCodeMagasin() {
		return codeMagasin;
	}
	public void setCodeMagasin(String codeMagasin) {
		this.codeMagasin = codeMagasin;
	}
	@Override
	public String toString() {
		return "Magasin [idMagasin=" + idMagasin + ", nomMagasin=" + nomMagasin
				+ ", adresseMagasin=" + adresseMagasin + ", codeMagasin="
				+ codeMagasin + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adresseMagasin == null) ? 0 : adresseMagasin.hashCode());
		result = prime * result
				+ ((codeMagasin == null) ? 0 : codeMagasin.hashCode());
		result = prime * result
				+ ((idMagasin == null) ? 0 : idMagasin.hashCode());
		result = prime * result
				+ ((nomMagasin == null) ? 0 : nomMagasin.hashCode());
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
		Magasin other = (Magasin) obj;
		if (adresseMagasin == null) {
			if (other.adresseMagasin != null)
				return false;
		} else if (!adresseMagasin.equals(other.adresseMagasin))
			return false;
		if (codeMagasin == null) {
			if (other.codeMagasin != null)
				return false;
		} else if (!codeMagasin.equals(other.codeMagasin))
			return false;
		if (idMagasin == null) {
			if (other.idMagasin != null)
				return false;
		} else if (!idMagasin.equals(other.idMagasin))
			return false;
		if (nomMagasin == null) {
			if (other.nomMagasin != null)
				return false;
		} else if (!nomMagasin.equals(other.nomMagasin))
			return false;
		return true;
	}
	
	
}
