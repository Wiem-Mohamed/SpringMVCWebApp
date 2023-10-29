package com.global.hr.user;

import com.global.hr.registration.RegistrationRequest;

import java.util.List;

public interface IUserService {
  List<User> getAllUsers();
  User registerUser (RegistrationRequest registrationRequest);
  User findByEmail(String email);
}
