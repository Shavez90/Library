package org.spring.library.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class LoginResponse {
    public   final String  token;
    public final String email;
}
