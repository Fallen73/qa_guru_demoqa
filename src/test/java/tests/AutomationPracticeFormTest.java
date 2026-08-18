package tests;

import config.BaseConfig;
import data.UserData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.JsActionsHelper;

import static data.UserData.*;

@DisplayName("Форма регистрации")
public class AutomationPracticeFormTest extends BaseConfig {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    JsActionsHelper jsActionsHelper = new JsActionsHelper();
    UserData userData = new UserData();

    @Test
    @Feature("Форма регистрации")
    @Story("Проверка заполнения формы регистрации")
    @Owner("fallen")
    @Tag("registration_form")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка регистрации со всеми заполненными полями")
    void fullFieldsRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage
                .setFirstName(userData.firstName)
                .setLastName(userData.lastName)
                .setEmail(userData.testEmail)
                .setGender(userData.getGender())
                .setUserNamber(userData.phoneNumber)
                .setDateOfBirth(userData.getYear(), userData.getMonth(), userData.getDay())
                .setSubjects(userData.getSubjects())
                .setHobbiesWrapper(userData.getHobbies())
                .setUploadPicture(nameFile)
                .setCurrentAddress(userData.streetAddress)
                .setState(userData.getState())
                .setCity(userData.getCity())
                .buttonSubmitClick();
        registrationFormPage
                .checkResult("Student Name", userData.firstName + " " + userData.lastName)
                .checkResult("Student Email", userData.testEmail)
                .checkResult("Gender", userData.getGender())
                .checkResult("Mobile", userData.phoneNumber)
                .checkResult("Date of Birth", userData.getDay() + " " + userData.getMonth() + "," + userData.getYear())
                .checkResult("Subjects", userData.getSubjects())
                .checkResult("Hobbies", userData.getHobbies())
                .checkResult("Picture", nameFile)
                .checkResult("Address", userData.streetAddress)
                .checkResult("State and City", userData.getState() + " " + userData.getCity());
    }

    @Test
    @Feature("Форма регистрации")
    @Story("Проверка заполнения формы регистрации")
    @Owner("fallen")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("registration_form")
    @DisplayName("Проверка регистрации с заполненными только обязательными полями")
    void onlyRequiredFieldsRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage
                .setFirstName(userData.firstName)
                .setLastName(userData.lastName)
                .setGender(userData.getGender())
                .setUserNamber(userData.phoneNumber)
                .buttonSubmitClick();
        registrationFormPage
                .checkResult("Student Name", userData.firstName + " " + userData.lastName)
                .checkResult("Gender", userData.getGender())
                .checkResult("Mobile", userData.phoneNumber);
    }

    @Test
    @Feature("Форма регистрации")
    @Story("Проверка заполнения формы регистрации")
    @Owner("fallen")
    @Severity(SeverityLevel.NORMAL)
    @Tag("registration_form")
    @DisplayName("Проверка не доступности регистрации когда все поля пустые")
    void negativeRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage.buttonSubmitClick();
        registrationFormPage.checkNegativeResult();
    }
}
