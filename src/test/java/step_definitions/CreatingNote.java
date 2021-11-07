package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddANotePage;
import pages.DisplayNotesPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class CreatingNote {

    @Given("John is on the homepage of My Notes site")
    public void johnIsOnTheHomepageOfMyNotesSite() {
        new HomePage().navigateTo("https://my-notes.now.sh/");
    }

    @When("he chooses to create a new note by clicking on the Add a note button")
    public void heChoosesToCreateANewNoteByClickingOnTheAddANoteButton() {
        new HomePage().pressAddANoteButton();
        new AddANotePage().enterNoteTitle("New note").and().enterNoteContent("Note content").then().pressSaveButton();
    }

    @Then("newly created note should be displayed on the page")
    public void newlyCreatedNoteShouldBeDisplayedOnThePage() {
        assertTrue(new DisplayNotesPage().noteTitleIsDisplayed("New note"));
        assertTrue(new DisplayNotesPage().noteContentIsDisplayed("Note content"));
    }

}