package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected void goTo(String url){
        driver.get(url);
    }

    protected void click(By locator) {
        waitForVisibilityOf(locator);
        driver.findElement(locator).click();
    }

    protected void sendKeysTo(By locator, String text) {
        waitForVisibilityOf(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isDisplayed(By locator){
        waitForVisibilityOf(locator);
        return driver.findElement(locator).isDisplayed();
    }

    private int randomNumberInRangeBetween(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

    private String randomString(int numberOfCharacters) {
        return RandomStringUtils.randomAlphanumeric(numberOfCharacters);
    }


}
