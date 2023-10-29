package com.global.hr.user;

import com.global.hr.registration.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest registrationRequest) {
        return new User(registrationRequest.getFirstName(), registrationRequest.getLasName(), registrationRequest.getEmail(),
                passwordEncoder.encode(registrationRequest.getPassword()), Arrays.asList(new Role("ROLE_USER")));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail( email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
