package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsActionsHelper {

    public void removeFixedElements() {
        executeJavaScript("document.getElementById('fixedban')?.remove()");
        executeJavaScript("document.querySelector('footer')?.remove()");
    }
}
