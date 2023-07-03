package com.twohundred.alumni.controller;

import com.twohundred.alumni.entity.dto.request.LoginRequest;
import com.twohundred.alumni.entity.dto.request.RegisterRequest;
import com.twohundred.alumni.entity.dto.response.LoginResponse;
import com.twohundred.alumni.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UaaController {

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}