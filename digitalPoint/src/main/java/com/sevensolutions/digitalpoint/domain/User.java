package com.sevensolutions.digitalpoint.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sevensolutions.digitalpoint.domain.enums.Profile;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PROFILE")
    private Set<Integer> profile = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Point> point = new ArrayList<>();

    public User( ){
        super();
        addProfile(Profile.USER);
    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public List<Point> getPoint() {
        return point;
    }

    public void setPoint(List<Point> point){
        this.point = point;
    }

    public void addProfile(Profile profile){
        this.profile.add(profile.getCode());
   }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
