package io.github.aprovadespesas.service;

import io.github.aprovadespesas.dto.request.LoginRequest;
import io.github.aprovadespesas.dto.request.RegisterUserRequest;
import io.github.aprovadespesas.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterUserRequest registerUserRequest);
}
