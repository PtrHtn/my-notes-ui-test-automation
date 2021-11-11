package step_definitions;

import io.cucumber.java.en.Given;
import pages.AddANotePage;
import pages.HomePage;

public class EditingNote {
    @Given("John creates a new note with the title {string} and the content {string}")
    public void johnCreatesANewNoteWithTheTitleAndTheContent(String title, String content) {
        new HomePage().pressAddANoteButton();
        new AddANotePage().enterNoteTitle(title).and().enterNoteContent(content).then().pressSaveButton();
    }
}
