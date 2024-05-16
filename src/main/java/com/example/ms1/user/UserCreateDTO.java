package com.example.ms1.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Getter
@Setter
public class UserCreateDTO {


    @NotEmpty(message = "아이디를 입력해주십시오.")
    private String loginId;
    @NotEmpty(message = "비밀번호를 입력해주십시오.")
    private String password;
    @NotEmpty(message = "닉네임를 입력해주십시오.")
    private String nickname;
    @NotEmpty(message = "이메일를 입력해주십시오.")
    @Email(message = "이메일의 형식이 아닙니다.")
    private String  email;
}
