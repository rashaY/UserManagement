package com.example.mapper;

import com.example.user.dto.UserDto;
import com.example.user.entity.User;
import com.example.user.model.UserModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserModel toUserModel(User user);
    List<UserModel> toListUserModel(List<User> user);
    User toUserEntity(UserDto user);
}
