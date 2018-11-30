package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long idType_produit;
	private String designation;
	private double prix;
	private String commentaire;
	private double hauteur;
	private double largeur;
	private double profondeur;
	private String libCouleur;

	protected Produit() {
	}

	public Produit(String designation, Long idType_produit, String commentaire, double prix, double hauteur,
			double largeur, double profondeur, String lib_couleur) {
		this.designation = designation;
		this.idType_produit = idType_produit;
		this.commentaire = commentaire;
		this.prix = prix;
		this.hauteur = hauteur;
		this.profondeur = profondeur;
		this.largeur = largeur;
		this.libCouleur = lib_couleur;
	}

	public Long getIdType_produit() {
		return idType_produit;
	}

	public void setIdType_produit(Long idType_produit) {
		this.idType_produit= idType_produit;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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

}
