package com.example.LogiTrack.Repositories;

import com.example.LogiTrack.Models.UserEntity;

import java.lang.ScopedValue;
import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByUsername(String username);
}
