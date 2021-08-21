package com.topolski.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
    Counter counter;
    @Autowired
    public AuthenticationSuccessListener(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent interactiveAuthenticationSuccessEvent) {
        if (interactiveAuthenticationSuccessEvent.getAuthentication().getName().equals("admin")) {
            counter.addAdminLogin();
        } else {
            counter.addUserLogin();
        }
    }
}
