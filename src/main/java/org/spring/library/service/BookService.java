package org.spring.library.service;

import lombok.RequiredArgsConstructor;
import org.spring.library.dto.AuthorDTO;
import org.spring.library.dto.BookDTO;
import org.spring.library.dto.CreateJDTO;
import org.spring.library.model.Author;
import org.spring.library.model.Book;
import org.spring.library.repository.AuthorRepository;
import org.spring.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {
     public  final BookRepository bookRepository;
     public  final AuthorRepository authorRepository;

public BookDTO createBook(String email, CreateJDTO createJDTO){
    Author author1 = authorRepository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Author  dont exist"));

    Book book1 = new Book();
    book1.setAuthorId(author1.getId());
    book1.setTitle(createJDTO.getTitle());

    Book savedBook = bookRepository.save(book1);

    return mapToDto(savedBook);

    }
    public List<BookDTO> getBooksByAuthorId(String authorId) {

        List<Book> books = bookRepository.findByAuthorId(authorId);

        return books.stream()
                .map(this::mapToDto)
                .toList();
    }

    // DTO MAPPER
    private BookDTO mapToDto(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorid(book.getAuthorId())
                .build();
    }
}



