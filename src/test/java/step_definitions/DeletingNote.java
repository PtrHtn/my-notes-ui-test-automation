package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddANotePage;
import pages.DisplayNotesPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class DeletingNote {
    @Given("John got an existing note that he does not need any more")
    public void johnGotAnExistingNoteThatHeDoesNotNeedAnyMore() {
        new HomePage().navigateTo(Properties.PROJECT_URL).and().pressAddANoteButton();
        new AddANotePage().enterNoteTitle("New note").and().enterNoteContent("Note content").then().pressSaveButton();
    }

    @When("he deletes this note")
    public void heDeletesThisNote() {
        new HomePage().pressXSignButton();
    }

    @Then("this note should not be displayed any more")
    public void thisNoteShouldNotBeDisplayedAnyMore() {
        assertTrue(new DisplayNotesPage().noNoteIsDisplayed());
        assertTrue(new HomePage().addANoteButtonIsDisplayed());
    }
}
