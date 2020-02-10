package code.riddler.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import code.riddler.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}