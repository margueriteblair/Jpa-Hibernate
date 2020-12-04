package com.careerdevs.restjpahibernate.Model;

import javax.persistence.*;

@Entity
@Table(name = "users") //common practice
public class User {
    //id, name, email, favorite color

    @Id
    @GeneratedValue
    public long id;
    @Column(name="name")
    public String name;
    @Column(name="email")
    public String email;
    @Column(name="favorite_color")
    public String favoriteColor;

    public User strip() {
        User result = new User();
        result.name = name;
        result.favoriteColor = favoriteColor;
        return result;
    }
}
