package org.spring.library.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateJDTO {

    @NotBlank
    private String authorid;

    @NotBlank

    private String title;

    @NotBlank
    private String id;
}
