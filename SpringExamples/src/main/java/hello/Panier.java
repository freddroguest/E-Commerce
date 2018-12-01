package hello;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Client client;
	private List<Produit> lstProduit;
	
	protected Panier(){}
	
	public Panier(Client client,Produit produit)
	{
		this.client=client;
		lstProduit.add(produit);
	}
	
	public Client getClient()
	{
		return this.client;
	}
	
	public void setClient(Client client)
	{
		this.client=client;
	}
	
	public List<Produit> getLstProduit()
	{
		return this.lstProduit;
	}
	
	public void setLstProduit(Produit produit)
	{
		this.lstProduit.add(produit);
	}
}
