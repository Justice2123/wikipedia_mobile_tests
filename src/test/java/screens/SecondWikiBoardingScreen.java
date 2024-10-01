package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SecondWikiBoardingScreen {
    private final SelenideElement
            forwardButtonSecondPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            headerSecondPage = $(id("org.wikipedia.alpha:id/primaryTextView"));

    @Step("Проверка видимости кнопки 'Продолжить'")
    public SecondWikiBoardingScreen checkOfForwardButtonSecondPage() {
        forwardButtonSecondPage.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Продолжить на первой странице")
    public SecondWikiBoardingScreen clickOnForwardButtonSecondPage() {
        forwardButtonSecondPage.click();
        return this;
    }

    @Step("Проверка правильности заголовка")
    public SecondWikiBoardingScreen checkHeaderSecondPage(String value) {
        headerSecondPage.shouldHave(text(value));
        return this;
    }
}
