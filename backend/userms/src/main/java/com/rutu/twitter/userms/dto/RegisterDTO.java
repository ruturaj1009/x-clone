package com.rutu.twitter.userms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    private String fullName;
    private String email;
    private String userName;
    private String password;
    private String bio;
}
