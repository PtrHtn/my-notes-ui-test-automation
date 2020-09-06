@myNotes
Feature: My Notes
  Will verify if My Notes app is working as expected

  Background: User can navigate to My Notes app homepage
    Given user is on the homepage of My Notes site
    Then button "Add a note" is displayed on the page

  @SmokeTest
  Scenario: User can create a new note by clicking on the button "Add a note"
    When user creates a new note by clicking on the button "Add a note" with the title "My first note"
    And with the content "This is my first note."
    Then the note with title "My first note"
    And content "This is my first note." is displayed on the page

  @SmokeTest
  Scenario: User can create a new note by clicking on the button "+"
    When user creates a new note by clicking on the button "+" with the title "My second note"
    And with the content "This is my second note."
    Then the note with title "My second note"
    And content "This is my second note." is displayed on the page