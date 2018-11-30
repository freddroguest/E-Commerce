package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CouleurRepository extends CrudRepository<Couleur, Long> {
    
    List<Couleur> findAll();
    

}