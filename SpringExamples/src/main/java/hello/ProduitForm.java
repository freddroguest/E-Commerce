package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProduitForm {
	
	 	@NotNull
		private Long idType_produit;
	 	@NotNull
	 	@Size(min=5, max = 250)
		private String designation;
		private double prix;
		private String commentaire;
		private double hauteur;
		private double largeur;
		private double profondeur;
		private String libCouleur;
		
		public String getLibCouleur() {
			return libCouleur;
		}

		public void setLibCouleur(String libCouleur) {
			this.libCouleur = libCouleur;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getCommentaire() {
			return commentaire;
		}
		
		public void setCommentaire(String commentaire)
		{
			this.commentaire=commentaire;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public double getHauteur() {
			return hauteur;
		}

		public void setHauteur(double hauteur) {
			this.hauteur = hauteur;
		}

		public double getProfondeur() {
			return profondeur;
		}

		public void setProfondeur(double profondeur) {
			this.profondeur = profondeur;
		}

		public double getLargeur() {
			return largeur;
		}

		public void setLargeur(double largeur) {
			this.largeur = largeur;
		}
		
		public String toString() {
	        return "Produit(Designation: " + this.designation+ ", Prix: " + this.prix+ ")";
	    }
}
