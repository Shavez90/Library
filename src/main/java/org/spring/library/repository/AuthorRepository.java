package org.spring.library.repository;

import org.spring.library.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorRepository  extends MongoRepository<Author,String> {


    boolean existsByEmail(String email);

    Optional<Author> findByEmail(String email);
}
