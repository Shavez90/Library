package org.spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.spring.library.dto.AuthorDTO;
import org.spring.library.dto.CreatDTO;
import org.spring.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    public  final AuthorService authorService;
    @PostMapping("/register")
     public AuthorDTO createUser(@RequestBody CreatDTO create){
         return authorService.register(create);
     }
     @GetMapping("/me")
      public  AuthorDTO getAuthor( String email){
        return authorService.getAuthorBYEmail(email);
      }
}
