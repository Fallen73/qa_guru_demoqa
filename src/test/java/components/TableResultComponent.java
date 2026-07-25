package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class TableResultComponent {

    public void getTableResult(SelenideElement table, String key, String value) {
        table.$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}
