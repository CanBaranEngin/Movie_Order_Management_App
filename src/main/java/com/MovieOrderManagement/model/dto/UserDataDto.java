package com.MovieOrderManagement.model.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDataDto {
    @Size(min = 5, max = 15)
    private String userName;
    @NotBlank
    @Email(message = "Email not valid")
    private String email;
    @Size(min = 5, max = 20)
    private String password;

}

