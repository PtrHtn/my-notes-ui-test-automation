package pages;

import org.openqa.selenium.By;

public class DisplayNotesPage extends BasePage{

    private By noteTitleLocator(String noteTitle){return By.xpath("//h2[text()='"+noteTitle+"']");}

    public boolean noteTitleIsDisplayed(String noteTitle) {
        return isDisplayed(noteTitleLocator(noteTitle));
    }

}
