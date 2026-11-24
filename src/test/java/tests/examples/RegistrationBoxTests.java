package tests.examples;

import org.junit.jupiter.api.Test;


import static tests.examples.testdata.TestData.*;

public class RegistrationBoxTests extends TestBase {

    @Test //все поля
    void succesfullAllFillFormTest () {
        resgistrationBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(gender)
                .typeUserNumber(userNumber)
               .setDateOfBirth(dayOfBirth,monthOfBirth,yearOfBirth)
                .setHobbies(hobbies)
                .setSubjects(subject)
                .uploadPicture(picture)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(userState,userCity)
                .submitForm()

                .checkModalWindow()
                .checkOutput()
                .checkTable("Student Name", firstName + " " + lastName)
                .checkTable("Student Email", userEmail)
                .checkTable("Gender", gender)
                .checkTable("Mobile", userNumber)
                .checkTable("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkTable("Subjects", subject)
                .checkTable("Hobbies", hobbies)
                .checkTable("Picture", picture)
                .checkTable("Address", currentAddress)
                .checkTable("State and City", userState + " " + userCity);
    }

    @Test //только обязательные поля
    void succesfullRequiredFillFormTest () {
        resgistrationBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkModalWindow()
                .checkOutput()
                .checkTable("Student Name", firstName + " " + lastName)
                .checkTable("Gender", gender)
                .checkTable("Mobile", userNumber);
    }

    @Test //негативный сценарий: не заполнен first name
    void negativeFirstNameIsNull () {
        resgistrationBoxPage.openPage()
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkOutputIsNotVisible();
    }

    @Test //негативный сценарий: не выбран gender
    void negativeGenderIsNull () {
        resgistrationBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkOutputIsNotVisible();
    }

    @Test //негативный сценарий: не заполнен mobile number
    void negativeMobNumberIsNull() {
        resgistrationBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .submitForm()

                .checkOutputIsNotVisible();
    }



}

