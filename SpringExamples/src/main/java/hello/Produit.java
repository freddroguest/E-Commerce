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
	private Long couleur;
	private String libCouleur;
	private String libtype;

	protected Produit() {
	}

	public Produit(String designation, Long idType_produit, String commentaire, double prix, double hauteur,
			double largeur, double profondeur, String lib_couleur, String libtype) {
		this.designation = designation;
		this.idType_produit = idType_produit;
		this.commentaire = commentaire;
		this.prix = prix;
		this.hauteur = hauteur;
		this.profondeur = profondeur;
		this.largeur = largeur;
		this.libCouleur = lib_couleur;
		this.libtype = libtype;
	}
	
	public Produit(Produit produit) {
		this.designation = produit.designation;
		this.idType_produit = produit.idType_produit;
		this.commentaire = produit.commentaire;
		this.prix = produit.prix;
		this.hauteur = produit.hauteur;
		this.profondeur = produit.profondeur;
		this.largeur = produit.largeur;
		this.libCouleur = produit.libCouleur;
		this.libtype = produit.libtype;
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
	
	public String getLibType() {
		return libtype;
	}

	public void setLibtype(String libType) {
		this.libtype = libType;
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
	
	public Long getCouleur() {
		return couleur;
	}

	public void setCouleur(Long couleur) {
		this.couleur = couleur;
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
