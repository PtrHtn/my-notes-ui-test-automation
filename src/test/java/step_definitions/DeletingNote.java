package step_definitions;

import io.cucumber.java.en.Given;
import pages.AddANotePage;
import pages.HomePage;

public class DeletingNote {
    @Given("John got an existing note that he does not need any more")
    public void johnGotAnExistingNoteThatHeDoesNotNeedAnyMore() {
        new HomePage().navigateTo("https://my-notes.now.sh/").and().pressAddANoteButton();
        new AddANotePage().enterNoteTitle("New note").and().enterNoteContent("Note content").then().pressSaveButton();
    }
}
