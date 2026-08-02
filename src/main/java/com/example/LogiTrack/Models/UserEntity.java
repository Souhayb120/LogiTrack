package com.example.LogiTrack.Models;

import com.example.LogiTrack.Enums.Roles;
import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private String userName;
    private Roles role;
    private String email;
    private String password;
}
