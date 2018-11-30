package hello;

import javax.validation.constraints.NotNull;

public class TypeProduitForm {
	@NotNull
	private String libelle;
	
	public String getLibelle() {
		return libelle;
	}

 public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

 public String toString() {
        return "Type produit(Libelle : " + this.libelle+ ")";
    }
}
