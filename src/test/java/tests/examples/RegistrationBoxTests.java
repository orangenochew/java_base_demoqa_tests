package tests.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
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
                .checkFields("Student Name", firstName + " " + lastName)
                .checkFields("Student Email", userEmail)
                .checkFields("Gender", gender)
                .checkFields("Mobile", userNumber)
                .checkFields("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkFields("Subjects", subject)
                .checkFields("Hobbies", hobbies)
                .checkFields("Picture", picture)
                .checkFields("Current Address", currentAddress)
                .checkFields("State and City", userState + " " + userCity);
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
                .checkFields("Student Name", firstName + " " + lastName)
                .checkFields("Gender", gender)
                .checkFields("Mobile", userNumber);
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

