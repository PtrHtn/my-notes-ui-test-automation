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
}
