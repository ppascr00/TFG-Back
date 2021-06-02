package com.angular.spring.tfg.teamfighttacticssearch.security.service;

import com.angular.spring.tfg.teamfighttacticssearch.security.entity.PrincipalUser;
import com.angular.spring.tfg.teamfighttacticssearch.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getByUserName(userName).get();
        return PrincipalUser.build(user);
    }
}
