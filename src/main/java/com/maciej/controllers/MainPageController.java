package com.maciej.controllers;

import com.maciej.dto.User;
import com.maciej.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/main")
public class MainPageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUserList();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addUser(@RequestBody User user, HttpServletResponse response){
        response.setHeader("Location", "/users/" + user.getName());
        userService.addNewUser(user);
    }

    @RequestMapping(value = "/users/{userName}", method = RequestMethod.PUT, headers ="Accept=application/json", produces = {"application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User editUser(@RequestBody User user, @PathVariable String userName){
        return userService.editUser(user, userName);
    }

    @RequestMapping(value = "/users/{userName}", method = RequestMethod.GET, headers = {"Accept=application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getSpecifiedUser(@PathVariable String userName){
        return userService.getSpecifiedUser(userName);
    }

    @RequestMapping(value = "/users/{userName}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
    }
}