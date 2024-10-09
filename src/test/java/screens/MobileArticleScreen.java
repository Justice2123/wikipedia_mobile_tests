package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class MobileArticleScreen {

    private final SelenideElement
    article = $(xpath("//android.widget.TextView[@resource-id=\"pcs-edit-section-title-description\"]"));

    @Step("проверяем наличие текста в статье")
    public void checkArticleText(String value) {
        article.shouldHave(text(value));
    }
}
