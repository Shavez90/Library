package org.spring.library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    public   String title;

    public String  authorid;
    public String id;
}
