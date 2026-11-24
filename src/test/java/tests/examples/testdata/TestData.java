package tests.examples.testdata;

import static utils.RandomUtils.*;

public class TestData {

    public static String
            firstName = getRandomString(10),
            lastName = getRandomString(10),
            userEmail = getRandomEmail(8),
            gender = getRandomGender(),
            userNumber = getRandomPhone(),
            subject = getRandomSubject(),
            hobbies = getRandomHobbies(),
            yearOfBirth = getRandomYear(),
            monthOfBirth = getRandomMonth(),
            dayOfBirth = getRandomDay(),
            picture = "VanGogh_1887_Selbstbildnis.jpg",
            currentAddress = getRandomAddress(),
            userState = getRandomState(),
            userCity = getRandomCity(userState),
            permanentAddress = getRandomAddress();

}
