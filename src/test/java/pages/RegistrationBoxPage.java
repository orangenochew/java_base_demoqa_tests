package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationBoxPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();

    //Elements
    public SelenideElement firstNameInput = $("#firstName");
    public SelenideElement lastNameInput = $("#lastName");
    public SelenideElement userEmailInput = $("#userEmail");
    public SelenideElement genderCheckBox = $("#genterWrapper");
    public SelenideElement userNumberInput = $("#userNumber");
    public SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    public SelenideElement subjectInput = $(".subjects-auto-complete__input");
    public SelenideElement uploadPictureButton = $("#uploadPicture");
    public SelenideElement currentAddressInput = $("#currentAddress");
    public SelenideElement submitButton = $("#submit");
    public SelenideElement stateCityContainer = $("#stateCity-wrapper");
    public SelenideElement stateSelect = $("#state");
    public SelenideElement citySelect = $("#city");
    public SelenideElement outputResults = $(".table-responsive");


    //Actions
    public RegistrationBoxPage openPage () {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationBoxPage typeFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationBoxPage typeLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationBoxPage typeUserEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationBoxPage setGender (String value) {
        genderCheckBox.$(byText(value)).click();
        return this;
    }

    public RegistrationBoxPage typeUserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationBoxPage setDateOfBirth (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day,month,year);
        return this;
    }

    public RegistrationBoxPage setHobbies (String value) {
        hobbiesCheckBox.$(byText(value)).click();
        return this;
    }

    public RegistrationBoxPage setSubjects (String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationBoxPage uploadPicture (String value) {
        uploadPictureButton.uploadFromClasspath(value);
        return this;
    }

    public RegistrationBoxPage typeCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationBoxPage setState (String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    public RegistrationBoxPage setCity (String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    public RegistrationBoxPage setStateAndCity (String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public RegistrationBoxPage submitForm () {
        submitButton.click();
        return this;
    }

    public RegistrationBoxPage checkModalWindow () {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationBoxPage checkOutput () {
        outputResults.shouldBe(visible);
        return this;
    }

    public RegistrationBoxPage checkOutputIsNotVisible() {
        outputResults.shouldNotBe(visible);
        return this;
    }

    public RegistrationBoxPage checkTable (String key, String value) {
        resultComponent.checkTable(key,value);
        return this;
    }




}
