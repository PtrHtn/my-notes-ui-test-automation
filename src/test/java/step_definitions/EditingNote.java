package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddANotePage;
import pages.DisplayNotesPage;
import pages.EditNotePage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class EditingNote {
    @Given("John creates a new note with the title {string} and the content {string}")
    public void johnCreatesANewNoteWithTheTitleAndTheContent(String title, String content) {
        new HomePage().navigateTo(Properties.PROJECT_URL).and().pressAddANoteButton();
        new AddANotePage().enterNoteTitle(title).and().enterNoteContent(content).then().pressSaveButton();
    }

    @When("he opens editing note mode by clicking edit button")
    public void heOpensEditingNoteModeByClickingEditButton() {
        new EditNotePage().pressEditButton();
    }

    @And("changes title of the note to {string}")
    public void changesTitleOfTheNoteTo(String newTitle) {
        new AddANotePage().changeNoteTitleTo(newTitle);
    }

    @And("changes content of the note to {string}")
    public void changesContentOfTheNoteTo(String newContent) {
        new AddANotePage().changeNoteContentTo(newContent);
    }

    @Then("displayed note should be with title {string} and content {string}")
    public void displayedNoteShouldBeWithTitleAndContent(String title, String content) {
        assertTrue(new DisplayNotesPage().noteTitleIsDisplayed(title));
        assertTrue(new DisplayNotesPage().noteContentIsDisplayed(content));
    }

}
