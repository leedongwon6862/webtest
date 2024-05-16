package com.example.ms1.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/signup")
    public String signup(UserCreateDTO userCreateDTO){
        return"signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid  UserCreateDTO userCreateDTO , BindingResult bindingResult){
        if(bindingResult.hasErrors ()){
            return "signup_form";
        }
        userService.createUser(userCreateDTO.getLoginId (), userCreateDTO.getPassword (), userCreateDTO.getNickname (), userCreateDTO.getEmail ());
        return "redirect:/";
    }


    @GetMapping("/login")
    public String login(){
        return"login_form";
    }
}
