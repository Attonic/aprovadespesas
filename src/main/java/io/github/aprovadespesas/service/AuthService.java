package io.github.aprovadespesas.service;

import io.github.aprovadespesas.dto.request.LoginRequest;
import io.github.aprovadespesas.dto.request.RegisterUserRequest;
import io.github.aprovadespesas.dto.response.AuthResponse;
import io.github.aprovadespesas.entity.User;
import io.github.aprovadespesas.repositories.DepartmentRepository;
import io.github.aprovadespesas.repositories.UserRepository;
import io.github.aprovadespesas.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthResponse register(RegisterUserRequest registerUserRequest) {
        if (userRepository.existsByEmail(registerUserRequest.email())){
            throw new RuntimeException("Email já cadastrado."); //TODO Criar exceção personalizada
        }
        var builder = User.builder()
                .name(registerUserRequest.name())
                .email(registerUserRequest.email())
                .password(passwordEncoder.encode(registerUserRequest.password()))
                .role(registerUserRequest.role());

        if (registerUserRequest.departmentId() != null) {//TODO Criar exceção personalizada
            builder.department(departmentRepository.findById(registerUserRequest.departmentId()).orElseThrow());
        }
        return token(userRepository.save(builder.build()));
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.email(), request.password()
        ));
        var user = userRepository.findByEmail(request.email()).orElseThrow(); //TODO Exceção
        return token(user);
    }

    //TODO Implementar Troca de Senha

    private AuthResponse token(User user) {
        return AuthResponse.builder()
                .accessToken(jwtService.generateToken(user))
                .tokenType("Bearer").expiresIn(900L).build();
    }

    
}
