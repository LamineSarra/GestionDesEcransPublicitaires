package com.stage.pfe.persistance;

public class Contrat {
	private Integer idContrat;
	
	

	public Contrat() {
		super();
	}

	public Contrat(Integer idContrat) {
		super();
		this.idContrat = idContrat;
	}

	public Integer getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	@Override
	public String toString() {
		return "Contrat [idContrat=" + idContrat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idContrat == null) ? 0 : idContrat.hashCode());
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
		Contrat other = (Contrat) obj;
		if (idContrat == null) {
			if (other.idContrat != null)
				return false;
		} else if (!idContrat.equals(other.idContrat))
			return false;
		return true;
	}
	
}
