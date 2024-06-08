package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.viewElements.FilterNewsElements;

public class FilterNewsStep {
FilterNewsElements filterNewsElements = new FilterNewsElements();
    @Step("Фильтр новостей")
    public void filterNews(String category) {
        Allure.step("Фильтр новостей");
        filterNewsElements.mainFilterButton.perform(click());
        filterNewsElements.categoryFilter.perform(replaceText(category));
        filterNewsElements.filterNewsButton.perform(click());
    }
}
