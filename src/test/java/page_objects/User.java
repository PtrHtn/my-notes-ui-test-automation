package page_objects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.CucumberHooks;

import java.util.List;

public class User {

    private final WebDriver driver = CucumberHooks.driver;
    private final WebDriverWait driverWait = CucumberHooks.driverWait;

    private final By buttonAddNoteLocator = By.linkText("Add a note");
    private final By buttonPlusSignLocator = By.cssSelector("a[title='Add Note']");
    private final By noteTitleFieldLocator = By.id("title");
    private final By noteContentFieldLocator = By.id("content");
    private final By buttonSaveLocator = By.cssSelector("button[type='submit']");
    private By noteTitleLocator(String noteTitle){return By.xpath("//h2[text()='"+noteTitle+"']");}
    private By noteContentLocator(String noteContent){return By.xpath("//p[text()='"+noteContent+"']");}

    public User user() { return this; }
    public User seeThat() { return this; }
    public User then() { return this; }
    public User and() { return this; }

    public void navigateTo(String url){
        driver.get(url);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddNoteLocator));
    }

    public void canSeeButtonWithSign(String string) {
        Assertions.assertEquals(driver.findElement(buttonAddNoteLocator).getText(), string,
                "\n\nUser can NOT see button with the sign \"" + string + "\" on the page!\n\n");
    }

    public void enterNoteTitle(String noteTitle) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteTitleFieldLocator));
        driver.findElement(noteTitleFieldLocator).sendKeys(noteTitle);
    }

    public User enterNoteContent(String noteContent) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteContentFieldLocator));
        driver.findElement(noteContentFieldLocator).sendKeys(noteContent);
        return this;
    }

    public void clickSaveButton() {
        driverWait.until(ExpectedConditions.elementToBeClickable(buttonSaveLocator));
        driver.findElement(buttonSaveLocator).click();
    }

    public void canSeeNoteTitle(String noteTitle) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteTitleLocator(noteTitle)));
        Assertions.assertEquals(noteTitle, driver.findElement(noteTitleLocator(noteTitle)).getText(),
                "\n\nCan NOT see Note with the title '" + noteTitle + "' on the page!\n\n ");
    }

    public void canSeeNoteContent(String noteContent) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteContentLocator(noteContent)));
        Assertions.assertEquals(noteContent, driver.findElement(noteContentLocator(noteContent)).getText(),
                "\n\nCan NOT see Note the content '" + noteContent + "' on the page!\n\n ");
    }

    public User clickAddANoteButton() {
        driverWait.until(ExpectedConditions.elementToBeClickable(buttonAddNoteLocator));
        driver.findElement(buttonAddNoteLocator).click();
        return this;
    }

    public User clickPlusSignButton() {
        driverWait.until(ExpectedConditions.elementToBeClickable(buttonPlusSignLocator));
        driver.findElement(buttonPlusSignLocator).click();
        return this;
    }

    public User addNewNoteByClickingOnTheButton(String buttonSign) {
        switch (buttonSign){
            case "Add a note" -> clickAddANoteButton();
            case "+" -> clickPlusSignButton();
        }
        return this;
    }
}
