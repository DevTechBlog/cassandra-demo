package com.devtech.poc.cassandrademo.service;

import com.devtech.poc.cassandrademo.domain.Users;
import com.devtech.poc.cassandrademo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findById(UUID uuid) {
        return usersRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
    }

    public Users saveUser(Users users) {
        return usersRepository.save(users);
    }

    public void deleteUser(UUID uuid) {
        usersRepository.deleteById(uuid);
    }

    public Users updateUser(Users users) {
        return usersRepository.save(users);
    }

    public boolean existById(UUID uuid) {
        return usersRepository.existsById(uuid);
    }
}
