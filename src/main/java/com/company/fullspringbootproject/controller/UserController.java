package com.company.fullspringbootproject.controller;

import com.company.fullspringbootproject.dto.ResponseDto;
import com.company.fullspringbootproject.dto.UserDto;
import com.company.fullspringbootproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseDto<UserDto> create(@RequestBody UserDto dto) {
        return this.userService.create(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseDto<UserDto> get(@PathVariable(value = "id") Integer userId) {
        return this.userService.get(userId);
    }


}
