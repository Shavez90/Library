package org.spring.library.service;

import lombok.RequiredArgsConstructor;
import org.spring.library.dto.AuthorDTO;
import org.spring.library.dto.CreatDTO;
import org.spring.library.model.Author;
import org.spring.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
     public  final AuthorRepository authorRepository;
public AuthorDTO register(CreatDTO create){
     if(authorRepository.existsByEmail(create.getEmail())){
        throw new RuntimeException("HOHO AUTHOR IS IN EXISTENCE");
    }
    Author author = new Author();
    author.setEmail(create.getEmail());
    author.setName(create.getName());
    author.setPassword(create.getPassword());

    Author saved = authorRepository.save(author);
    AuthorDTO authorDTO = new AuthorDTO(saved.getId(), saved.email,saved.getName());
return authorDTO;
}
 public AuthorDTO getAuthorBYEmail(String email){
    Author author = authorRepository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Author not Found"));

    return mapToDto(author);
 }
    private AuthorDTO mapToDto(Author author) {
        return AuthorDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .build();
    }



}
