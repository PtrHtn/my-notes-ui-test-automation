@deleting_note
Feature: Deleting an existing note

  Rule: User can delete an existing note

    @SmokeTest
    Scenario: User can delete an existing note
      Given John got an existing note that he does not need any more
      When he deletes this note
      Then this note should not be displayed any more