package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private final By buttonAddNoteLocator = By.linkText("Add a note");

    public void navigateTo(String url){
        goTo(url);
    }

}
