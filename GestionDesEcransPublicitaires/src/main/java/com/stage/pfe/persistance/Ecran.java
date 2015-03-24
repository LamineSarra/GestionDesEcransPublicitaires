package com.stage.pfe.persistance;

public class Ecran {
	private Integer idEcran;
	private String adresseIP;
	
	
	public Ecran() {
		super();
	}
	public Ecran(Integer idEcran, String adresseIP) {
		super();
		this.idEcran = idEcran;
		this.adresseIP = adresseIP;
	}
	public Integer getIdEcran() {
		return idEcran;
	}
	public void setIdEcran(Integer idEcran) {
		this.idEcran = idEcran;
	}
	public String getAdresseIP() {
		return adresseIP;
	}
	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}
	@Override
	public String toString() {
		return "Ecran [idEcran=" + idEcran + ", adresseIP=" + adresseIP + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adresseIP == null) ? 0 : adresseIP.hashCode());
		result = prime * result + ((idEcran == null) ? 0 : idEcran.hashCode());
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
		Ecran other = (Ecran) obj;
		if (adresseIP == null) {
			if (other.adresseIP != null)
				return false;
		} else if (!adresseIP.equals(other.adresseIP))
			return false;
		if (idEcran == null) {
			if (other.idEcran != null)
				return false;
		} else if (!idEcran.equals(other.idEcran))
			return false;
		return true;
	}
	
	
}
