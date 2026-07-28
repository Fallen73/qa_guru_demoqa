package tests;

import config.BaseConfig;
import data.UserData;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.JsActionsHelper;

import static data.UserData.*;

public class AutomationPracticeFormTest extends BaseConfig {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    JsActionsHelper jsActionsHelper = new JsActionsHelper();
    UserData userData = new UserData();

    @Test
    void fullFieldsRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(testEmail)
                .setGender(userData.getGender())
                .setUserNamber(phoneNumber)
                .setDateOfBirth(userData.getYear(), userData.getMonth(), userData.getDay())
                .setSubjects(userData.getSubjects())
                .setHobbiesWrapper(userData.getHobbies())
                .setUploadPicture(nameFile)
                .setCurrentAddress(streetAddress)
                .setState(userData.getState())
                .setCity(userData.getCity())
                .buttonSubmitClick();
        registrationFormPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", testEmail)
                .checkResult("Gender", userData.getGender())
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", userData.getDay() + " " + userData.getMonth() + "," + userData.getYear())
                .checkResult("Subjects", userData.getSubjects())
                .checkResult("Hobbies", userData.getHobbies())
                .checkResult("Picture", nameFile)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", userData.getState() + " " + userData.getCity());
    }

    @Test
    void onlyRequiredFieldsRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userData.getGender())
                .setUserNamber(phoneNumber)
                .buttonSubmitClick();
        registrationFormPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userData.getGender())
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeRegistrationFormTest() {
        registrationFormPage.openPage();
        jsActionsHelper.removeFixedElements();
        registrationFormPage.buttonSubmitClick();
        registrationFormPage.checkNegativeResult();
    }
}
