package screens;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ListArticlesScreen {

    ElementsCollection listItem = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
    listArticle = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
    itemDescription = $$(id("org.wikipedia.alpha:id/page_list_item_description"));

    @Step("Проверяем, что список подсказок не пуст")
    public void checkSuggestionsSize() {
        listArticle.shouldHave(sizeGreaterThan(0));
    }

    @Step("Кликаем по элементу списка с текстом '{text}'")
    public void clickSuggestionWithText(String value) {
        itemDescription.findBy(text(value)).click();
    }

    @Step("выбор первой статьи")
    public ListArticlesScreen openFirstArticle() {
        listItem.first().click();
        return this;
    }
}
