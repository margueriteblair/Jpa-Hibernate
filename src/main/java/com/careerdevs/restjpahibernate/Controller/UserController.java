package com.careerdevs.restjpahibernate.Controller;

import com.careerdevs.restjpahibernate.Model.User;
import com.careerdevs.restjpahibernate.Service.UserService;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.reader.StreamReader;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class UserController {

    public static final int DEFAULT_SIZE = 30;

    @Autowired
    UserService service;

    @PostMapping("/test/csv")
    public void postCsvFile(HttpServletRequest req) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        reader.readLine();
        //skips the column names
        String row;
        StatelessSession session = service.getSession();
        var transaction= session.beginTransaction(); //returns a new transaction
        //transaction: commit, rollback

        while ((row = reader.readLine()) != null) {
            //1 = key allows you to set a value to a var
            //2 = compares the value of two variables
//            new User(row);
            session.insert(new User(row));
            //fingers crossed it'll dispose the user before

    }
        transaction.commit();
        session.close();
    }


    @GetMapping("/users")
    public Object getUserPage(@RequestParam(defaultValue = "0") Integer page,
                              @RequestParam(defaultValue = "30") Integer size) {

        Page<User> getPage = service.findAll(page, size);

        Map<String, Object> map = new HashMap<>();
        map.put("content", getPage.getContent());
        map.put("size", size);
        map.put("page", page);
        map.put("totalPages", getPage.getTotalPages());
        map.put("totalItems", getPage.getTotalElements());

        return map;
    }

    @PostMapping("/user")
    public Object postUser(
            @RequestBody User user
            ) {
        return service.save(user);
    }

}
