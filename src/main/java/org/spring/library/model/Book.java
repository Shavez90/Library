package org.spring.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data

@NoArgsConstructor
public class Book {
     public   String title;
@Id
       public String  authorId;
       public String id;


}
