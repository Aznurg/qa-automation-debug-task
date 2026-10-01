package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WebFormPage {

    private final SelenideElement textInput = $("[name='my-text']");
    private final SelenideElement checkbox = $("[name='my-check']");
    private String expectedText;

    public WebFormPage fillForm(String text) {
        textInput.setValue(text);
        expectedText = textInput.getValue();
        checkbox
                .setSelected(true)
                .shouldBe(checked);
        return this;
    }

    public WebFormPage verifyForm() {
        textInput.shouldHave(value(expectedText));
        return this;
    }

    public SubmittedFormPage submit() {
        $("button").click();
        return new SubmittedFormPage();
    }

    public WebFormPage checkHeader() {
        $("h1")
                .shouldBe(visible)
                .shouldHave(text("Web form"));
        return this;
    }
}