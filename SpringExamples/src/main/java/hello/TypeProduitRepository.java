package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TypeProduitRepository extends CrudRepository<Type_produit, Long> {
    
    List<Type_produit> findAll();

}