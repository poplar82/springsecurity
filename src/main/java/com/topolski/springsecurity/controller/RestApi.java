package com.topolski.springsecurity.controller;

import com.topolski.springsecurity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class RestApi {
    static final String LOGOUT = "<BR><A HREF=\"/logout\">logout</A>";
    Counter counter;
    @Autowired
    public RestApi(Counter counter) {
        this.counter = counter;
    }
    @GetMapping()
    public String getLogin(Principal principal) {
        if (principal == null) {
            return "<A HREF=\"/login\">Login</A>";
        }
        if (principal.getName().equals("admin")) {
            return "<A HREF=\"/admin\">admin</A><BR><A HREF=\"/user\">user</A><BR>admin login counter: " + counter.getAdminLoginCounter();
        } else {
            return "<A HREF=\"/user\">user</A><BR>user login counter: " + counter.getUserLoginCounter();
        }
    }

    @GetMapping("/all")
    public String getForAll(Principal principal){
        if (principal == null) {
            return "hello anonymous";
        }
        return  "hello " + principal.getName() +  LOGOUT;
    }
    @GetMapping("/user")
    public String getForUser(Principal principal){
        return "hello user " + principal.getName() +  LOGOUT;
    }
    @GetMapping("/admin")
    public String getForAdmin(Principal principal){
        return "hello admin " + principal.getName() +  LOGOUT;
    }
    @GetMapping("/goodbye")
    public String logout(){
        return "Papa";
    }
}
