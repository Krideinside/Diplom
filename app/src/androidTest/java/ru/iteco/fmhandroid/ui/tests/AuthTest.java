package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.Data.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.Data.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.invalidPassword;
import static ru.iteco.fmhandroid.ui.data.Data.oneSymbolLogin;
import static ru.iteco.fmhandroid.ui.data.Data.oneSymbolPassword;
import static ru.iteco.fmhandroid.ui.data.Data.registerValidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.registerValidPassword;
import static ru.iteco.fmhandroid.ui.data.Data.specLogin;
import static ru.iteco.fmhandroid.ui.data.Data.specSymbolPassword;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.data.Data.cyrillicLogin;
import static ru.iteco.fmhandroid.ui.data.Data.cyrillicPassword;
import static ru.iteco.fmhandroid.ui.data.Helper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.data.Helper.waitElement;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {

    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();

    @Before
    public void setUp(){

        authStep.checkLogOutAndLogOutIfNot();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));


    @Test
    @DisplayName("Авторизация с вводом валидных данных")
    public void validAuthTest() {
        authStep.login(validLogin, validPassword);
        waitElement(mainStep.LoginOutId);
        mainStep.logOutVisible();
    }

    @Test
    @DisplayName("Незарегистрированный логин")
    public void invalidLoginTest() {
        authStep.login(invalidLogin, validPassword);
        authStep.wrongLoginAndPassword();
    }

    @Test
    @DisplayName("Логин на кириллице")
    public void cyrillicLoginTest() {
        authStep.login(cyrillicLogin,validPassword);
        authStep.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Символы в поле логин")
    public void specSymbolLoginTest() {
        authStep.login(specLogin, validPassword);
        authStep.wrongLoginAndPassword();
    }

    @Test
    @DisplayName("Разный регистр в поле логин")
    public void registerLoginTest() {
        authStep.login(registerValidLogin, validPassword);
        authStep.wrongLoginAndPassword();
    }

    @Test
    @DisplayName("Пустое поле логин")
    public void emptyLoginTest() {
        authStep.login(emptyLogin,emptyPassword);
        authStep.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Одна буква в поле логин")
    public void oneSymbolLoginTest() {
        authStep.login(oneSymbolLogin, validPassword);
        authStep.wrongLoginAndPassword();
    }

    @Test
    @DisplayName("Незарегистрированный пароль")
    public void invalidPasswordAuthorizationTest() {
        authStep.login(validLogin, invalidPassword);
        authStep.wrongLoginAndPassword();
    }

    @Test
    @DisplayName("Пароль на кириллице")
    public void cyrillicPasswordTest() {
        authStep.login(validLogin, cyrillicPassword);
        authStep.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Символы в поле пароль")
    public void specSymbolPasswordTest() {
        authStep.login(validLogin, specSymbolPassword);
        authStep.wrongLoginAndPassword();
    }

    @Test
    @DisplayName("Разный регистр в поле пароль")
    public void registerPasswordTest() {
        authStep.login(validLogin, registerValidPassword);
        authStep.wrongLoginAndPassword();
    }

    @Test
    @DisplayName("Пустое поле пароль")
    public void emptyPasswordTest() {
        authStep.login(validLogin, emptyPassword);
        authStep.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Одна буква в поле пароль")
    public void oneSymbolPasswordTest() {
        authStep.login(validLogin, oneSymbolPassword);
        authStep.wrongLoginAndPassword();
    }
}