package com.stage.pfe.bean;
 
import java.io.Serializable;
 
public class User implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nom;
     
    private String prenom;
     
    private Integer cin;
    
    private String raisonSocial;

	private String rue;
	
	private String ville;
     
    private String email;
     
    private Integer tel;
    
   private Integer tel2;
 
    public String getnom() {
        return nom;
    }
 
    public void setnom(String nom) {
        this.nom = nom;
    }
 
    public String getprenom() {
        return prenom;
    }
 
    public void setprenom(String prenom) {
        this.prenom = prenom;
    }
 
    public Integer getcin() {
        return cin;
    }
 
    public void setcin(Integer cin) {
        this.cin = cin;
    }
 
    public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	
    public String getrue() {
        return rue;
    }
 
    public void setrue(String rue) {
        this.rue = rue;
    }
    
    public String getville() {
        return ville;
    }
 
    public void setville(String ville) {
        this.ville = ville;
    }
 
     
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public Integer getTel() {
        return tel;
    }
 
    public void setTel(Integer tel) {
        this.tel = tel;
    }
    public Integer getTel2() {
        return tel2;
    }
 
    public void setTel2(Integer tel2) {
        this.tel2 = tel2;
    }
    
    
}