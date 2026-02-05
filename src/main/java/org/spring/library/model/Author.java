package org.spring.library.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "authors")
public class Author {
    @Id
    public String id;
    public String name;
    public String email;
    public String password;
}
