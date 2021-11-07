package step_definitions;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class CreatingNote {

    @Given("John is on the homepage of My Notes site")
    public void johnIsOnTheHomepageOfMyNotesSite() {
        new HomePage().navigateTo("https://my-notes.now.sh/");
    }

}
