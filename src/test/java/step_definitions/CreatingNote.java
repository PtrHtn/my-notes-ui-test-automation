package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AddANotePage;
import pages.HomePage;

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

}
