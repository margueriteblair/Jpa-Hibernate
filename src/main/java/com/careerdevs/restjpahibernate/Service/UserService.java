package com.careerdevs.restjpahibernate.Service;

import com.careerdevs.restjpahibernate.Model.User;
import com.careerdevs.restjpahibernate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository database;

    public List<User> findAll(){
        return database.findAll();
    }

    public Page<User> findAll(int page, int size) {
        return database.findAll(PageRequest.of(page, size));
    }

    public User save(User user) {
        return database.save(user);
    }

    public User findById(Long id) {
        return database.findById(id).orElse(null);
    }

    public void removeById(Long id) {
        database.deleteById(id);
    }
}
