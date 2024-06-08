package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.catBirthday;
import static ru.iteco.fmhandroid.ui.data.Data.catDel;
import static ru.iteco.fmhandroid.ui.data.Data.catHelp;
import static ru.iteco.fmhandroid.ui.data.Data.catHoliday;
import static ru.iteco.fmhandroid.ui.data.Data.catMassage;
import static ru.iteco.fmhandroid.ui.data.Data.catNotificate;
import static ru.iteco.fmhandroid.ui.data.Data.catSalary;
import static ru.iteco.fmhandroid.ui.data.Data.catThanks;
import static ru.iteco.fmhandroid.ui.data.Data.catUnion;
import static ru.iteco.fmhandroid.ui.data.Data.dateNews;
import static ru.iteco.fmhandroid.ui.data.Data.description;
import static ru.iteco.fmhandroid.ui.data.Data.timeNews;
import static ru.iteco.fmhandroid.ui.data.Data.titleBirthday;
import static ru.iteco.fmhandroid.ui.data.Data.titleDel;
import static ru.iteco.fmhandroid.ui.data.Data.titleHelp;
import static ru.iteco.fmhandroid.ui.data.Data.titleHoliday;
import static ru.iteco.fmhandroid.ui.data.Data.titleHolidayRename;
import static ru.iteco.fmhandroid.ui.data.Data.titleMassage;
import static ru.iteco.fmhandroid.ui.data.Data.titleNotificate;
import static ru.iteco.fmhandroid.ui.data.Data.titleSalary;
import static ru.iteco.fmhandroid.ui.data.Data.titleThanks;
import static ru.iteco.fmhandroid.ui.data.Data.titleUnion;
import static ru.iteco.fmhandroid.ui.data.Data.titleUnionRename;
import static ru.iteco.fmhandroid.ui.data.Helper.generateScreenshotName;

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
import ru.iteco.fmhandroid.ui.steps.NewsEditStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
import ru.iteco.fmhandroid.ui.viewElements.EditNewsElements;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsEditTest {
    AuthStep authStep = new AuthStep();
    NewsEditStep newsEditStep = new NewsEditStep();
    MainStep mainStep = new MainStep();
    NewsStep newsStep = new NewsStep();
    EditNewsElements  editNewsElements = new EditNewsElements();

    @Before
    public void setUp() {
        authStep.checkLogInAndLogInIfNot();
        mainStep.toNewsPageByMainMenu();
        newsStep.toNewsEditingPage();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));


    @Test
    @DisplayName("Создание новой новости Профсоюз")
    public void createdNewsUnionTest() {
        newsEditStep.addNews(catUnion, titleUnion, dateNews, timeNews, description);
        newsEditStep.editNews(titleUnion);
        newsEditStep.checkNewsUnion();
    }

    @Test
    @DisplayName("Создание новой новости Объявление")
    public void createdNewsNotificateTest() {
        newsEditStep.addNews(catNotificate, titleNotificate, dateNews, timeNews, description);
        newsEditStep.editNews(titleNotificate);
        newsEditStep.checkNewsNotificate();
    }

    @Test
    @DisplayName("Создание новой новости День рождения")
    public void createdNewsBirthdayTest() {
        newsEditStep.addNews(catBirthday, titleBirthday, dateNews, timeNews, description);
        newsEditStep.editNews(titleBirthday);
        newsEditStep.checkNewsBirthday();
    }

    @Test
    @DisplayName("Создание новой новости Праздник")
    public void createdNewsHolidayTest() {
        newsEditStep.addNews(catHoliday, titleHoliday, dateNews, timeNews, description);
        newsEditStep.editNews(titleHoliday);
        newsEditStep.checkNewsHoliday();
    }

    @Test
    @DisplayName("Создание новой новости Нужна помощь")
    public void createdNewsHelpTest() {
        newsEditStep.addNews(catHelp, titleHelp, dateNews, timeNews, description);
        newsEditStep.editNews(titleHelp);
        newsEditStep.checkNewsHelp();
    }

    @Test
    @DisplayName("Создание новой новости Массаж")
    public void createdNewsMassageTest() {
        newsEditStep.addNews(catMassage, titleMassage, dateNews, timeNews, description);
        newsEditStep.editNews(titleMassage);
        newsEditStep.checkNewsMassage();
    }

    @Test
    @DisplayName("Создание новой новости Зарплата")
    public void createdNewsSalaryTest() {
        newsEditStep.addNews(catSalary, titleSalary, dateNews, timeNews, description);
        newsEditStep.editNews(titleSalary);
        newsEditStep.checkNewsSalary();
    }

    @Test
    @DisplayName("Создание новой новости Благодарность")
    public void createdNewsThanksTest() {
        newsEditStep.addNews(catThanks, titleThanks, dateNews, timeNews, description);
        newsEditStep.editNews(titleThanks);
        newsEditStep.checkNewsThanks();
    }

    @Test
    @DisplayName("Создание новой новости с пустыми полями")
    public void createdNewsWithEmptyFieldsTest() {
        newsEditStep.addNewsWithEmptyFields();
        newsEditStep.visibleErrorNotBeEmpty();
    }

    @Test
    @DisplayName("Создание новой новости с пустым заголовком")
    public void createdNewsWithEmptyTitleTest() {
        newsEditStep.addNewsWithEmptyTitle(catNotificate, dateNews, timeNews, description);
        newsEditStep.visibleErrorNotBeEmpty();
    }

    @Test
    @DisplayName("Смена заголовка")
    public void changeNewsTest() {
        newsEditStep.addNews(catUnion, titleHolidayRename, dateNews, timeNews, description);
        newsEditStep.editNews(titleHolidayRename);
        newsEditStep.changeTitleNews(titleUnionRename);
        newsEditStep.editNews(titleUnionRename);
        newsEditStep.checkTitleChange(titleUnionRename);
    }

    @Test
    @DisplayName("Удаление новости")
    public void deleteNewsTest() {
        newsEditStep.addNews(catDel, titleDel, dateNews, timeNews, description);
        newsEditStep.deleteNews(titleDel);
        newsEditStep.checkIfNoNewsWithTitle(titleDel);
    }
}

