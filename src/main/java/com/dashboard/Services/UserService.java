package com.dashboard.Services;

import com.dashboard.Entities.User;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User save(User user);
}
