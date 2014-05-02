package com.maciej.services;

import com.maciej.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<User>();
        userList.add(new User("Maciej", "Tulaza"));
        userList.add(new User("Bartosz", "Tulaza"));
        userList.add(new User("Andrzej", "Grzyb"));
        userList.add(new User("Antoni", "Rewinski"));
        userList.add(new User("Ada", "Ratkiewicz"));
        userList.add(new User("Maciej", "Deltewicz"));
        userList.add(new User("Bartosz", "Antekowski"));
        userList.add(new User("Maciej", "Maciejewicz"));
    }


    public List<User> getUserList(){
        return userList;
    }

    public User getSpecifiedUser(final String userName){
        Iterator it = userList.iterator();
        while(it.hasNext()){
            User us = (User) it.next();
            if(us.getName().equals(userName)){
                return us;
            }
        }
        return null;
    }

    public void addNewUser(User user){
        userList.add(user);
    }

    public User editUser(User user, final String userName){
        Iterator it = userList.iterator();
        while(it.hasNext()){
            User us = (User) it.next();
            if(us.getName().equals(userName)){
                us.setName(user.getName());
                us.setLastname(user.getLastname());
                return us;
            }
        }
        return null;
    }

    public void deleteUser(final String userName){
        Iterator it = userList.iterator();
        while(it.hasNext()){
            User us = (User) it.next();
            if(us.getName().equals(userName)){
                    it.remove();
                    break;
            }
        }
    }
}
