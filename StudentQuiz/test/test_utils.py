from student_quiz.entities.option import Option
from student_quiz.entities.question import Question
from student_quiz.entities.quiz import Quiz
from student_quiz.entities.teacher import Teacher
from student_quiz.entities.student import Student
from student_quiz.entities.iteration import Course
from student_quiz.entities.iteration import Iteration
from student_quiz.entities.semester import Semester

TEST_TEACHER1 = Teacher("Test Teacher", 1)
TEST_COURSE1 = Course(name="Test Course", number=1)
TEST_ITERATION1 = Iteration(course=TEST_COURSE1, teacher=TEST_TEACHER1, year=2019, semester=Semester.SPRING)
TEST_STUDENT1 = Student(name="Fist Student", number=1)
TEST_STUDENT2 = Student(name="Second Student", number=2)

TEST_OPTION_A = Option(description="Option A")
TEST_OPTION_B = Option(description="Option B")
TEST_OPTION_C = Option(description="Option C")
TEST_CORRECT_OPTION = Option(description="Correct Option")
TEST_OPTIONS = [TEST_OPTION_A, TEST_OPTION_B, TEST_OPTION_C, TEST_CORRECT_OPTION]

TEST_QUIZ1 = Quiz(description="First Quiz", iteration=TEST_ITERATION1)
TEST_QUIZ1_QUESTION1 = Question(description="First Question",
                                options=TEST_OPTIONS,
                                answer=TEST_CORRECT_OPTION, quiz=TEST_QUIZ1)
TEST_QUIZ1_QUESTION2 = Question(description="Second Question",
                                options=TEST_OPTIONS,
                                answer=TEST_CORRECT_OPTION, quiz=TEST_QUIZ1)
TEST_QUIZ1_QUESTION3 = Question(description="Third Question",
                                options=TEST_OPTIONS,
                                answer=TEST_CORRECT_OPTION, quiz=TEST_QUIZ1)
TEST_QUIZ1_QUESTION4 = Question(description="Fourth Question",
                                options=TEST_OPTIONS,
                                answer=TEST_CORRECT_OPTION, quiz=TEST_QUIZ1)
TEST_QUESTIONS_QUIZ1 = [TEST_QUIZ1_QUESTION1, TEST_QUIZ1_QUESTION2, TEST_QUIZ1_QUESTION3, TEST_QUIZ1_QUESTION4]
TEST_QUIZ1.add_questions(TEST_QUESTIONS_QUIZ1)

TEST_QUIZ2 = Quiz(description="Second Quiz", iteration=TEST_ITERATION1)
TEST_QUIZ2_QUESTION1 = Question(description="Fifth Question",
                                options=TEST_OPTIONS,
                                answer=TEST_CORRECT_OPTION, quiz=TEST_QUIZ2)
TEST_QUIZ2_QUESTION2 = Question(description="Sixth Question",
                                options=TEST_OPTIONS,
                                answer=TEST_CORRECT_OPTION, quiz=TEST_QUIZ2)
TEST_QUESTIONS_QUIZ2 = [TEST_QUIZ2_QUESTION1, TEST_QUIZ2_QUESTION2]
TEST_QUIZ2.add_questions(TEST_QUESTIONS_QUIZ2)
