package tests;

import fixtures.WebFixture;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WebFormPage;

import static com.codeborne.selenide.Selenide.*;

public class ExampleUiTest extends WebFixture {

    /** В ходе дебага проблем в этом классе не обнаружил,
     * но построение теста показалось мне неэффективным,
     * трудозатратным при расширении и "некрасивым",
     * потому принял решение сделать реструктуризацию,
     * перенести логику в пейдж-классы, а предусловия вынести
     * под соответствующую аннотацию **/

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
