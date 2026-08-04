package com.example.LogiTrack.DTO;

import com.example.LogiTrack.Enums.Roles;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import javax.management.relation.Role;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthRequest {
    @NotNull(message = "Username is mandatory")
    private String userName;
    @NotNull(message = "Email is mandatory")
    @Email
    private String email;
    @NotNull(message = "Role is mandatory")
    private Roles role;
    @NotNull(message = "Password is mandatory")
    private String password;


    private String nom;
    private String tel;


}
