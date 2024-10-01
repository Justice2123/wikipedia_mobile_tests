package tests;


import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.*;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("AlyonaCh")
public class WikipediaMobileTest extends TestBase {

    MainScreen mainPage = new MainScreen();
    MobileArticleScreen mobileArticlePage = new MobileArticleScreen();
    ListArticlesScreen listArticlesPage = new ListArticlesScreen();
    FirstWikiBoardingScreen firstWikiBoardingPage = new FirstWikiBoardingScreen();
    SecondWikiBoardingScreen secondWikiBoardingPage = new SecondWikiBoardingScreen();
    ThirdWikiBoardingScreen thirdWikiBoardingPage = new ThirdWikiBoardingScreen();
    FourthWikiBoardingScreen fourthWikiBoardingPage = new FourthWikiBoardingScreen();

    @Test
    @DisplayName("Проверка стартовых страниц в википедии")
    @Tag("mobile")
    @Severity(NORMAL)
    void WikiBoardingTest() {

        String firstHeader = "The Free Encyclopedia " +
                "…in over 300 languages";
        String secondHeader = "New ways to explore";
        String thirdHeader = "Reading lists with sync";
        String fourthHeader = "Data & Privacy";

        firstWikiBoardingPage
                .checkOfForwardButtonFirstPage()
                .checkHeaderFirstPage(firstHeader)
                .clickOnForwardButtonFirstPage();
        secondWikiBoardingPage
                .checkOfForwardButtonSecondPage()
                .checkHeaderSecondPage(secondHeader)
                .clickOnForwardButtonSecondPage();
        thirdWikiBoardingPage
                .checkOfForwardButtonThirdPage()
                .checkHeaderThirdPage(thirdHeader)
                .clickOnForwardButtonThirdPage();
        fourthWikiBoardingPage
                .checkDoneButtonFourthPage()
                .checkHeaderFourthPage(fourthHeader)
                .clickDoneButtonFourthPage();
    }

    @Test
    @DisplayName("Успешный поиск статьи")
    @Tag("mobile")
    @Severity(NORMAL)
    void successfulSearchTest() {
        mainPage.skipWizard();
        mainPage.clickSearchWikipedia();
        mainPage.enterSearchText("Gradle");
        listArticlesPage.checkSuggestionsSize();
    }

    @Test
    @DisplayName("Проверка открытия страницы со статьей")
    @Tag("mobile")
    @Severity(NORMAL)
    void openingArticleTest() {
        mainPage.skipWizard();
        mainPage.clickSearchWikipedia();
        mainPage.enterSearchText("Kid Cudi");
        listArticlesPage.clickSuggestionWithText("American rapper and singer (born 1984)");
        mobileArticlePage.checkArticleText("American rapper and singer (born 1984)");
    }

//    @Test
//    @DisplayName("если перестанут открываться статьи")
//    @Tag("")
//    void openArticleTest() {
//        mainPage.skipWizard();
//        mainPage.clickSearchWikipedia();
//        mainPage.enterSearchText("Kid Cudi");
//        listArticlesPage.openFirstArticle();
//        mobileArticlePage.checkErrorText("Error");
//    }
}
