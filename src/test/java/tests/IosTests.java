package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class IosTests {
    //Todo not ready yet!
//    @Test
//    @Tag("ios")
//    @DisplayName("iOS: Type a request, follow the found article's link, and check the article title")
//    void successfulSearchAndOpenArticleIosTest() {
//        step("Type search", () -> {
//            $(accessibilityId("Search Wikipedia")).click();
//            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Central processor unit");
//        });
//
//        step("Check the image", () -> {
//            $(id("org.wikipedia.alpha:id/page_list_item_image")).should(exist);
//        });
//    }
}
