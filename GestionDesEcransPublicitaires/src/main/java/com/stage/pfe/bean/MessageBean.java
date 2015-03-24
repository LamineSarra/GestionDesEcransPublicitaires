package com.stage.pfe.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.stage.pfe.persistance.Categorie;
import com.stage.pfe.persistance.Ecran;
import com.stage.pfe.persistance.Message;
import com.stage.pfe.service.CategorieService;
import com.stage.pfe.service.EcranService;
import com.stage.pfe.service.MessageService;


@ManagedBean(name = "messageBean")
public class MessageBean {
	private Integer idMsg;
	private String nomMessage;
	private String url;
	private String nomCategorie;
	private Integer idCategorie;
	private String adresseIP;
	
	
	public Integer getIdMsg() {
		return idMsg;
	}
	public void setIdMsg(Integer idMsg) {
		this.idMsg = idMsg;
	}
	public String getNomMessage() {
		return nomMessage;
	}
	public void setNomMessage(String nomMessage) {
		this.nomMessage = nomMessage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
		


	public Integer getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}


	public String getAdresseIP() {
		return adresseIP;
	}
	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}




	private List<Message> listMessages;
		public List<Message> getListMessages() {
		MessageService ser=new MessageService();
		listMessages=ser.rechercheTousMessage();
		return listMessages;
	}
	public void setListMessages(List<Message> listMessages) {
		this.listMessages = listMessages;
	}
	private List<Categorie> listCategories;
	public List<Categorie> getListCategories() {
	CategorieService serc=new CategorieService();
	listCategories=serc.rechercheTousCategorie();
	return listCategories;
}
	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}
	private List<Ecran> listEcrans;
	public List<Ecran> getListEcrans() {
	EcranService serc=new EcranService();
	listEcrans=serc.rechercheTousEcran();
	return listEcrans;
	}
	public void setListEcrans(List<Ecran> listEcrans) {
		this.listEcrans = listEcrans;
	}
	
	public String ajouter()
	{
		FacesContext faces = FacesContext.getCurrentInstance();
		boolean verif = true;
		
		if((nomMessage == null) || (nomMessage.trim().length()== 0))
		{faces.addMessage("formgestionid:nomid", new FacesMessage("Veuillez saisir le nom du message!"));
		verif =false;}
		if((url == null) || (url.trim().length()== 0))
		{faces.addMessage("formgestionid:adresseid", new FacesMessage("Veuillez saisir l'url du message!"));
		verif =false;}
		if((nomCategorie == null) || (nomCategorie.trim().length()== 0))
		{faces.addMessage("formgestionid:adresseid", new FacesMessage("Veuillez saisir la categorie du message!"));
		verif =false;}


		
		if(verif)
		{
			Message msg=new Message();
			msg.setNomMessage(nomMessage);
			msg.setUrl(url);
			Categorie cat=new Categorie();
			cat.setNomCategorie(nomCategorie);
			MessageService ser=new MessageService();
			ser.ajouterMessage(msg);
			CategorieService serc=new CategorieService();
			serc.ajouterCategorie(cat);
			Ecran e=new Ecran();
			e.setAdresseIP(adresseIP);
			EcranService sere=new EcranService();
			sere.ajouterEcran(e);
			reset();
			return "ajoute";
		}
		return null;
	}
	
		public void reset()
		{
			nomMessage="";
			url="";
		}
		
		public void modifier(Message msg)
		{
			reset();
			idMsg=msg.getIdMsg();
			nomMessage=msg.getNomMessage();
			url=msg.getUrl();		}
	
	public void modification()
	{
		Message msg=new Message();
		msg.setNomMessage(nomMessage);
		msg.setUrl(url);
		
		MessageService ser=new MessageService();
		ser.modifierMessage(msg);
		reset();
		
	}
	
	public void supprimer(Integer id,Integer idCategorie)
	{
		MessageService ser= new MessageService();
		ser.suprimerMessage(id);
		CategorieService serc=new CategorieService();
		serc.suprimerCategorie(idCategorie);
		addMessage("supprimé!!!");
		
	}
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
}
	

}
