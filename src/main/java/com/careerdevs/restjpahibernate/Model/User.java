package com.careerdevs.restjpahibernate.Model;

import javax.persistence.*;

@Entity
@Table(name = "users") //common practice
public class User {
    //id, name, email, favorite color

    @Id
    @GeneratedValue
    public Long id;
    @Column(name="name")
    public String name;
    @Column(name="email")
    public String email;
    @Column(name="favorite_color")
    public String favoriteColor;

    public User() {}

    public User(String data) {
            //("name, email, favColor")
            //then break it down to multiple strings in an array
            String[] strArr = data.split(",");
            //we assume it's in the correct order every time
            this.name = strArr[0];
            this.email = strArr[1];
            this.favoriteColor = strArr[2];
    }

    public User strip() {
        User result = new User();
        result.name = name;
        result.favoriteColor = favoriteColor;
        return result;
    }
}
