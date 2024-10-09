package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FourthWikiBoardingScreen {
    private final SelenideElement
            doneButtonFourthPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            headerFourthPage = $(id("org.wikipedia.alpha:id/primaryTextView"));

    @Step("проверка видимости кнопки 'Начать на четвертой странице'")
    public FourthWikiBoardingScreen checkDoneButtonFourthPage() {
        doneButtonFourthPage.shouldBe(visible);
        return this;
    }

    @Step("нажатие на кнопку 'Начать на четвертой странице'")
    public FourthWikiBoardingScreen clickDoneButtonFourthPage() {
        doneButtonFourthPage.click();
        return this;
    }

    @Step("проверка правильности заголовка")
    public FourthWikiBoardingScreen checkHeaderFourthPage(String value) {
        headerFourthPage.shouldHave(text(value));
        return this;
    }
}
