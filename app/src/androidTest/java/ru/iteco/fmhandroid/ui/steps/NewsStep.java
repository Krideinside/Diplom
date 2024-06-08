package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.viewElements.NewsElements;

public class NewsStep {
    NewsElements newsElements = new NewsElements();

    public int newsListId = R.id.news_list_recycler_view;

    @Step("Редактировать новость")
    public void toNewsEditingPage() {
        Allure.step("Редактировать новость");
        newsElements.editNewsButton.perform(click());
    }

    @Step("Видимость страницы Все новости")
    public void checkNewsPage() {
        Allure.step("Видимость страницы Все новости");
        newsElements.filterNewsButton.check(matches(isDisplayed()));
    }
}