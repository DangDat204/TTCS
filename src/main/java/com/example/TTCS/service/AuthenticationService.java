package com.example.TTCS.service;

import com.example.TTCS.configuration.JwtUtil;
import com.example.TTCS.entity.User;
import com.example.TTCS.exception.AppException;
import com.example.TTCS.exception.ErrorCode;
import com.example.TTCS.model.request.AuthenticationRequest;
import com.example.TTCS.model.response.AuthenticationResponse;
import com.example.TTCS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Xác thực bằng AuthenticationManager
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch(BadCredentialsException e) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        var user = userRepository.findUserByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        // Tạo token
        String token = null;
        try {
            token = jwtUtil.generateToken(user.getUsername(), buildScope(user));
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private String buildScope(User user){
        StringJoiner scope = new StringJoiner(" ");
//        Nếu roles không rỗng
        if (user.getRole() != null) {
            var role = user.getRole();
            scope.add("ROLE_" + user.getRole());
        }
        return scope.toString().trim();
    }
}
