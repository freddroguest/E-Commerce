package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

    @NotNull
    @Size(min=2, max=30)
    private String name;
    
    @NotNull
    @Size(min=2, max=30)
    private String prenom;
    
    @NotNull
    private String email;
    
    @NotNull
    private Integer numero;

    @NotNull
    @Min(18)
    private Integer age;
    
  //SimpleFormController
    protected ArrayList referenceData(HttpServletRequest request) throws Exception {
    	ArrayList couleur = new ArrayList();
    	couleur.add("Rouge");
    	couleur.add("Vert");
    	couleur.add("Jaune");
    	return couleur;
    }
    
    public Integer getNumero()
    {
    	return this.numero;
    }
    
    public void setNumero(Integer numero)
    {
    	this.numero=numero;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPrenom(String prenom) {
    	this.prenom=prenom;
    }
    
    public String getPrenom()
    {
    	return prenom;
    }
    
    public void setEmail(String email) {
    	this.email=email;
    }
    
    public String getEmail()
    {
    	return email;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}