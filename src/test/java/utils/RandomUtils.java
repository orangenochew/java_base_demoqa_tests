package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(8));
        System.out.println(getRandomEmail(8));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomSubject());
        System.out.println(getRandomYear());
        System.out.println(getRandomMonth());
        System.out.println(getRandomDay());
        System.out.println(getRandomAddress());
        System.out.println(getRandomState());
        System.out.println(getRandomState());
        System.out.println(getRandomCity(getRandomState()));
    }

    static Faker faker = new Faker();

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++)
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));


        return result.toString();
    }

    public static String getRandomEmail(int length) {
        //      return getRandomString(8) + "@" + getRandomString(8) + ".com";
        return format("%s@%s.com", getRandomString(8), getRandomString(8));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
       /* SecureRandom rnd = new SecureRandom();
        return rnd.nextInt(max + 1);*/
    }

    public static String getRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    //    String phoneTemplate = "+%s (%s) %s - %s -%s";
    //    return format(phoneTemplate, getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999),
    //            getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomItemFromStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);
        return stringArray[randomIndex];
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Chemistry", "Computer Science", "Commerce", "Economics",
                "Accounting", "Arts", "Social studies", "English", "History", "Physics", "Biology",
                "Hindi", "Civics"};
        return getRandomItemFromStringArray(subjects);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Music", "Reading"};
        return getRandomItemFromStringArray(hobbies);
    }

    public static String getRandomYear(){
        return String.valueOf(faker.number().numberBetween(1900,2027));
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return getRandomItemFromStringArray(months);
    }

    public static String getRandomDay() {
        return String.format("%02d",faker.number().numberBetween(1,28));

    }

    public static String getRandomAddress(){
        return faker.address().fullAddress();
    }

    public static String getRandomState(){
        String[] states = {"NCR","Rajasthan","Uttar Pradesh", "Haryana"};
        return getRandomItemFromStringArray(states);
    }

    public static String getRandomCity(String states){
        return switch (states) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> throw new IllegalArgumentException("Unknown state: " + states);
        };
    }



}
