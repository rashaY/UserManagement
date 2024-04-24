package com.example.mapper;

import com.example.user.entity.User;
import com.example.user.model.UserModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserModel toDto(User user);
}
