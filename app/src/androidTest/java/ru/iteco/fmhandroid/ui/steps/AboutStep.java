package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.viewElements.AboutElements;

public class AboutStep {
    AboutElements aboutElements = new AboutElements();

    @Step("Видимость страницы About")
    public void checkAboutPage() {
        Allure.step("Видимость страницы About");
        aboutElements.versionText.check(matches(isDisplayed()));
    }

    @Step("Кликабельность ссылки PrivacyPolicy")
    public void clickabilityPrivacyPolicy() {
        Allure.step("Кликабельность ссылки PrivacyPolicy");
        aboutElements.linkPrivacyPolicy.check(matches(isDisplayed()));
    }

    @Step("Кликабельность ссылки Terms of use")
    public void clickabilityTermsOfUse() {
        Allure.step("Кликабельность ссылки TermsOfUse");
        aboutElements.linkTermsOfUse.check(matches(isClickable()));
    }
}