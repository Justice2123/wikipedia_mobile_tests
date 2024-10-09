package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FirstWikiBoardingScreen {
    private final SelenideElement
            forwardButtonFirstPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            headerFirstPage = $(id("org.wikipedia.alpha:id/primaryTextView"));

    @Step("проверка видимости кнопки 'Продолжить'")
    public FirstWikiBoardingScreen checkOfForwardButtonFirstPage() {
        forwardButtonFirstPage.shouldBe(visible);
        return this;
    }

    @Step("нажатие на кнопку 'Продолжить на первой странице'")
    public FirstWikiBoardingScreen clickOnForwardButtonFirstPage() {
        forwardButtonFirstPage.click();
        return this;
    }

    @Step("проверка правильности заголовка")
    public FirstWikiBoardingScreen checkHeaderFirstPage(String value) {
        headerFirstPage.shouldHave(text(value));
        return this;
    }
}
