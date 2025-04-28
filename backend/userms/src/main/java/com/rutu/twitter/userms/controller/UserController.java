package com.rutu.twitter.userms.controller;

import com.rutu.twitter.userms.dto.LoginDTO;
import com.rutu.twitter.userms.dto.UserDTO;
import com.rutu.twitter.userms.exception.BaseException;
import com.rutu.twitter.userms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) throws BaseException {
        return new ResponseEntity<>(service.register(userDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO) throws BaseException, NoSuchAlgorithmException {
        if (loginDTO.getUserName() == null && loginDTO.getEmail() == null) {
            throw new BaseException("Username or Email must be present");
        }
        return new ResponseEntity<>(Collections.singletonMap("token", service.login(loginDTO)), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserDTO>> getUsers() throws BaseException {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{data}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "data") Long data, @RequestParam(name = "type", required = false) String type) throws BaseException {
        return new ResponseEntity<>(service.findById(data), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable(name = "id") Long id) throws BaseException {
        return new ResponseEntity<>(service.updateUser(userDTO, id), HttpStatus.OK);
    }
}
