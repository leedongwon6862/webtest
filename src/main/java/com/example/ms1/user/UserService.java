package com.example.ms1.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser createUser(String loginId ,String password , String nickname , String email) {
        SiteUser siteUser = new SiteUser ();
        siteUser.setLoginId (loginId);
        siteUser.setPassword (passwordEncoder.encode (password));
        siteUser.setNickname (nickname);
        siteUser.setEmail (email);
        siteUser.setCreateDate (LocalDateTime.now ());

        return userRepository.save(siteUser);
    }
}
