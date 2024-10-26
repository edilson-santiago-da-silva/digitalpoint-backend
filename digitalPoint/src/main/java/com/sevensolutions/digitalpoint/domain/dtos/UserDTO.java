package com.sevensolutions.digitalpoint.domain.dtos;

import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.domain.enums.Profile;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String password;
    private Set<Integer> profile = new HashSet<>();

    public UserDTO() {
        super();
        addProfile(Profile.USER);
    }

    public UserDTO(User obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.password = obj.getPassword();
        this.profile = obj.getProfiles().stream().map(Profile::getCode).collect(Collectors.toSet());
        addProfile(Profile.USER);
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

