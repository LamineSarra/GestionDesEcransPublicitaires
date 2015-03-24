package com.stage.pfe.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.stage.pfe.persistance.Contrat;
import com.stage.pfe.persistance.Jour;
import com.stage.pfe.persistance.Heure;
import com.stage.pfe.service.ContratService;
import com.stage.pfe.service.HeureService;
import com.stage.pfe.service.JourService;
@ManagedBean(name = "contratBean")
public class ContratBean {
	private Integer idContrat;
	private Integer numJour;
	private Integer heure;
	public Integer getIdContrat() {
		return idContrat;
	}
	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}
	public Integer getNumJour() {
		return numJour;
	}
	public void setNumJour(Integer numJour) {
		this.numJour = numJour;
	}
	public Integer getHeure() {
		return heure;
	}
	public void setHeure(Integer heure) {
		this.heure = heure;
	}
	
	private List<Contrat> listContrats;
	private List<Jour> listJours;
	private List<Heure> listHeures;
	public List<Contrat> getListContrats() {
		ContratService ser=new ContratService();
		listContrats=ser.rechercheTousContrat();
		return listContrats;
	}
	public void setListContrats(List<Contrat> listContrats) {
		this.listContrats = listContrats;
	}
	public List<Jour> getListJours() {
		JourService ser=new JourService();
		listJours=ser.rechercheTousJour();
		return listJours;
	}
	public void setListJours(List<Jour> listJours) {
		this.listJours = listJours;
	}
	public List<Heure> getListHeures() {
		HeureService ser=new HeureService();
		listHeures=ser.rechercheTousHeure();
		return listHeures;
	}
	public void setListHeures(List<Heure> listHeures) {
		this.listHeures = listHeures;
	}
	
	
	public String ajouter()
	{
		FacesContext faces = FacesContext.getCurrentInstance();
		boolean verif = true;
		
		if((numJour == null) )
		{faces.addMessage("formgestionid:jourid", new FacesMessage("Veuillez saisir le jour!"));
		verif =false;}
		if((heure == null))
		{faces.addMessage("formgestionid:heureid", new FacesMessage("Veuillez saisir l'heure!"));
		verif =false;}
		
		if(verif)
		{
			Contrat con=new Contrat();
			Jour jr=new Jour();
			jr.setNumJour(numJour);
			ContratService ser=new ContratService();
			ser.ajouterContrat(con);
			JourService serj=new JourService();
			serj.ajouterJour(jr);;
			Heure h=new Heure();
			h.setHeure(heure);
			HeureService serh=new HeureService();
			serh.ajouterHeure(h);
			reset();
			return "ajoute";
		}
		return null;
	}
	
	public void reset()
	{
		numJour=null;
		heure=null;
	}

	public void modifier(Contrat con)
	{
		reset();
		idContrat=con.getIdContrat();
	}
	public void supprimer(Integer id,Integer idj,Integer idh)
	{
		ContratService ser= new ContratService();
		ser.suprimerContrat(id);
		JourService serj=new JourService();
		serj.suprimerJour(idj);
		HeureService serh=new HeureService();
		serh.suprimerHeure(idh);
		addMessage("supprimé!!!");
		
	}
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
}

}
