package com.angular.spring.tfg.teamfighttacticssearch.security.entity;

import com.angular.spring.tfg.teamfighttacticssearch.security.enums.RolName;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;

    public Rol() {
    }

    public Rol(@NotNull RolName rolNombre) {
        this.rolName = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolName getRolNombre() {
        return rolName;
    }

    public void setRolNombre(RolName rolNombre) {
        this.rolName = rolNombre;
    }
}
