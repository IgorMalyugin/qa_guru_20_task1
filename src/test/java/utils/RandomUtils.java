package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static Faker faker = new Faker(new Locale("en"));

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }


    public static String getRandomMonth() {
        return faker.options()
                .option("January", "February", "March", "April", "May", "June", "July",
                        "August", "September", "October", "November", "December");
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomSubject() {
        return faker.options()
                .option("Math", "English", "Chemistry", "Civics", "Computer Science",
                        "Arts", "Physics", "Economics");
    }

    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        } else if (state.equals("Rajasthan")) {
            String[] city = {"Jaipur", "Jaiselmer"};
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return null;
    }
}
