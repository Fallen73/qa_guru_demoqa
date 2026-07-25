package config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseConfig {

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1980x1200";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
}
