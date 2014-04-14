package com.maciej.services;

import com.maciej.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList;

    public List<User> getUserList(){
        return userList;
    }

    public User returnOneUser(){
        return new User("Maciej", "NowyJedenUser");
    }

    public UserService() {
        userList = new ArrayList<User>();
        userList.add(new User("Maciej", "Tulaza"));
        userList.add(new User("Bartosz", "Tulaza"));
        userList.add(new User("Andrzej", "Grzyb"));
        userList.add(new User("Antoni", "Rewinski"));
        userList.add(new User("Ada", "Ratkiewicz"));
    }

}
