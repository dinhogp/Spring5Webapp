package code.riddler.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import code.riddler.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}