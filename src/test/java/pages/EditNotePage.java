package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditNotePage extends BasePage{

    private final By editButtonLocator = By.cssSelector("a[data-cy= 'edit-note']");

    public DisplayNotesPage pressEditButton() {
        click(editButtonLocator);
        return new DisplayNotesPage();
    }
}
