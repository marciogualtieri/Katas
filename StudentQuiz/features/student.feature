Feature: Student Behavior

  Scenario: Student enrols to course iteration
     Given a student
      And a course iteration
      When the student enrol to the iteration
      Then iteration shows in the students list of iterations


  Scenario: Student answers a question
     Given a student
      And a question
      When the student answers the question
      Then an answer shows in the students list of answers