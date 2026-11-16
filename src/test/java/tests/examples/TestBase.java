package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationBoxPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationBoxPage resgistrationBoxPage = new RegistrationBoxPage();

    @BeforeAll
    static void  beforeAll () {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000; //default 4000
    }
    
   /* @AfterEach
    void afterEach () {
        closeWebDriver();
    }*/

}
