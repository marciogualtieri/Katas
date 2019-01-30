Feature: Teacher Behavior

  Scenario: Teacher creates a quiz
     Given a teacher
      And a course iteration
      When the teacher creates a quiz
      Then the result quiz shows in the iteration list of quizzes


  Scenario: Teacher assigns quiz to student
     Given a teacher
      And a student
      And a quiz quiz1
      When the teacher assigns quiz1 to the student
      Then quiz1 shows in the student list of quizzes

  Scenario: Teacher grades student that aced all quizzes
     Given a teacher
      And a student
      And a course iteration
      And a quiz quiz1
      And a quiz quiz2
      When the student enrol to the iteration
      And the teacher assigns quiz1 to the student
      And the teacher assigns quiz2 to the student
      And the student aces quiz1
      And the student aces quiz2
      Then the student gets 1.0 grade

  Scenario: Teacher grades student that aced quiz1 but skipped quiz2
     Given a teacher
      And a student
      And a course iteration
      And a quiz quiz1
      And a quiz quiz2
      When the student enrol to the iteration
      And the teacher assigns quiz1 to the student
      And the teacher assigns quiz2 to the student
      And the student aces quiz1
      Then the student gets 0.5 grade

  Scenario: Teacher grades student that completed correctly half of quiz1 and skipped quiz2
     Given a teacher
      And a student
      And a course iteration
      And a quiz quiz1
      And a quiz quiz2
      When the student enrol to the iteration
      And the teacher assigns quiz1 to the student
      And the teacher assigns quiz2 to the student
      And the student gets right half of quiz1
      Then the student gets 0.25 grade