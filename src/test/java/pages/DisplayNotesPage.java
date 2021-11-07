package pages;

import org.openqa.selenium.By;

public class DisplayNotesPage extends BasePage{

    private By noteTitleLocator(String noteTitle){return By.xpath("//h2[text()='"+noteTitle+"']");}
    private By noteContentLocator(String noteContent){return By.xpath("//p[text()='"+noteContent+"']");}

    public boolean noteTitleIsDisplayed(String noteTitle) {
        return isDisplayed(noteTitleLocator(noteTitle));
    }

    public boolean noteContentIsDisplayed(String noteContent) {
        return isDisplayed(noteContentLocator(noteContent));
    }
}
