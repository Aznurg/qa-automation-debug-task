package tests;

import fixtures.WebFixture;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WebFormPage;

import static com.codeborne.selenide.Selenide.*;

public class ExampleUiTest extends WebFixture {

    private WebFormPage page;

    @BeforeMethod
    void setUp() {
        page = new WebFormPage();
        open(URL);
    }

    @Test
    public void submitWebForm() {
        page
                .checkHeader()
                .fillForm("QA Automation")
                .verifyForm()
                .submit()
                .checkIfReceived();
    }
}
