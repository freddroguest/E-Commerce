package hello;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type_produit {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private String libelle;
	 
	 protected Type_produit() {}
	 
	 public Type_produit(String libelle)
	 {
		 this.libelle = libelle;
	 }
	 
	 public Long getId() {
			return id;
		}

	 public void setId(Long id) {
			this.id = id;
		}
	 public String getLibelle() {
			return libelle;
		}

	 public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

}
