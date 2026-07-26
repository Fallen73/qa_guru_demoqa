package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final SelenideElement
            yearSelect = $(".react-datepicker__year-select"),
            monthSelect = $(".react-datepicker__month-select");
    private final ElementsCollection daySelect = $$(".react-datepicker__day");

    public void setDate(String year, String month, String day) {
        yearSelect.selectOption(year);
        monthSelect.selectOption(month);
        daySelect.findBy(text(day)).click();
    }
}
