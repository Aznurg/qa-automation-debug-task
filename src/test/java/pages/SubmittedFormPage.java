package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SubmittedFormPage {

    /** Эту страницу можно было и не создавать, но я решил всё-таки сделать,
     * чтобы тесты были более читаемыми и понятными, плюс, если логика работы страницы изменится,
     * будет менее проблемно адаптировать АТ под эти изменения **/

    private final SelenideElement message = $("#message");

    public void checkIfReceived() {
        message
                .shouldBe(visible)
                .shouldHave(text("Received!"));
    }

}
