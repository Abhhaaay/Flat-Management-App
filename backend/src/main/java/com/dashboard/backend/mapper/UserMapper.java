package com.dashboard.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.dashboard.backend.dto.SignUpDto;
import com.dashboard.backend.dto.UserDto;
import com.dashboard.backend.entity.Admin;
import com.dashboard.backend.entity.Owner;
import com.dashboard.backend.entity.Tenant;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDto toUserDto(Admin admin);
    UserDto toUserDto(Owner owner);
    UserDto toUserDto(Tenant tenant);
    
    @Mapping(target = "password", ignore = true)
    Owner signUpToOwner(SignUpDto signUpDto);
    
    @Mapping(target = "password", ignore = true)
    Tenant signUpToTenant(SignUpDto signUpDto);
}


// package com.dashboard.backend.mapper;

// import org.mapstruct.Mapper;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

// import com.dashboard.backend.dto.SignUpDto;
// import com.dashboard.backend.dto.UserDto;

// @Mapper(componentModel = "spring")
// public interface UserMapper {
    

//     UserDto toUserDto(User user);
    
//     @Mapping(target = "password", ignore = true)
//     User signUpToUser(SignUpDto userDto);
// }
