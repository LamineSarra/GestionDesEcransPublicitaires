package com.stage.pfe.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.stage.pfe.persistance.Client;
import com.stage.pfe.service.ClientService;




@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean{
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

private String rue;
	

		public String getRue() {
	return rue;
}

public void setRue(String rue) {
	this.rue = rue;
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

		private List<Client> listClientsv;
		private List<Client> listClientsinv;
	


	public List<Client> getListClientsv() {
		ClientService ser = new ClientService();
		listClientsv=ser.rechercheClientValides();
		return listClientsv;
	}

	public void setListClientsv(List<Client> listClientsv) {
		this.listClientsv = listClientsv;
	}

	public List<Client> getListClientsinv() {
		ClientService ser = new ClientService();
		listClientsinv=ser.rechercheClientsInvalides();
		return listClientsinv;
	}

	public void setListClientsinv(List<Client> listClientsinv) {
		this.listClientsinv = listClientsinv;
	}

	public String ajouter() {
	
		boolean verif = true;
		// test sur le cin 8 chiffres
		System.out.println(cin);
		if (!verifCin())
			verif = false;

		if (verif) {
			// Création d'un utilisateur selon les champs saisis
			Client u = new Client();
			u.setCin(cin);
			u.setNom(nom);
			u.setPrenom(prenom);
			u.setVille(ville);
			u.setAdresse(adresse);
			u.setEmail(email);
			u.setTel(tel);
			u.setTel2(tel2);
			u.setFax(fax);
			u.setRaisonSocial(raisonSocial);

			ClientService ser = new ClientService();
			ser.ajouterClient(u);
			FacesMessage msg = new FacesMessage("Succé", "Bienvenue :" + u.getPrenom());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			reset();
			return "ajoute";
			
			
		}
		return null;

	}


	private boolean verifCin() {// à tester qu'il n'existe pas avant
		FacesContext faces = FacesContext.getCurrentInstance();
		if (cin == null || cin.trim().length() != 8) {
			faces.addMessage("formgestionid:cinid", new FacesMessage(
					"Le N°cin doit etre 8 chiffres!"));

			return false;
		} else {
			try {
				Integer.parseInt(cin);
			} catch (NumberFormatException e) {
				faces.addMessage("formgestionid:cinid", new FacesMessage(
						"Le N°CIN doit etre 8 chiffres!"));
				return false;
			}

		}
		return true;
	}

	public void ajout() {
		reset();
		
	}
	
	
	public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void supprimer(Integer id) {
		ClientService ser = new ClientService();
		ser.suprimerClient(id);
		addMessage("supprimé!!!");

	}


	// mettre lesdonnées de l'utilisateur sélectionné dans le formulaire
	public void modifier(Client u) {
		
		reset();

		idClient = u.getIdClient();
		u.setCin(cin);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setVille(ville);
		u.setAdresse(adresse);
		u.setEmail(email);
		u.setTel(tel);
		u.setTel2(tel2);
		u.setFax(fax);
		u.setRaisonSocial(raisonSocial);
		
	}

	
	// Valider les modifications
	public void modification() {

		// il faut vérifier la contrainte de l'unicité apès le changement
		Client u = new Client();
		u.setIdClient(idClient);
		u.setCin(cin);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setVille(ville);
		u.setAdresse(adresse);
		u.setEmail(email);
		u.setTel(tel);
		u.setTel2(tel2);
		u.setFax(fax);
		u.setRaisonSocial(raisonSocial);
		ClientService ser = new ClientService();
		ser.modifierClient(u);
		
		reset();
		
	}

	private void reset() {
		cin = "";
		nom = "";
		prenom = "";
		adresse = "";
		email = "";
		tel = "";
	

	}

	

}
