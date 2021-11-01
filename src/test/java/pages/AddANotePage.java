package pages;

import org.openqa.selenium.By;

public class AddANotePage extends BasePage{

    private final By noteTitleFieldLocator = By.id("title");
    private final By noteContentFieldLocator = By.id("content");
    private final By buttonSaveLocator = By.cssSelector("button[type='submit']");

    public AddANotePage then() { return this; }

}
