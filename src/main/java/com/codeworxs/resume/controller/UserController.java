package com.codeworxs.resume.controller;

import com.codeworxs.resume.exception.ResourceNotFoundException;
import com.codeworxs.resume.model.User;
import com.codeworxs.resume.repository.UserRepository;
import com.codeworxs.resume.security.CurrentUser;
import com.codeworxs.resume.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
