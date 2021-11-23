package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.DriverManager;
import org.openqa.selenium.WebDriver;


public class CucumberHooks {
    public static WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = DriverManager.initializeDriver(System.getProperty("browser", "chrome"));
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
