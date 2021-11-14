@editing_note
Feature: Editing an existing note

  Rule: User can edit title of an existing note

    @smoke
    Scenario: User can edit title of the note
      Given John creates a new note with the title "Note A" and the content "This is my note."
      When he opens editing note mode by clicking edit button
      And changes title of the note to "Note B"
      Then displayed note should be with title "Note B" and content "This is my note."

  Rule: User can edit content of an existing note

    @smoke
    Scenario: User can edit content of the note
      Given John creates a new note with the title "Note A" and the content "This is my note."
      When he opens editing note mode by clicking edit button
      And changes content of the note to "This is my edited note."
      Then displayed note should be with title "Note A" and content "This is my edited note."