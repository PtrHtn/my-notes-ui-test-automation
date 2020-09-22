package page_objects;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.CucumberHooks;

public class User {

    private final WebDriver driver = CucumberHooks.driver;
    private final WebDriverWait driverWait = CucumberHooks.driverWait;

    private final By buttonAddNoteLocator = By.linkText("Add a note");
    private final By buttonPlusSignLocator = By.cssSelector("a[title='Add Note']");
    private final By noteTitleFieldLocator = By.id("title");
    private final By noteContentFieldLocator = By.id("content");
    private final By buttonSaveLocator = By.cssSelector("button[type='submit']");
    private final By buttonDeleteLocator = By.cssSelector("button[data-testid='delete-button']");
    private final By noteCardLocator = By.cssSelector("li[class='note-card']");
    private final By editButtonLocator = By.cssSelector("a[data-cy= 'edit-note']");
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

    private int randomNumberInRangeBetween(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

    private String randomString(int numberOfCharacters) {
        return RandomStringUtils.randomAlphanumeric(numberOfCharacters);
    }

    private String randomNoteTitle() {
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

    private String randomNoteContent() {
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

    public void addRandomNote() {
        clickPlusSignButton();
        enterNoteTitle(randomNoteTitle());
        enterNoteContent(randomNoteContent());
        clickSaveButton();
        driverWait.until(ExpectedConditions.numberOfElementsToBe(noteCardLocator, 1));
    }

    public void deleteNote() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(buttonDeleteLocator));
        driver.findElement(buttonDeleteLocator).click();
    }

    public void canNotSeeAnyNote() {
        driverWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(noteCardLocator)));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddNoteLocator));
    }

    public void addNumberOfRandomNotes(int numberOfNotes) {
        clickPlusSignButton();
        for (int i = 0; i < numberOfNotes; i++) {
            clickPlusSignButton();
            enterNoteTitle(randomNoteTitle());
            enterNoteContent(randomNoteContent());
            clickSaveButton();
        }
    }

    public void canSeeNumberOfRandomNotes(int numberOfNotes) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteCardLocator));
        Assertions.assertEquals(numberOfNotes, driver.findElements(noteCardLocator).size(),
                "\n\nNumber of displayed notes is not as expected!\n\n");
    }

    public void deleteAllNotes() {
        for (int i = 0; i<driver.findElements(buttonDeleteLocator).size(); i++) {
            deleteNote();
        }
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteCardLocator));
    }

    public void clickEditButton() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(editButtonLocator));
        driver.findElement(editButtonLocator).click();
    }

    public void changeNoteTitleTo(String newNoteTitle) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(noteTitleFieldLocator));
        driver.findElement(noteTitleFieldLocator).clear();
        driver.findElement(noteTitleFieldLocator).sendKeys(newNoteTitle);
        clickSaveButton();
    }
}
