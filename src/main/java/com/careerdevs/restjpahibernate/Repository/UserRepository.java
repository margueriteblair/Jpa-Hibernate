package com.careerdevs.restjpahibernate.Repository;

import com.careerdevs.restjpahibernate.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
