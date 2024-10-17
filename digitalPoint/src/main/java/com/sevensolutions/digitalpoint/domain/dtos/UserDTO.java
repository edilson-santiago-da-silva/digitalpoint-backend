package com.sevensolutions.digitalpoint.domain.dtos;

import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.domain.enums.Profile;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String name;
    protected String password;
    protected Set<Integer> profile = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.password = obj.getPassword();
        this.profile = obj.getProfiles().stream().map(Profile::getCode).collect(Collectors.toSet());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profile.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile){
        this.profile.add(profile.getCode());
    }
}

