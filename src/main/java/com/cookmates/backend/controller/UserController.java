package com.cookmates.backend.controller;

import com.cookmates.backend.dto.ResponseMessage;
import com.cookmates.backend.dto.ResponsePagination;
import com.cookmates.backend.dto.UserDTO;
import com.cookmates.backend.model.User;
import com.cookmates.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResponseMessage> doGetAll(){
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get all users successfully")
                .data(userService.getAllUsers())
                .build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> doGetById(@PathVariable Long id){
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get user by id successfully")
                .timestamp(new Date())
                .data(userService.getUserById(id))
                .build(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> doDeleteById(@PathVariable Long id){
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get user by id successfully")
                .timestamp(new Date())
                .data(userService.deleteUser(id))
                .build(),HttpStatus.OK);
    }
}
