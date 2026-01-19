package org.spring.library.service;

import lombok.RequiredArgsConstructor;
import org.spring.library.model.Author;
import org.spring.library.repository.AuthorRepository;
import org.spring.library.security.JwtService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthorRepository authorRepository;
    private final JwtService jwtService;

    public String login(String email, String password) {

        Author author = authorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!author.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(author.getEmail(), author.getId());
    }
}
