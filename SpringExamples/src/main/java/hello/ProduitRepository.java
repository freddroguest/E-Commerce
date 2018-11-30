package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProduitRepository extends CrudRepository<Produit, Long> {
    
    List<Produit> findAll();

}