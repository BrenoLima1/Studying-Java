package com.yourapp.auth_jwt.auth;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.yourapp.auth_jwt.security.JwtService;
import com.yourapp.auth_jwt.user.User;
import com.yourapp.auth_jwt.user.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public final JwtService jwtService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }

        String token = jwtService.generateToken(user.getUsername(), user.getRole());
        return new LoginResponse(token, user.getUsername(), user.getRole());
    }


    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        User entity = userRepository.save(user);

        return new RegisterResponse(entity.getId(), entity.getUsername(), entity.getRole());
    }

    @GetMapping("/me")
    public UserResponse me() {
        String username =
                (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return new UserResponse(user.getId(), user.getUsername(), user.getRole());
    }

    // @GetMapping("/users")
    // public List<UserResponse> listUsers() {
    // String username = (String)
    // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    // User currentUser = userRepository.findByUsername(username)
    // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    // if (!"ROLE_ADMIN".equals(currentUser.getRole())) {
    // throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
    // }

    // return userRepository.findAll()
    // .stream()
    // .map(u -> new UserResponse(u.getId(), u.getUsername(), u.getRole()))
    // .toList();
    // }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<UserResponse> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserResponse(u.getId(), u.getUsername(), u.getRole()))
                .toList();
    }

}
