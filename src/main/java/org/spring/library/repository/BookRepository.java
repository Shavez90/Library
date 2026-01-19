package org.spring.library.repository;

import org.spring.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    List<Book> findByAuthorId(String authorId);
}
