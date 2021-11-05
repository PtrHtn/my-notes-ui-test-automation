package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private final By buttonAddNoteLocator = By.linkText("Add a note");
    private final By buttonPlusSignLocator = By.cssSelector("a[title='Add Note']");

    public void navigateTo(String url){
        goTo(url);
    }

    public AddANotePage pressAddANoteButton() {
        click(buttonAddNoteLocator);
        return new AddANotePage();
    }

    public AddANotePage pressPlusSignButton() {
        click(buttonPlusSignLocator);
        return new AddANotePage();
    }

}
