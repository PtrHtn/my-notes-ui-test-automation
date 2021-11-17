package pages;

import org.openqa.selenium.By;

public class DisplayNotesPage extends BasePage{

    private By noteTitleLocator(String noteTitle){return By.xpath("//h2[text()='"+noteTitle+"']");}
    private By noteContentLocator(String noteContent){return By.xpath("//p[text()='"+noteContent+"']");}
    private final By noteCardLocator = By.cssSelector("li[class='note-card']");

    public boolean noteTitleIsDisplayed(String noteTitle) {
        return isDisplayed(noteTitleLocator(noteTitle));
    }

    public boolean noteContentIsDisplayed(String noteContent) {
        return isDisplayed(noteContentLocator(noteContent));
    }

    public int numberOfNotesDisplayedOnThePage(){
        return getNumberOfNotes(noteCardLocator);
    }

    public boolean noNoteIsDisplayed() {
        return waitForInvisibilityOf(noteCardLocator);
//        driverWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(noteCardLocator)));
//        driverWait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddNoteLocator));
    }
}
