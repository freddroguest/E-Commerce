package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByName(String lastName);
    
    List<Contact> findAll();
    

}
