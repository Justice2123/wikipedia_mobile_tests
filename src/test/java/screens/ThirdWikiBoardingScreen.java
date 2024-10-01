package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ThirdWikiBoardingScreen {
    private final SelenideElement
            forwardButtonThirdPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            headerThirdPage = $(id("org.wikipedia.alpha:id/primaryTextView"));

    @Step("Проверка видимости кнопки 'Продолжить'")
    public ThirdWikiBoardingScreen checkOfForwardButtonThirdPage() {
        forwardButtonThirdPage.shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку Продолжить на первой странице")
    public ThirdWikiBoardingScreen clickOnForwardButtonThirdPage() {
        forwardButtonThirdPage.click();
        return this;
    }

    @Step("Проверка правильности заголовка")
    public ThirdWikiBoardingScreen checkHeaderThirdPage(String value) {
        headerThirdPage.shouldHave(text(value));
        return this;
    }
}
