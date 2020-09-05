@myNotes
Feature: My Notes
  Will verify if My Notes app is working as expected

  @SmokeTest
  Scenario: User can create a new note
    Given user is on the homepage of My Notes site
    Then button "Add a note" is displayed on the page
    When user creates a new note with the title "My first note"
    And with the content "This is my first note."
    Then the note with title "My first note"
    And content "This is my first note." is displayed on the page