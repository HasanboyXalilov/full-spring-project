package com.company.fullspringbootproject.service;

import com.company.fullspringbootproject.dto.ResponseDto;
import com.company.fullspringbootproject.dto.UserDto;
import com.company.fullspringbootproject.model.User;
import com.company.fullspringbootproject.repository.UserRepository;
import com.company.fullspringbootproject.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public ResponseDto<UserDto> create(UserDto dto) {
        try {
            User user = this.userMapper.toEntity(dto);
            user.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("OK")
                    .data(
                            this.userMapper.toDto(
                                    this.userRepository.save(user)
                            )
                    )
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserDto>builder()
                    .code(-2)
                    .message(String.format("User while saving error message :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<UserDto> get(Integer userId) {
        return this.userRepository.findByUserIdAndDeletedAtIsNull(userId)
                .map(user -> ResponseDto.<UserDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.userMapper.toDto(user))
                        .build())
                .orElse(ResponseDto.<UserDto>builder()
                        .code(-1)
                        .message(String.format("User with %d:id is not found!", userId))
                        .build());
    }


}
