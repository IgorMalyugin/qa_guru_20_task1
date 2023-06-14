package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return faker.options().option(month);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Math", "English", "Chemistry", "Civics", "Computer Science", "Arts", "Physics", "Economics"};
        return faker.options().option(subjects);
    }

    public static String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return faker.options().option(hobby);
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            String[] city = {"Delhi", "Gurgaon", "Noida"};
            return faker.options().option(city);
        } else if (state.equals("Uttar Pradesh")) {
            String[] city = {"Agra", "Lucknow", "Merrut"};
            return faker.options().option(city);
        } else if (state.equals("Haryana")) {
            String[] city = {"Karnal", "Panipat"};
            return faker.options().option(city);
        } else if (state.equals("Rajasthan")) {
            String[] city = {"Jaipur", "Jaiselmer"};
            return faker.options().option(city);
        }
        return null;
    }
}
