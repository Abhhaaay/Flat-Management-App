package com.dashboard.backend.dto;

import org.mapstruct.Mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Mapper
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginResponseDto {
    
    private Integer number;
    private String login;
    private String token;
}
