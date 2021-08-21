package com.topolski.springsecurity;

import org.springframework.stereotype.Service;

@Service
public class Counter {
    private int adminLoginCounter;
    private int userLoginCounter;

    public Counter() {
        this.adminLoginCounter = 0;
        this.userLoginCounter = 0;
    }

    public int getAdminLoginCounter() {
        return adminLoginCounter;
    }

    public void addAdminLogin() {
        this.adminLoginCounter += 1;
    }

    public int getUserLoginCounter() {
        return userLoginCounter;
    }

    public void addUserLogin() {
        this.userLoginCounter += 1;
    }
}
