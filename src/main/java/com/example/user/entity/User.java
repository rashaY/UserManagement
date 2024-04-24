package com.example.user.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotEmpty
    @Length(min = 4, max = 30)
    private String name;

    @NotBlank
    @NotEmpty
    @Length(min = 8, max = 15)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String password;
}
