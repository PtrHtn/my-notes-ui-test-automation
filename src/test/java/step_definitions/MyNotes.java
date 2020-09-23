package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.User;

public class MyNotes extends User {

    @Given("user is on the homepage of My Notes site")
    public void userIsOnTheHomepageOfMyNotesSite() {
        user().navigateTo("https://my-notes.now.sh/");
    }

    @Then("button {string} is displayed on the page")
    public void buttonIsDisplayedOnThePage(String buttonSign) {
        user().canSeeButtonWithSign(buttonSign);
    }

    @When("user creates a new note by clicking on the button {string} with the title {string}")
    public void userCreatesANewNoteByClickingOnTheButtonWithTheTitle(String buttonSign, String noteTitle) {
        user().addNewNoteByClickingOnTheButton(buttonSign).and().enterNoteTitle(noteTitle);
    }

    @And("with the content {string}")
    public void withTheContent(String noteContent) {
        user().enterNoteContent(noteContent).and().clickSaveButton();
    }

    @Then("the note with title {string}")
    public void theNoteWithTitle(String noteTitle) {
        user().canSeeNoteTitle(noteTitle);
    }

    @And("content {string} is displayed on the page")
    public void contentIsDisplayedOnThePage(String noteContent) {
        user().canSeeNoteContent(noteContent);
    }

    @Given("user creates a note")
    public void userCreatesANote() {
        user().addRandomNote();
    }

    @When("user delete note by clicking on the delete button")
    public void userDeleteNoteByClickingOnTheDeleteButton() {
        user().deleteNote();
    }

    @Then("note is no longer displayed on the page")
    public void noteIsNoLongerDisplayedOnThePage() {
        user().canNotSeeAnyNote();
    }

    @When("user create {int} notes")
    public void userCreateNotes(int numberOfNotes) {
        user().addNumberOfRandomNotes(numberOfNotes);
    }

    @Then("{int} notes is displayed")
    public void notesIsDisplayed(int numberOfNotes) {
        user().canSeeNumberOfRandomNotes(numberOfNotes);
    }

    @And("user can delete them all")
    public void userCanDeleteThemAll() {
        user().deleteAllNotes();
    }

    @And("re-visit the page")
    public void reVisitThePage() {
        user().refreshBrowser();
    }

    @Then("{int} previously added notes are still visible")
    public void previouslyAddedNotesAreStillVisible(int numberOfNotes) {
        user().canSeeNumberOfRandomNotes(numberOfNotes);
    }

    @When("user open editing note mode by clicking edit button")
    public void userOpenEditingNoteModeByClickingEditButton() {
        user().clickEditButton();
    }

    @And("change title of the note to {string}")
    public void changeTitleOfTheNoteTo(String newNoteTitle) {
        user().changeNoteTitleTo(newNoteTitle);
    }
}
