package com.stage.pfe.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.stage.pfe.persistance.Utilisateur;
import com.stage.pfe.service.UtilisateurService;



@ManagedBean(name = "utilisateurBean")
@SessionScoped
public class UtilisateurBean{
	private Integer idutilisateur;
	private String cin;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String email;
	private String tel;
	private String adresse;
	private String type;

	

		private List<Utilisateur> listUtilisateurs;

	public Integer getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(Integer idUtilisateur) {
		this.idutilisateur = idUtilisateur;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public List<Utilisateur> getListUtilisateurs() {
		UtilisateurService ser = new UtilisateurService();
		listUtilisateurs=ser.rechercheTousUtilisateur();
		return listUtilisateurs;
	}

	public void setListUtilisateurs(List<Utilisateur> listUtilisateurs) {
		this.listUtilisateurs = listUtilisateurs;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String ajouter() {
		FacesContext faces = FacesContext.getCurrentInstance();
		boolean verif = true;
		// test sur le cin 8 chiffres
		if (!verifCin())
			verif = false;
		if (!verifLogin())
			verif = false;
		
		if((mdp == null) || (mdp.trim().length()== 0))
			{faces.addMessage("formgestionid:motpid", new FacesMessage("Veuillez donnez un mot de passe."));
			verif =false;}

		if (verif) {
			// Création d'un utilisateur selon les champs saisis
			Utilisateur u = new Utilisateur();
			u.setCin(cin);
			u.setNom(nom);
			u.setPrenom(prenom);
			u.setLogin(login);
			u.setMdp(mdp);
			u.setAdresse(adresse);
			u.setEmail(email);
			u.setTel(tel);
			u.setType(type);

			UtilisateurService ser = new UtilisateurService();
			ser.ajouterUtilisateur(u);
			
			reset();
			return "ajoute";
			
		}
		return null;

	}

	private boolean verifLogin() {
		FacesContext faces = FacesContext.getCurrentInstance();
		// c'est un champs obligatoire unique
		if (login == null || login.trim().length() == 0) {
			faces.addMessage("formgestionid:loginid", new FacesMessage(
					"Veuillez donner un identificateur"));
			return false;
		} else { // chercher si ce login existe déja
			UtilisateurService ser = new UtilisateurService();
			Utilisateur user = ser.RechercheParLogin(login);
			if (user != null) {
				faces.addMessage("formgestionid:loginid", new FacesMessage(
						"Cet identificateur existe déjà. "));
				return false;// login existe d�ja
			}
		}

		return true;
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
		UtilisateurService ser = new UtilisateurService();
		ser.suprimerUtilisateur(id);
		addMessage("supprimé!!!");

	}


	// mettre lesdonnées de l'utilisateur sélectionné dans le formulaire
	public void modifier(Utilisateur u) {
		
		reset();

		idutilisateur = u.getIdutilisateur();
		nom = u.getNom();
		adresse = u.getAdresse();
		cin = u.getCin();
		login = u.getLogin();
		email = u.getEmail();
		mdp = u.getMdp();
		prenom = u.getPrenom();
		tel = u.getTel();
		type = u.getType();
		
	}

	
	// Valider les modifications
	public void modification() {

		// il faut vérifier la contrainte de l'unicité apès le changement
		Utilisateur u = new Utilisateur();
		u.setIdutilisateur(idutilisateur);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setLogin(login);
		u.setMdp(mdp);
		u.setCin(cin);
		u.setEmail(email);
		u.setTel(tel);
		u.setAdresse(adresse);
		u.setType(type);
		UtilisateurService ser = new UtilisateurService();
		ser.modifierUtilisateur(u);
		
		reset();
		
	}

	private void reset() {
		cin = "";
		nom = "";
		prenom = "";
		adresse = "";
		email = "";
		tel = "";
		login = "";
		mdp = "";

	}

	

}
