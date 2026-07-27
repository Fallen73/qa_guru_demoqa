package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.TableResultComponent;
import utils.JsActionsHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final SelenideElement
            studentRegistrationForm = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdownList = $("#react-select-3-input"),
            cityDropdownList = $("#react-select-4-input"),
            buttonSubmit = $("#submit"),
            tableResultRegistrationForm = $(".table-responsive");

    private final String namePageStudentRegistrationForm = "Student Registration Form";

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();

    public RegistrationFormPage openPage () {
        open("/automation-practice-form");
        studentRegistrationForm.shouldHave(Condition.text(namePageStudentRegistrationForm));

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNamber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String year, String month, String day) {
        calendarInput.click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateDropdownList.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityDropdownList.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage buttonSubmitClick() {
        buttonSubmit.click();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        tableResultComponent.getTableResult(tableResultRegistrationForm, key, value);

        return this;
    }

    public RegistrationFormPage checkNegativeResult() {
        tableResultRegistrationForm.shouldBe(hidden);

        return this;
    }
}
