package tests.examples;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.examples.testdata.TestData.*;

public class SimpleRegistrationBoxTests extends TestBase {

    @Test
    void succesfullOneFieldTest () {
        open("/text-box");
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));
    }

    @Test
    void negativeWrongEmailTest () {
        open("/text-box");
        $("#userEmail").setValue(firstName);
        $("#submit").click();

        $("[id=output] [id=userEmai]").shouldNotBe(visible);
    }


}
