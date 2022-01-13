package com.devtech.poc.cassandrademo.controller;

import com.devtech.poc.cassandrademo.domain.Users;
import com.devtech.poc.cassandrademo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") String id) {
        if (usersService.existById(UUID.fromString(id))) {
            return ResponseEntity.ok(usersService.findById(UUID.fromString(id)));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users users) {
        users.setId(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.saveUser(users));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") String id, @RequestBody Users users) {
        if (usersService.existById(UUID.fromString(id))) {
            users.setId(UUID.fromString(id));
            return ResponseEntity.ok(usersService.saveUser(users));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") String id) {
        usersService.deleteUser(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}