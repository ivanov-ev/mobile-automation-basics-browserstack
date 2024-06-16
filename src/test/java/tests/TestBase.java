package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    @Step("Init step")
    static void beforeAll() {
        System.setProperty("env", System.getProperty("env", "android"));
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;//this is a Selenide workaround; 'null' means 'testing an app, not a browser page'
        Configuration.timeout = 15000;//30000 is recommended; I shortened it to reduce the time spent on Browserstack
    }

    @BeforeEach
    @Step("Add listener")
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());//Adds logging
        open();//Yet another Selenide workaround. It means 'one should open the app first before testing it'
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}