@myNotes
Feature: My Notes
  Will verify if My Notes app is working as expected

  Background: User can navigate to My Notes app homepage
    Given user is on the homepage of My Notes site
    Then button "Add a note" is displayed on the page

  @MultiTest
  Scenario Outline: User can create a new note
    When user creates a new note by clicking on the button <buttonSign> with the title <noteTitle>
    And with the content <noteContent>
    Then the note with title <noteTitle>
    And content <noteContent> is displayed on the page

    Examples:
      | buttonSign   | noteTitle        | noteContent               |
      | "Add a note" | "My first note"  | "This is my first note."  |
      | "+"          | "My second note" | "This is my second note." |

  @SmokeTest
  Scenario: User can delete note
    Given user creates a note
    When user delete note by clicking on the delete button
    Then note is no longer displayed on the page

  @MultiTest
  Scenario Outline: User can create multiple notes and delete them
    When user create <numberOfNotes> notes
    Then <numberOfNotes> notes is displayed
    And user can delete them all

    Examples:
      | numberOfNotes |
      | 10            |
      | 20            |
      | 30            |