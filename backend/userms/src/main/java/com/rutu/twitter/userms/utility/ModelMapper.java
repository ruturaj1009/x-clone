package com.rutu.twitter.userms.utility;

import com.rutu.twitter.userms.dto.UserDTO;
import com.rutu.twitter.userms.entity.User;

public class ModelMapper {
    public static UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setUserName(user.getUserName());
        userDTO.setBio(user.getBio());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullName(user.getFullName());
        userDTO.setProfileImageUrl(user.getProfileImageUrl());
        userDTO.setCoverImageUrl(user.getCoverImageUrl());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());
        return userDTO;
    }

    public static User getUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());
        user.setUserName(userDTO.getUserName());
        user.setBio(userDTO.getBio());
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setProfileImageUrl(userDTO.getProfileImageUrl());
        user.setCoverImageUrl(userDTO.getCoverImageUrl());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUpdatedAt(userDTO.getUpdatedAt());
        return user;
    }
}
