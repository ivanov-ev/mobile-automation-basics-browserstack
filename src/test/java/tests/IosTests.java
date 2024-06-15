package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

import static io.qameta.allure.Allure.step;

public class IosTests extends TestBase {
    @Test
    @DisplayName("iOS: BitBarSampleApp: Click the 'Biometric authentication' button, and then click the 'Go Back' button")
    @Tag("ios")
    //The app link: https://github.com/bitbar/test-samples/blob/master/apps/ios/BitBarSampleApp.ipa
    //The app is uploaded to Browserstack using the following curl:
    //curl -u "my.browserstack.user:my.browserstack.key" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file="@C:\temp\BitBarSampleApp.ipa"
    //This curl returned the "app_url" in the format "bs://...."
    void openBioAuthAndReturnTest() {
        step("Click the 'Biometric authentication' button", () -> {
            $(byName("Biometric authentication")).lastChild().click();
        });
        step("Check whether it is possible to return to the previous screen", () -> {
            $(byName("Go back")).should(exist);
            $(byName("Go back")).click();
            $(byName("Biometric authentication")).lastChild().should(exist);
        });
    }
}
