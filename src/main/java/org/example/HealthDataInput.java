package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HealthDataInput {
    private static final String CALORIE_INTAKE_FILE = "calorie_intake.txt";
    private static final String EXERCISE_FILE = "exercise.txt";
    private static final String SLEEP_FILE = "sleep.txt";

    public static void enterCalorieIntake(String username) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Enter the food item: ");
        String foodItem = scanner.nextLine();

        System.out.print("Enter the caloric value: ");
        int calories = scanner.nextInt();
        scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CALORIE_INTAKE_FILE, true))) {
            writer.write(username + "," + date + "," + foodItem + "," + calories);
            writer.newLine();
            System.out.println("Calorie intake recorded successfully.");
        } catch (IOException e) {
            System.out.println("Error recording calorie intake: " + e.getMessage());
        }
    }

    public static void enterExercise(String username) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Enter the type of exercise: ");
        String exerciseType = scanner.nextLine();

        System.out.print("Enter the duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        System.out.print("Enter the estimated calories burned: ");
        int caloriesBurned = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EXERCISE_FILE, true))) {
            writer.write(username + "," + date + "," + exerciseType + "," + duration + "," + caloriesBurned);
            writer.newLine();
            System.out.println("Exercise recorded successfully.");
        } catch (IOException e) {
            System.out.println("Error recording exercise: " + e.getMessage());
        }
    }

    public static void enterSleep(String username) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Enter the time you went to sleep (HH:mm): ");
        String sleepTimeStr = scanner.nextLine();
        System.out.print("Enter the time you woke up (HH:mm): ");
        String wakeupTimeStr = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SLEEP_FILE, true))) {
            writer.write(username + "," + date + "," + sleepTimeStr + "," + wakeupTimeStr);
            writer.newLine();
            System.out.println("Sleep recorded successfully.");
        } catch (IOException e) {
            System.out.println("Error recording sleep: " + e.getMessage());
        }
    }
}
