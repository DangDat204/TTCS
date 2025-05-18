package com.example.TTCS.controller;

import com.example.TTCS.model.ApiResponse;
import com.example.TTCS.model.request.AuthenticationRequest;
import com.example.TTCS.model.response.AuthenticationResponse;
import com.example.TTCS.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        AuthenticationResponse result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .message("kiem tra tai khoan nguoi dung")
                .build();
    }
}
