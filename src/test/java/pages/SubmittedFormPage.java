package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SubmittedFormPage {

    private final SelenideElement message = $("#message");

    public void checkIfReceived() {
        message
                .shouldBe(visible)
                .shouldHave(text("Received!"));
    }

}
