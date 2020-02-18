package com.seniorsteps.app.repository;

import com.seniorsteps.app.models.User;

public interface UserRepository {

	User save(User user);

	User findUserByUsername(String email);

	User findUserById(int userId);

}