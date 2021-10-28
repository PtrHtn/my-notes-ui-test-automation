package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.CucumberHooks;

public class BasePage {
    private final WebDriver driver = CucumberHooks.driver;
    private final WebDriverWait driverWait = CucumberHooks.driverWait;

}
