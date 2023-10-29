package com.global.hr.registration;

import com.global.hr.user.Role;
import lombok.Data;

import java.util.Collection;
@Data
public class RegistrationRequest {
    private String firstName;
    private String lasName;
    private  String email;
    private String  password;
    private Collection<Role> roles;

}
