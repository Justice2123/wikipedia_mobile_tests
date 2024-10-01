package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;


public class MainScreen {

    private final SelenideElement searchWikipediaButton = $(accessibilityId("Search Wikipedia")),
            searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));

    @Step("Нажимаем на кнопку поиска Wikipedia")
    public MainScreen clickSearchWikipedia() {
        searchWikipediaButton.click();
        return this;
    }

    @Step("Пропускаем визард")
    public MainScreen skipWizard() {
        back();
        return this;
    }

    @Step("Вводим текст в поисковую строку")
    public MainScreen enterSearchText(String text) {
        searchInput.sendKeys(text);
        return this;
    }
}

