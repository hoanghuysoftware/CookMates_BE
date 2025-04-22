package com.cookmates.backend.service;

import com.cookmates.backend.dto.UserDTO;
import com.cookmates.backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO deleteUser(Long id);
}
