package com.rancard.RancardTest.service.Impl;

import com.rancard.RancardTest.entity.User;
import com.rancard.RancardTest.repository.UserRepository;
import com.rancard.RancardTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
