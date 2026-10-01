package fixtures;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import reporting.Report;

public abstract class WebFixture {

    protected final static String URL = "https://www.selenium.dev/selenium/web/web-form.html";

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        SessionId sessionId = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId();
        Selenide.closeWebDriver();
        Report.attachSessionInfo(sessionId);
    }
}