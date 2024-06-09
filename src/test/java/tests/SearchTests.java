package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @Tag("Android")
    @DisplayName("Android: Type a request and check the suggestions' drop-down menu is not blank")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

//    @Test
//    @Tag("Android")
//    @DisplayName("Android: Type a request, follow the found article's link, and check the article title")
//    void successfulSearchAndOpenArticleAndroidTest() {
//        step("Type search", () -> {
//            $(accessibilityId("Search Wikipedia")).click();
//            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Central processor unit");
//        });
//
//        step("Click the requested article", () -> {
//            $(accessibilityId("TODO: ADD A SPECIFIC ID HERE")).click(); //todo
//        });
//
//        step("Check the article title", () -> {
//            $(id("TODO: ADD A SPECIFIC ID HERE")).should(exist); //todo
//        });
//    }

    @Test
    @Tag("iOS")
    @DisplayName("iOS: Type a request, follow the found article's link, and check the article title")
    void successfulSearchAndOpenArticleIosTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Random-access memory");
        });

        step("Click the requested article", () -> {
            $(accessibilityId("TODO: ADD A SPECIFIC ID HERE")).click(); //todo
        });

        step("Check the article title", () -> {
            $(id("TODO: ADD A SPECIFIC ID HERE")).should(exist); //todo
        });
    }
}