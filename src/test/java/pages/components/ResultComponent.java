package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private SelenideElement outputResults = $(".table-responsive");

    public ResultComponent checkTable (String key, String value) {
        outputResults.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
