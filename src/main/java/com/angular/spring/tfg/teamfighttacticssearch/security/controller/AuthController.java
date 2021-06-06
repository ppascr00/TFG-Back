package com.angular.spring.tfg.teamfighttacticssearch.security.controller;

import com.angular.spring.tfg.teamfighttacticssearch.dto.Mensaje;
import com.angular.spring.tfg.teamfighttacticssearch.security.dto.JwtDto;
import com.angular.spring.tfg.teamfighttacticssearch.security.dto.LoginUser;
import com.angular.spring.tfg.teamfighttacticssearch.security.dto.NewUser;
import com.angular.spring.tfg.teamfighttacticssearch.security.entity.Rol;
import com.angular.spring.tfg.teamfighttacticssearch.security.entity.User;
import com.angular.spring.tfg.teamfighttacticssearch.security.enums.RolName;
import com.angular.spring.tfg.teamfighttacticssearch.security.jwt.JwtProvider;
import com.angular.spring.tfg.teamfighttacticssearch.security.service.RolService;
import com.angular.spring.tfg.teamfighttacticssearch.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos mal puestos o email inválido."), HttpStatus.BAD_REQUEST);
        }

        if(userService.existsByUserName(newUser.getUserName())){
            return new ResponseEntity(new Mensaje("Ese usuario ya existe."), HttpStatus.BAD_REQUEST);
        }

        if(userService.existsByEmail(newUser.getEmail())){
            return new ResponseEntity(new Mensaje("Ese email ya existe."), HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUser.getUserName(), newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin")){
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        }

        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Usuario o contraseña incorrectos."), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);

    }
}
