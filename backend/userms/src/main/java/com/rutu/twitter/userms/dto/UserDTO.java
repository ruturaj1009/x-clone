package com.rutu.twitter.userms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String fullName;
    private String bio;
    private String profileImageUrl;
    private String coverImageUrl;
    private Instant createdAt;
    private Instant updatedAt;
}
