package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.TableResultComponent;
import io.qameta.allure.Step;

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

    @Step("Открыть страницу регистрации")
    public RegistrationFormPage openPage () {
        open("/automation-practice-form");
        studentRegistrationForm.shouldHave(Condition.text(namePageStudentRegistrationForm));

        return this;
    }

    @Step("Заполнить поле First Name")
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполнить поле Last Name")
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполнить поле Email")
    public RegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Выбрать значение в Gender")
    public RegistrationFormPage setGender(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Заполнить поле Mobile")
    public RegistrationFormPage setUserNamber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Заполнить поле Date of Birth")
    public RegistrationFormPage setDateOfBirth(String year, String month, String day) {
        calendarInput.click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    @Step("Заполнить поле Subjects")
    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбрать значение в Hobbies")
    public RegistrationFormPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Загрузить файл")
    public RegistrationFormPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Заполнить поле Current Address")
    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Заполнить поле State")
    public RegistrationFormPage setState(String value) {
        stateDropdownList.setValue(value).pressEnter();

        return this;
    }

    @Step("Заполнить поле City")
    public RegistrationFormPage setCity(String value) {
        cityDropdownList.setValue(value).pressEnter();

        return this;
    }

    @Step("Нажать на кнопку Submit")
    public RegistrationFormPage buttonSubmitClick() {
        buttonSubmit.click();

        return this;
    }

    @Step("Проверить результат заполненного поля {key}")
    public RegistrationFormPage checkResult(String key, String value) {
        tableResultComponent.getTableResult(tableResultRegistrationForm, key, value);

        return this;
    }

    @Step("Проверить отутствие заполненной регистрационной офрмы")
    public RegistrationFormPage checkNegativeResult() {
        tableResultRegistrationForm.shouldBe(hidden);

        return this;
    }
}
