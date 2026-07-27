package tests;

import config.BaseConfig;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.JsActionsHelper;

public class AutomationPracticeFormTest extends BaseConfig {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    JsActionsHelper jsActionsHelper = new JsActionsHelper();

    @Test
    void fullFieldsRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage
                .setFirstName("Oleg")
                .setLastName("Oleg2")
                .setEmail("test@test.test")
                .setGender("Male")
                .setUserNamber("9999999999")
                .setDateOfBirth("1992", "January", "10")
                .setSubjects("physics")
                .setHobbiesWrapper("Music")
                .setUploadPicture("test.png")
                .setCurrentAddress("Test address")
                .setState("Haryana")
                .setCity("Panipat")
                .buttonSubmitClick();
        registrationFormPage
                .checkResult("Student Name", "Oleg Oleg2")
                .checkResult("Student Email", "test@test.test")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Date of Birth", "10 January,1992")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "test.png")
                .checkResult("Address", "Test address")
                .checkResult("State and City", "Haryana Panipat");
    }

    @Test
    void onlyRequiredFieldsRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage.setFirstName("Oleg")
                .setLastName("Oleg2")
                .setGender("Male")
                .setUserNamber("9999999999")
                .buttonSubmitClick();
        registrationFormPage
                .checkResult("Student Name", "Oleg Oleg2")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999");
    }

    @Test
    void negativeRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage.buttonSubmitClick();
        registrationFormPage.checkNegativeResult();
    }
}
