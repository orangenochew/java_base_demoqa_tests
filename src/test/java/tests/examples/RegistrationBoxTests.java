package tests.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationBoxTests extends TestBase {

    @Test //все поля
    void succesfullAllFillFormTest () {
        open("/automation-practice-form");
        $("#firstName").setValue("Alter");
        $("#lastName").setValue("Ego");
        $("#userEmail").setValue("AlterEgo@space.com");
        $("#gender-radio-2").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__day--010").click();
        $(".subjects-auto-complete__input").setValue("p").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("VanGogh_1887_Selbstbildnis.jpg");
        $("#currentAddress").setValue("Alfa Centavra square, 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alter Ego"));
        $(".table-responsive").shouldHave(text("AlterEgo@space.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("10 March,1990"));
        $(".table-responsive").shouldHave(text("Physics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("VanGogh_1887_Selbstbildnis.jpg"));
        $(".table-responsive").shouldHave(text("Alfa Centavra square, 1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }

    @Test //только обязательные поля
    void succesfullRequiredFillFormTest () {
        open("/automation-practice-form");
        $("#firstName").setValue("Alter");
        $("#lastName").setValue("Ego");
        $("#gender-radio-2").click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $(".table-responsive").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alter Ego"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
    }

    @Test //негативный сценарий: не заполнен first name
    void negativeFirstNameIsNull () {
        open("/automation-practice-form");
        $("#lastName").setValue("Ego");
        $("#gender-radio-2").click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }

    @Test //негативный сценарий: не выбран gender
    void negativeGenderIsNull () {
        open("/automation-practice-form");
        $("#firstName").setValue("Alter");
        $("#lastName").setValue("Ego");
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }

    @Test //негативный сценарий: не заполнен mobile number
    void negativeMobNumberIsNull() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alter");
        $("#lastName").setValue("Ego");
        $(byName("gender")).click();
        $("#submit").click();

        $(".table-responsive").shouldNotBe(visible);
    }




}

