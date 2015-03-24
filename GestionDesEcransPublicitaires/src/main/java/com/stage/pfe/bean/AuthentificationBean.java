package com.stage.pfe.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.stage.pfe.persistance.Utilisateur;
import com.stage.pfe.service.UtilisateurService;

 
@ManagedBean(name = "authentificationBean")
@SessionScoped
public class AuthentificationBean {
	private String login;
	private String mdp;
	private List<Utilisateur> l;
	
	
	


	public List<Utilisateur> getL() {
		UtilisateurService ser=new UtilisateurService();
		l=ser.RechercheParLoginMP(login, mdp);
		return l;
	}

	public void setL(List<Utilisateur> l) {
		this.l = l;
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
    public String connecter()
    {FacesContext faces = FacesContext.getCurrentInstance() ;
    if ((login.isEmpty() || login == null)&&(mdp.isEmpty() || mdp == null))
    {
    	faces.addMessage("authen:loginid", new FacesMessage("Erreur","Vous devez saisir l'identificateur et le mot de passe!!!")) ;
    	return("rejete");
    }
    	else if(login.isEmpty() || login == null) 
    {
		faces.addMessage("authen:loginid", new FacesMessage("Erreur","Vous devez saisir l'identificateur!!!")) ;
			
    }
    	else if (mdp.isEmpty() || mdp == null) {
			faces.addMessage("authen:mdpid", new FacesMessage("Erreur","Vous devez saisir le mot de passe!!!")) ;
			
		}
	
		if ((login.isEmpty() || login == null)||(mdp.isEmpty() || mdp == null))
			return "rejete";	
    	
		// si non vérification des données
    else
    {
		List<Utilisateur> l;
		l=getL();
			if (l.size()>0)
				return "accepte";
			else
			{faces.addMessage("authen:erreurid", new FacesMessage("Erreur","identificateur ou mot de passe incorrect")) ;
				return "rejecte";
			}
    }
		}
	public void reset() {

		login = "";
		mdp = "";

	}
    
}