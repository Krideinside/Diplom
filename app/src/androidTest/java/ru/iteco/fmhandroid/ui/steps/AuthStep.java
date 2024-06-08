package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.data.Helper.checkToast;
import static ru.iteco.fmhandroid.ui.data.Helper.waitElement;
import static ru.iteco.fmhandroid.ui.data.Helper.waitUntilVisible;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.viewElements.AuthElements;

public class AuthStep {
    AuthElements authElements = new AuthElements();

    public int enterButtonId = R.id.enter_button;

    MainStep mainStep = new MainStep();

    @Step("Валидная авторизация")
    public void login(String login, String password){
        Allure.step("Валидная авторизация");
        waitElement(enterButtonId);
        authElements.fieldLogin.perform(replaceText(login));
        authElements.fieldPassword.perform(replaceText(password));
        authElements.enterButton.check(matches(isDisplayed())).perform(click());
    }

    @Step("Вход в аккаунт, если не авторизован")
    public void checkLogInAndLogInIfNot() {
        if (logIn()) {
            login(validLogin, validPassword);
        }
    }

    @Step("Выход из аккаунта")
    public void checkLogOutAndLogOutIfNot() {
        if (logOut()) {
            mainStep.logOut();
        }
    }

    @Step("Тест всплывающего сообщения при пустом логине и пароле")
    public void emptyLoginAndPassword() {
        Allure.step("Тест всплывающего сообщения при пустом логине и пароле");
        waitUntilVisible(checkToast(R.string.empty_login_or_password, true));
    }

    @Step("Тест всплывающего сообщения при невалидном логине и пароле")
    public void wrongLoginAndPassword() {
        Allure.step("Тест всплывающего сообщения при невалидном логине и пароле");
        waitUntilVisible(checkToast(R.string.wrong_login_or_password, true));
    }

    public boolean logIn() {
        boolean check =false;
        try {
            waitElement(enterButtonId);
            authElements.fieldLogin.check(matches(isDisplayed()));
            check = true;
            return check;
        } catch (NoMatchingViewException e) {
            check = false;
            return check;
        } finally {
            return check;
        }
    }

    public boolean logOut() {
        boolean check =false;
        try {
            waitElement(mainStep.LoginOutId);
            mainStep.logOutVisible();
            check = true;
            return check;
        } catch (NoMatchingViewException e) {
            check = false;
            return check;
        } finally {
            return check;
        }
    }

}