package com.angular.spring.tfg.teamfighttacticssearch.security.service;

import com.angular.spring.tfg.teamfighttacticssearch.security.entity.User;
import com.angular.spring.tfg.teamfighttacticssearch.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional//Coherencia en base de datos.
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public boolean existsByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
