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
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText(yearOfBirth)).click();
        $(".react-datepicker__month-select").$(byText(monthOfBirth)).click();
        $("[role=table]").find(byText(dayOfBirth)).click();
        $(".subjects-auto-complete__input").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath("VanGogh_1887_Selbstbildnis.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(userState).pressEnter();
        $("#react-select-4-input").setValue(userCity).pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldBe(visible);
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(hobbies));
        $(".table-responsive").shouldHave(text("VanGogh_1887_Selbstbildnis.jpg"));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(userState + " " + userCity));
    }

    @Test //только обязательные поля
    void succesfullRequiredFillFormTest () {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $(".table-responsive").shouldBe(visible);
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
    }

    @Test //негативный сценарий: не заполнен first name
    void negativeFirstNameIsNull () {
        open("/automation-practice-form");
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }

    @Test //негативный сценарий: не выбран gender
    void negativeGenderIsNull () {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }

    @Test //негативный сценарий: не заполнен mobile number
    void negativeMobNumberIsNull() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }




}

