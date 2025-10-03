package com.tracker.bp_tracker;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import com.tracker.bp_tracker.user.Authenticator;
import com.tracker.bp_tracker.user.User;
import com.tracker.bp_tracker.user.UserProfile;

public class UserInterface {
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Welcome to the User Interface!");

        UserInterface ui = new UserInterface();
        ui.scanner = new Scanner(System.in);

        User user = ui.authenticateUser();
        if (user != null) {
            UserProfile userProfile = DataSource.getUserProfile(user.getUserProfileId());
            ui.showProfile(user, userProfile);

        }

        ui.scanner.close();
    }

    private User authenticateUser() {

        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        User user = null;
        try {
            user = Authenticator.login(username, password);
        } catch (LoginException e) {
            System.out.print("There was an error:" + e.getMessage());
        }
        return user;
    }

    private static void showProfile(User user, UserProfile userProfile) {
        System.out.println("User Profile:" + user.getUsername());
        System.out.println("User Medical Report: " + userProfile.getMedicalRecord());
        int selection = 0;

        while (selection != 3) {
            System.out.println("1. View Medical Report");
            System.out.println("2. Update Medical Report");
            System.out.println("3. Exit");

            System.out.print("Select an option: ");
            selection = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (selection) {
                case 1:
                    System.out.println("Medical Report: " + userProfile.getMedicalRecord());
                    break;
                case 2:
                    System.out.print("Enter new medical report: ");
                    int sys = scanner.nextInt();
                    int dias = scanner.nextInt();
                    int pulse = scanner.nextInt();
                    String newReport = "Blood Pressure: " + sys + "/" + dias + ", Pulse: " + pulse;
                    userProfile.setMedicalRecord(newReport);
                    System.out.println("Medical report updated.");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }
        }
    }
}
