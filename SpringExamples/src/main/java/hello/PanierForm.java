package hello;

import java.util.List;

import javax.validation.constraints.NotNull;

public class PanierForm {
	@NotNull
	private Client client;
	private List<Produit> lstProduit;
	
	 public Client getClient() {
			return this.client;
		}

	 public void setClient(Client client) {
			this.client = client;
		}
	 
	 public List<Produit> getLstProduit() {
			return this.lstProduit;
		}

	 public void setClient(List<Produit> lstProduit) {
			this.lstProduit = lstProduit;
		}
	
	 public String toString() {
	        return "Panier(client : " + this.client+ ")";
	    }
}

