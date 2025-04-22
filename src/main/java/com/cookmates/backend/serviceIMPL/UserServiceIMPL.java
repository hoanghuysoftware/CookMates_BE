package com.cookmates.backend.serviceIMPL;

import com.cookmates.backend.dto.UserDTO;
import com.cookmates.backend.enums.StatusGlobal;
import com.cookmates.backend.exception.DataNotFoundException;
import com.cookmates.backend.model.User;
import com.cookmates.backend.repository.UserRepository;
import com.cookmates.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;


    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::fromUser).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Not found user with id: " + id)
        );
        return UserDTO.fromUser(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Not found user with id: " + id)
        );
        user.setStatus(StatusGlobal.NOT_ACTIVE);
        userRepository.save(user);
        return UserDTO.fromUser(user);
    }
}
