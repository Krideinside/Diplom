package ru.iteco.fmhandroid.ui.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
    private static LocalDateTime date = LocalDateTime.now();
    private static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm");

    public static final String validLogin = "login2";
    public static final String validPassword = "password2";
    public static final String invalidLogin = "wronglogin";
    public static final String invalidPassword = "wrongpassword";
    public static final String specLogin = "!@#$%^&*";
    public static final String oneSymbolLogin = "a";
    public static final String cyrillicLogin = "логин";
    public static final String registerValidLogin = "lOgIn2";
    public static final String emptyLogin = "";
    public static final String emptyPassword = "";
    public static final String specSymbolPassword = "!@#$%^&*";
    public static final String oneSymbolPassword = "a";
    public static final String registerValidPassword = "pASsWoRd2";
    public static final String cyrillicPassword = "пароль";
    public static final String catNotificate = "Объявление";
    public static final String catMassage = "Массаж";
    public static final String catThanks = "Благодарность";
    public static final String catHelp = "Нужна помощь";
    public static final String catBirthday = "День рождения";
    public static final String catHoliday = "Праздник";
    public static final String catSalary = "Зарплата";
    public static final String catUnion = "Профсоюз";
    public static final String catDel = "День рождения";
    public static final String titleNotificate = "Notificate";
    public static final String titleDel = "BirthdayDelete";
    public static final String titleMassage = "Massage";
    public static final String titleThanks = "Thanks";
    public static final String titleHelp = "Help";
    public static final String titleBirthday = "Birthday";
    public static final String titleHoliday = "Holiday";
    public static final String titleHolidayRename = "HolidayNewName";
    public static final String titleSalary = "Salary";
    public static final String titleUnion = "Union";
    public static final String titleUnionRename = "UnionRename";
    public static final String titleNotificateFilt = "NotificateFilt";
    public static final String titleMassageFilt = "MassageFilt";
    public static final String titleThanksFilt = "ThanksFilt";
    public static final String titleHelpFilt = "HelpFilt";
    public static final String titleBirthdayFilt = "BirthdayFilt";
    public static final String titleHolidayFilt = "HolidayFilt";
    public static final String titleSalaryFilt = "SalaryFilt";
    public static final String titleUnionFilt = "UnionFilt";
    public static final String dateNews = formatDate.format(date);
    public static final String timeNews = formatTime.format(date);
    public static final String description = "description";
}