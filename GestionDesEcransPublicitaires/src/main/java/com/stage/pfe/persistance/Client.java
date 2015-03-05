package com.stage.pfe.persistance;



//Generated 11 avr. 2014 14:25:46 by Hibernate Tools 3.4.0.CR1


public class Client implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String tel;
	private String tel2;
	private String raisonSocial;
	private String fax;
	private String cin;
	private boolean validite;
	private String ville;
	
	public Client() {
		super();
	}

	public Client(Integer idClient, String nom, String prenom, String adresse,
			String email, String tel, String tel2, String raisonSocial,
			String fax, String cin, boolean validite, String ville) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.tel2 = tel2;
		this.raisonSocial = raisonSocial;
		this.fax = fax;
		this.cin = cin;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + ", tel2=" + tel2 + ", raisonSocial="
				+ raisonSocial + ", fax=" + fax + ", cin=" + cin
				+ ", validite=" + validite + ", ville=" + ville + "]";
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}


	public boolean isValidite() {
		return validite;
	}

	public void setValidite(boolean validite) {
		this.validite = validite;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((idClient == null) ? 0 : idClient.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result
				+ ((raisonSocial == null) ? 0 : raisonSocial.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((tel2 == null) ? 0 : tel2.hashCode());
		result = prime * result + (validite ? 1231 : 1237);
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Client other = (Client) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (raisonSocial == null) {
			if (other.raisonSocial != null)
				return false;
		} else if (!raisonSocial.equals(other.raisonSocial))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (tel2 == null) {
			if (other.tel2 != null)
				return false;
		} else if (!tel2.equals(other.tel2))
			return false;
		if (validite != other.validite)
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	
}