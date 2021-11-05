@creating_note
Feature: Creating a new note

  Rule: User can create a new note

    @smoke
    Scenario: Creating a new note by using "Add a note" button
      Given John is on the homepage of My Notes site
      When he chooses to create a new note by clicking on the Add a note button
      Then newly created note should be displayed on the page

    @smoke
    Scenario: Creating a new note by using "+" sign
      Given John is on the homepage of My Notes site
      When he chooses to create a new note by clicking on the + sign
      Then newly created note should be displayed on the page

  Rule: After user re-visit the page previously added notes are displayed

    @smoke
    Scenario: After re-opening the web app previously added notes are displayed
      Given John is on the homepage of My Notes site
      When he create 3 notes
      And re-open the web app
      Then 3 previously added notes should be displayed