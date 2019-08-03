package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.Utils.Exception.ResourceNotFoundException;
import com.expensemanager.expensemanager.dto.UserDto;
import com.expensemanager.expensemanager.mapper.UserMapper;
import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<UserDto> getAll() {
        List<User> categories = userService.findAll();
        return categories.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/user/create")
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User userResult = userService.save(user);
        return userMapper.toDto(userResult);
    }

    @PutMapping("/user/update/{id}")
    public UserDto updateUser(@PathVariable(value="id") Long id,
                                            @Valid @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User userResult =userService.save(user);
        return userMapper.toDto(userResult);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Optional<User> user = userService.findById(id);
        User userFound = user.get();
        return userMapper.toDto(userFound);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable(value="id") Long id){
        userService.delete(id);
    }
}
