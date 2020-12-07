package com.koval.HelperForCafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {
    private String name;
    private Long phoneNumber;
    private String login;
    private String password;
    private RoleDto roleDto;
}
