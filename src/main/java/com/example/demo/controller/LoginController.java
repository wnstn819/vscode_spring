package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users loginRequest) {
        Users user = usersRepository.findByIdAndPassword(
            loginRequest.getId(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(401).body("로그인 실패");
        }
    }

    @GetMapping("/user-list")
    public ResponseEntity<List<Users>> info() {
        List<Users> user = usersRepository.findAll();
        System.out.println("here");
        for(Users us : user){
            System.out.println(us.getId());
        }
        return ResponseEntity.ok(usersRepository.findAll());
    }
}
