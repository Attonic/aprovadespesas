package io.github.aprovadespesas.controller;

import io.github.aprovadespesas.dto.request.ChangePasswordRequest;
import io.github.aprovadespesas.dto.request.LoginRequest;
import io.github.aprovadespesas.dto.request.RegisterUserRequest;
import io.github.aprovadespesas.dto.response.AuthResponse;
import io.github.aprovadespesas.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody
            LoginRequest loginRequest
    ) {
        AuthResponse authResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody
            RegisterUserRequest registerUserRequest
    ) {
        AuthResponse authResponse = authService.register(registerUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
    }

    @PostMapping("{id}/password")
    public ResponseEntity<Void> changePassword(
            @PathVariable Long id,
            @Valid @RequestBody ChangePasswordRequest changePasswordRequest
            ){
        authService.changePassword(id, changePasswordRequest);
        return ResponseEntity.noContent().build();
    }
}
