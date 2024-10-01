package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class MobileArticleScreen {

    private final SelenideElement
    article = $(xpath("//android.widget.TextView[@resource-id=\"pcs-edit-section-title-description\"]")),
    wikiError = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    @Step("Проверяем наличие текста в статье")
    public void checkArticleText(String value) {
        article.shouldHave(text(value));
    }

    @Step("проверка текста ошибки")
    public MobileArticleScreen checkErrorText(String value) {
        wikiError.shouldHave(text(value));
        return this;
    }
}
