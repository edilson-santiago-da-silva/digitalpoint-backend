package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import com.sevensolutions.digitalpoint.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = repository.findByName(name);
        if(user.isPresent()){
            return new UserSS(user.get().getId(), user.get().getName(), user.get().getPassword(), user.get().getProfile());
        }
        throw new UsernameNotFoundException(name);
    }
}
