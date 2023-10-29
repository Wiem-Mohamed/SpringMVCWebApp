package com.global.hr.registration;

import com.global.hr.event.RegistrationCompleteEvent;
import com.global.hr.user.IUserService;
import com.global.hr.user.User;
import com.global.hr.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    //The model in Spring Boot and Thymeleaf refers to
    // the data that is passed from the controller to the view
    @GetMapping("/registration-form")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new RegistrationRequest());
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegistrationRequest registration){
        User user=userService.registerUser(registration);
        //publish event of verification email
        publisher.publishEvent(new RegistrationCompleteEvent(user,""));
        return "redirect:/registration/registration-form?success";

    }
}
