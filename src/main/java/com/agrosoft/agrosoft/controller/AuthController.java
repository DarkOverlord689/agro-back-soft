package com.agrosoft.agrosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrosoft.agrosoft.model.AuthDTO;
import com.agrosoft.agrosoft.model.AuthenticationDTO;
import com.agrosoft.agrosoft.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthDTO> login(@RequestBody AuthenticationDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
