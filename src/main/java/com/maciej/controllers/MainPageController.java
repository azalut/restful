package com.maciej.controllers;

import com.maciej.dto.User;
import com.maciej.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping(value = "/main")
public class MainPageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUsers(){
        return userService.returnOneUser();
    }
}
