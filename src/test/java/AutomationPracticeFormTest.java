import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1980x1200";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Oleg2");
        $("#userEmail").setValue("test@test.test");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__month-select").selectOption("January");
        $$(".react-datepicker__day").findBy(text("10")).click();
        $("#subjectsInput").setValue("physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue("Test address");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Oleg Oleg2"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.test"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9999999999"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("10 January,1992"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Physics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Test address"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));
    }
}
