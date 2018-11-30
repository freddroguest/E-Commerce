package hello;

import javax.validation.constraints.NotNull;

public class CouleurForm {
	@NotNull
	private String libelle;
	
	 public String getLibelle() {
			return libelle;
		}

	 public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
	
	 public String toString() {
	        return "Couleur(Libelle : " + this.libelle+ ")";
	    }
}
