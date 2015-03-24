package com.stage.pfe.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.stage.pfe.persistance.Magasin;
import com.stage.pfe.service.MagasinService;


@ManagedBean(name = "magasinBean")
public class MagasinBean {
	private Integer idMagasin;
	private String nomMagasin;
	private String adresseMagasin;
	private String codeMagasin;
	private List<Magasin> listMagasins;
	
	
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
	public List<Magasin> getListMagasins() {
		MagasinService ser=new MagasinService();
		listMagasins=ser.rechercheTousMagasin();
		return listMagasins;
	}
	public void setListMagasins(List<Magasin> listMagasins) {
		this.listMagasins = listMagasins;
	}
	
	public String ajouter()
	{
		FacesContext faces = FacesContext.getCurrentInstance();
		boolean verif = true;
		
		if((nomMagasin == null) || (nomMagasin.trim().length()== 0))
		{faces.addMessage("formgestionid:nomid", new FacesMessage("Veuillez saisir le nom du magasin!"));
		verif =false;}
		if((adresseMagasin == null) || (adresseMagasin.trim().length()== 0))
		{faces.addMessage("formgestionid:adresseid", new FacesMessage("Veuillez saisir l'adresse du magasin!"));
		verif =false;}
		if((codeMagasin == null) || (codeMagasin.trim().length()== 0))
		{faces.addMessage("formgestionid:codeid", new FacesMessage("Veuillez saisir le code du magasin!"));
		verif =false;}
		
		if (!verifMag())
			verif = false;
		
		if(verif)
		{
			Magasin mag=new Magasin();
			mag.setNomMagasin(nomMagasin);
			mag.setAdresseMagasin(adresseMagasin);
			mag.setCodeMagasin(codeMagasin);
			
			MagasinService ser=new MagasinService();
			ser.ajouterMagasin(mag);
			reset();
			return "ajoute";
		}
		return null;
	}
	
		public boolean verifMag()
		{
			FacesContext faces = FacesContext.getCurrentInstance();
			MagasinService ser = new MagasinService();
			Magasin mag = ser.RechercheParNom(nomMagasin);
			if (mag != null) {
				faces.addMessage("formgestionid:loginid", new FacesMessage(
						"Ce magasin existe déjà. "));
				return false;
			}
			else
				return true;
		}
		public void reset()
		{
			nomMagasin="";
			adresseMagasin="";
			codeMagasin="";
		}
		
		public void modifier(Magasin mag)
		{
			reset();
			idMagasin=mag.getIdMagasin();
			nomMagasin=mag.getNomMagasin();
			adresseMagasin=mag.getAdresseMagasin();
			codeMagasin=mag.getCodeMagasin();
		}
	
	public void modification()
	{
		Magasin mag=new Magasin();
		mag.setNomMagasin(nomMagasin);
		mag.setAdresseMagasin(adresseMagasin);
		mag.setCodeMagasin(codeMagasin);
		
		MagasinService ser=new MagasinService();
		ser.modifierMagasin(mag);
		reset();
		
	}
	
	public void supprimer(Integer id)
	{
		MagasinService ser= new MagasinService();
		ser.suprimerMagasin(id);
		addMessage("supprimé!!!");
		
	}
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
}
	

}
