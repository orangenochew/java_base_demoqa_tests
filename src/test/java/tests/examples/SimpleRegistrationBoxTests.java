package tests.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleRegistrationBoxTests extends TestBase {

    @Test
    void succesfullOneFieldTest () {
        open("/text-box");
        $("#permanentAddress").setValue("Test street, 5");
        $("#submit").click();

        $("[id=output] [id=permanentAddress]").shouldHave(text("Test street, 5"));
    }

    @Test
    void negativeWrongEmailTest () {
        open("/text-box");
        $("#userEmail").setValue("qq");
        $("#submit").click();

        $("[id=output] [id=userEmai]").shouldNotBe(visible);
    }


}
