@editing_note
Feature: Editing an existing note

  Rule: User can edit title of an existing note

    @in_progress
    Scenario: User can edit title of the note
      Given John creates a new note with the title "Note A" and the content "This is my note."
      When he opens editing note mode by clicking edit button
      And changes title of the note to "Note B"
      Then displayed note should be with title "Note B" and content "This is my note."
