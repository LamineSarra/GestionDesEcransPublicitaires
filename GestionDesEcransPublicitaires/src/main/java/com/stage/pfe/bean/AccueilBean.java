package com.stage.pfe.bean;
 
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean; 
@ManagedBean
public class AccueilBean {
     
  
     
    @PostConstruct
    public List<String> init() {
    	List<String> images = new ArrayList<String>();
        for (int i = 1; i <= 1; i++) {
            images.add("ecran" + i + ".jpg");
      
        }
        return images;
    }
 
}