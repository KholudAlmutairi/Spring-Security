package com.example.demo.Controller;

import com.example.demo.Api.ApiResponse;
import com.example.demo.Model.User;
import com.example.demo.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
         authService.register(user);
        return ResponseEntity.status(200).body(user);

    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid User user){
        return ResponseEntity.status(200).body("Welcome back!");

    }


    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody @Valid User user){
        return ResponseEntity.status(200).body("Done successfully logout!");

    }


    @GetMapping("/get")
    public ResponseEntity getAllUsers(){//admin
        return ResponseEntity.status(200).body(authService.getAllUsers());
    }

    @DeleteMapping("/delete/{username1}/{username2}")//admin
    public ResponseEntity deleteUser(@PathVariable String username1,@PathVariable String username2){
          authService.deleteUser(username1,username2);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted!"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user){
        authService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse( "User updated"));
    }









}








