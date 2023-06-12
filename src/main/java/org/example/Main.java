package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    userManagement.createUser(username);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    User user = userManagement.loginUser(username);
                    if (user != null) {
                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("1. Enter Daily Calorie Intake");
                            System.out.println("2. Enter Exercise");
                            System.out.println("3. Enter Sleep");
                            System.out.println("4. Perform Health Data Analysis");
                            System.out.println("5. Logout");
                            System.out.print("Enter your choice: ");
                            int c = scanner.nextInt();
                            scanner.nextLine();

                            switch (c) {
                                case 1:
                                    HealthDataInput.enterCalorieIntake(user.getUser());
                                    break;
                                case 2:
                                    HealthDataInput.enterExercise(user.getUser());
                                    break;
                                case 3:
                                    HealthDataInput.enterSleep(user.getUser());
                                    break;
                                case 4:
                                    performHealthDataAnalysis(user.getUser());
                                    break;
                                case 5:
                                    loggedIn = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void performHealthDataAnalysis(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Calculate Daily Caloric Balance");
        System.out.println("2. Perform Sleep Analysis");
        System.out.println("3. Display Exercise Log");
        System.out.println("4. Generate Health Summary");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter date (YYYY-MM-DD): ");
                String dateStr = scanner.nextLine();
                LocalDate date = LocalDate.parse(dateStr);
                HealthDataAnalysis.calculateDailyCaloricBalance(username, date);
                break;
            case 2:
                System.out.print("Enter start date (YYYY-MM-DD): ");
                String startDateStr = scanner.nextLine();
                LocalDate startDate = LocalDate.parse(startDateStr);
                System.out.print("Enter end date (YYYY-MM-DD): ");
                String endDateStr = scanner.nextLine();
                LocalDate endDate = LocalDate.parse(endDateStr);
                HealthDataAnalysis.calculateAverageSleepDuration(username, startDate, endDate);
                break;
            case 3:
                HealthDataAnalysis.displayExerciseLog(username);
                break;
            case 4:
                System.out.print("Enter start date (YYYY-MM-DD): ");
                startDateStr = scanner.nextLine();
                startDate = LocalDate.parse(startDateStr);
                System.out.print("Enter end date (YYYY-MM-DD): ");
                endDateStr = scanner.nextLine();
                endDate = LocalDate.parse(endDateStr);
                HealthDataAnalysis.generateHealthSummary(username, startDate, endDate);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
