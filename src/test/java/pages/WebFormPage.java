package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WebFormPage {

    /** В данном классе была обнаружена логическая ошибка в методе fillForm,
     * в котором были перепутаны строки, и сначала из пустого поля забиралось значение для переменной
     * expectedText, и только потом в это поле записывалось тестовое значение.
     * Также сюда была перенесена часть логики по проверке отображения заголовка страницы **/

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