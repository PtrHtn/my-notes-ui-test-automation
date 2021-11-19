package pages;

import org.apache.commons.lang3.RandomStringUtils;
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

    protected boolean waitForInvisibilityOf(By locator) {
        return driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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

    protected String randomNoteTitle() {
        int numberOfCharacters = 0;
        int numberOfWords = randomNumberInRangeBetween(1, 6);
        String randomNoteTitle = "";
        for (int word = 0; word < numberOfWords; word++){
            numberOfCharacters = randomNumberInRangeBetween(1, 9);
            randomNoteTitle += randomString(numberOfCharacters) + " ";
        }
        System.out.println("\n\nRandom note title: " + randomNoteTitle);
        return randomNoteTitle;
    }

    protected String randomNoteContent() {
        int numberOfCharacters = 0;
        int numberOfWords = randomNumberInRangeBetween(1, 66);
        String randomNoteContent = "";
        for (int word = 0; word < numberOfWords; word++){
            numberOfCharacters = randomNumberInRangeBetween(1, 15);
            randomNoteContent += randomString(numberOfCharacters) + " ";
        }
        System.out.println("Random note content: " + randomNoteContent + "\n\n");
        return randomNoteContent;
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    protected int getNumberOfNotes(By noteCardLocator) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteCardLocator));
        return driver.findElements(noteCardLocator).size();
    }

    public void clear(By locator) {
        waitForVisibilityOf(locator);
        driver.findElement(locator).clear();
    }
}
