package com.tracker.bp_tracker.user;

import javax.security.auth.login.LoginException;

import com.tracker.bp_tracker.DataSource;

public class Authenticator {

    public static User login(String username, String password) throws LoginException {
        User user = DataSource.getUser(username);
        if (user == null) {
            throw new LoginException("Username not found");
        }

        if (password.equals(user.getPassword())) {
            user.setAuthenticated(true);
            return user;
        } else {
            throw new LoginException("Invalid password");
        }
    }

    public static void logout(User user) {
        // Logic to log out the user
        user.setAuthenticated(false);
    }
}
