package tests.examples;

import org.junit.jupiter.api.Test;
import static tests.examples.testdata.TestData.*;

public class TextBoxTests extends TestBase {

    @Test
    void succesfullOneFieldTest () {
        textBoxPage.openPage()
                .typePermanentAddress(permanentAddress)
                .submitForm()
                .checkField("permanentAddress",permanentAddress);
    }

    @Test
    void negativeWrongEmailTest () {
        textBoxPage.openPage()
                .typeUserEmail(firstName)
                .submitForm()
                .checkOutputIsNotVisible();
    }


}
