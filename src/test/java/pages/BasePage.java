package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.CucumberHooks;

public class BasePage {
    private final WebDriver driver = CucumberHooks.driver;
    private final WebDriverWait driverWait = CucumberHooks.driverWait;

    private void waitForVisibilityOf(By locator) {
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception exception) {
            System.out.println("Something went wrong in waitForVisibilityOf method: " + exception);
        }
    }

    public void click(By locator) {
        waitForVisibilityOf(locator);
        driver.findElement(locator).click();
    }

}
