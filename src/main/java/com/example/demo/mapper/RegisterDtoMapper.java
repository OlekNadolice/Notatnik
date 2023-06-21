package com.example.demo.mapper;

import org.springframework.stereotype.Service;
import com.example.demo.domain.User;
import com.example.demo.dto.auth.ChangePasswordDTO;
import com.example.demo.dto.auth.RegisterDTO;
import com.example.demo.dto.auth.ResetPasswordDTO;

@Service
public class RegisterDtoMapper {

    public static User mapToUser(RegisterDTO registerDTO, String token) {
        return User.builder()
                .username(registerDTO.getUsername())
                .password(registerDTO.getPassword())
                .email(registerDTO.getEmail())
                .activationToken(token)
                .build();
    }

    public static ResetPasswordDTO mapToResetPasswordDTO(User user) {
        return ResetPasswordDTO.builder()
                .id(user.getId())
                .resetPasswordToken(user.getResetPasswordToken())
                .build();
    }

    public static ChangePasswordDTO mapToChangePasswordDTO(User user) {
        return ChangePasswordDTO.builder()
                .id(user.getId())
                .build();
    }
}
