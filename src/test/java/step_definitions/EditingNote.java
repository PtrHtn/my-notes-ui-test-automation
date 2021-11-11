package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AddANotePage;
import pages.EditNotePage;
import pages.HomePage;

public class EditingNote {
    @Given("John creates a new note with the title {string} and the content {string}")
    public void johnCreatesANewNoteWithTheTitleAndTheContent(String title, String content) {
        new HomePage().pressAddANoteButton();
        new AddANotePage().enterNoteTitle(title).and().enterNoteContent(content).then().pressSaveButton();
    }

    @When("he opens editing note mode by clicking edit button")
    public void heOpensEditingNoteModeByClickingEditButton() {
        new EditNotePage().pressEditButton();
    }

    @And("changes title of the note to {string}")
    public void changesTitleOfTheNoteTo(String newTitle) {
        new AddANotePage().changeNoteTitle(newTitle);
    }
}
