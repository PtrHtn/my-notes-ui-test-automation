package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private final By buttonAddNoteLocator = By.linkText("Add a note");
    private final By buttonPlusSignLocator = By.cssSelector("a[title='Add Note']");
    private final By buttonDeleteLocator = By.cssSelector("button[data-testid='delete-button']");
    private final By editButtonLocator = By.cssSelector("a[data-cy= 'edit-note']");

    public HomePage and() { return this; }

    public HomePage navigateTo(String url){
        goTo(url);
        return this;
    }

    public AddANotePage pressAddANoteButton() {
        click(buttonAddNoteLocator);
        return new AddANotePage();
    }

    public AddANotePage pressPlusSignButton() {
        click(buttonPlusSignLocator);
        return new AddANotePage();
    }

    public void pressXSignButton() {
        click(buttonDeleteLocator);
    }

    public boolean addANoteButtonIsDisplayed() {
        return isDisplayed(buttonAddNoteLocator);
    }

    public AddANotePage pressEditButton() {
        click(editButtonLocator);
        return new AddANotePage();
    }
}
