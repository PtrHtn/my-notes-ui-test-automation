package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddANotePage extends BasePage{

    private final By noteTitleFieldLocator = By.id("title");
    private final By noteContentFieldLocator = By.id("content");
    private final By buttonSaveLocator = By.cssSelector("button[type='submit']");

    public AddANotePage then() { return this; }
    public AddANotePage and() { return this; }

    public AddANotePage enterNoteTitle(String noteTitle) {
        sendKeysTo(noteTitleFieldLocator, noteTitle);
        return this;
    }

    public AddANotePage enterNoteContent(String noteContent) {
        sendKeysTo(noteContentFieldLocator, noteContent);
        return this;
    }

    public DisplayNotesPage pressSaveButton() {
        click(buttonSaveLocator);
        return new DisplayNotesPage();
    }

    public void addNumberOfRandomNotes(int numberOfNotes) {
        for (int i = 0; i < numberOfNotes; i++) {
            new HomePage().pressPlusSignButton();
            enterNoteTitle(randomNoteTitle());
            enterNoteContent(randomNoteContent());
            pressSaveButton();
        }
    }

    public void changeNoteTitleTo(String newNoteTitle) {
        clear(noteTitleFieldLocator);
        sendKeysTo(noteTitleFieldLocator, newNoteTitle);
        click(buttonSaveLocator);
    }

    public void changeNoteContentTo(String newNoteContent) {
        clear(noteContentFieldLocator);
        sendKeysTo(noteContentFieldLocator, newNoteContent);
        click(buttonSaveLocator);
    }
}
