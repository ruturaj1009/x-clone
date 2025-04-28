package com.rutu.twitter.userms.service.impl;

import com.rutu.twitter.userms.dto.LoginDTO;
import com.rutu.twitter.userms.dto.UserDTO;
import com.rutu.twitter.userms.entity.User;
import com.rutu.twitter.userms.exception.BaseException;
import com.rutu.twitter.userms.repository.UserRepository;
import com.rutu.twitter.userms.service.UserService;
import com.rutu.twitter.userms.utility.ModelMapper;
import com.rutu.twitter.userms.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO register(UserDTO userDTO) throws BaseException {
        if (repository.findByUserName(userDTO.getUserName()).isPresent()) {
            throw new BaseException("user already exists with this username");
        }
        if (repository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new BaseException("user already exists with this email");
        }
        userDTO.setId(null);
        UserDTO savedUser = ModelMapper.getUserDTO(repository.save(ModelMapper.getUser(userDTO)));
        savedUser.setPassword(null);
        return savedUser;
    }

    @Override
    public String login(LoginDTO loginDTO) throws BaseException, NoSuchAlgorithmException {
        Optional<User> user;
        user = repository.findByEmail(loginDTO.getEmail());
        if (user.isEmpty()) {
            user = Optional.ofNullable(repository.findByUserName(loginDTO.getUserName()).orElseThrow(() -> new BaseException("User not found")));
        }

        if (!user.get().getPassword().equals(loginDTO.getPassword())) {
            throw new BaseException("Password doesn't match");
        }
        return Utility.generateToken(user.get().getUserName(), user.get().getEmail());
    }

    @Override
    public LoginDTO logout(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() throws BaseException {
        List<User> userList = repository.findAll();
        if (userList.isEmpty()) {
            throw new BaseException("users not found");
        }
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = ModelMapper.getUserDTO(user);
            userDTO.setPassword(null);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public UserDTO findById(Long id) throws BaseException {
        User user = repository.findById(id).orElseThrow(() -> new BaseException("user not found"));
        user.setPassword(null);
        return ModelMapper.getUserDTO(user);
    }

    @Override
    public UserDTO findByUserName(String userName) throws BaseException {
        User user = repository.findByUserName(userName).orElseThrow(() -> new BaseException("user not found"));
        user.setPassword(null);
        return ModelMapper.getUserDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) throws BaseException {
        User user = repository.findByEmail(email).orElseThrow(() -> new BaseException("user not found"));
        user.setPassword(null);
        return ModelMapper.getUserDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) throws BaseException {
        User user = repository.findById(id).orElseThrow(() -> new BaseException("user not found"));
        User updatedUser = ModelMapper.getUser(userDTO);
        updatedUser.setPassword(user.getPassword());
        repository.save(updatedUser);
        updatedUser.setPassword(null);
        return ModelMapper.getUserDTO(updatedUser);
    }
}
