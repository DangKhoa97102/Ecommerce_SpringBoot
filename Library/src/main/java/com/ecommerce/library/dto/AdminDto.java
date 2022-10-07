package com.ecommerce.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor

public class AdminDto {

    @Size(min = 3, max = 10, message = "Invalid first name! (must between 3-10 characters)")
    private String firstName;

    @Size(min = 3, max = 10, message = "Invalid last name! (must between 3-10 characters)")
    private String lastName;

    private String username;

    @Size(min = 5, max = 15, message = "Invalid password! (must between 5-15 characters)")
    private String password;

    private String repeatPassword;
}
