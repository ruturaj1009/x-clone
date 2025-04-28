package com.rutu.twitter.userms.service;

import com.rutu.twitter.userms.dto.LoginDTO;
import com.rutu.twitter.userms.dto.UserDTO;
import com.rutu.twitter.userms.exception.BaseException;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

    //auth
    UserDTO register(UserDTO userDTO) throws BaseException;

    String login(LoginDTO loginDTO) throws BaseException, NoSuchAlgorithmException;

    LoginDTO logout(LoginDTO loginDTO);

    //admin
    List<UserDTO> findAll() throws BaseException;

    //user
    UserDTO findById(Long id) throws BaseException;

    UserDTO findByUserName(String userName) throws BaseException;

    UserDTO findByEmail(String email) throws BaseException;

    UserDTO updateUser(UserDTO userDTO, Long id) throws BaseException;

}
