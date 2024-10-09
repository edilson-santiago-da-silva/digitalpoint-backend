package com.sevensolutions.digitalpoint.repositores;

import com.sevensolutions.digitalpoint.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
