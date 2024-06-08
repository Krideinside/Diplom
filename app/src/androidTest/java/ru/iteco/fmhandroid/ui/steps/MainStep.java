package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.Helper.waitElement;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.viewElements.MainElements;

public class MainStep {
    MainElements mainElements = new MainElements();
    public int mainMenuButtId = R.id.main_menu_image_button;
    public int allNewsButtId = R.id.all_news_text_view;
    public int LoginOutId = R.id.authorization_image_button;
    public int quotesButtID = R.id.our_mission_image_button;

    @Step("Выход из аккаунта")
    public void logOut() {
        Allure.step("Выход из аккаунта");
        onView(withId(LoginOutId)).perform(click());
        onView(withId(android.R.id.title)).check(matches(isDisplayed()));
        onView(withId(android.R.id.title)).perform(click());
    }

    @Step("Переход в Новости через главное меню")
    public void toNewsPageByMainMenu() {
        Allure.step("Переход в Новости через главное меню");
        waitElement(mainMenuButtId);
        mainElements.mainMenuButton.perform(click());
        mainElements.newsButton.check(matches(isDisplayed()));
        mainElements.newsButton.perform(click());
    }

    @Step("Переход в Новости через ссылку All news")
    public void toNewsPageByAllNews() {
        Allure.step("Переход в Новости через ссылку All news");
        waitElement(allNewsButtId);
        mainElements.allNewsButton.perform(click());
    }

    @Step("Переход на страницу О приложении через главное меню")
    public void toAboutPage() {
        Allure.step("Переход на страницу О приложении через главное меню");
        waitElement(mainMenuButtId);
        mainElements.mainMenuButton.perform(click());
        mainElements.aboutButton.check(matches(isDisplayed()));
        mainElements.aboutButton.perform(click());
    }

    @Step("Переход на страницу Цитаты")
    public void toQuotesPage() {
        Allure.step("Переход на страницу Цитаты");
        waitElement(quotesButtID);
        mainElements.quotesButton.perform(click());
    }

    @Step("Видимость кнопки выхода из аккаунта.")
    public void logOutVisible() {
        mainElements.logOutButton.check(matches(isDisplayed()));
    }

}