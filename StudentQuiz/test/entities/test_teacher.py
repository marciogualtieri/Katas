from unittest import TestCase
from copy import deepcopy
from test.test_utils import *


class TestTeacher(TestCase):
    def setUp(self):
        self.student1 = deepcopy(TEST_STUDENT1)
        self.student2 = deepcopy(TEST_STUDENT2)
        self.iteration = deepcopy(TEST_ITERATION1)
        self.student1.enrol_to_course_iteration(self.iteration)
        self.student2.enrol_to_course_iteration(self.iteration)
        self.teacher = self.iteration.teacher
        self.quiz1 = deepcopy(TEST_QUIZ1)
        self.quiz2 = deepcopy(TEST_QUIZ2)

    def test_create_quiz(self):
        quiz = self.teacher.create_quiz("Some Quiz", self.iteration)
        self.assertTrue(quiz in self.iteration.quizzes)

    def test_teacher_assign_quiz_to_student(self):
        self.teacher.assign_quiz_to_student(self.quiz1, self.student1)
        self.assertEqual(self.student1.quizzes, [self.quiz1])

    def test_teacher_grade_students(self):
        self._teacher_assigns_quiz1_and_quiz2_to_student()
        self._student1_gets_3_out_of_4_in_quiz1()
        self._student1_gets_1_out_of_2_in_quiz2()
        self._student2_gets_2_out_of_2_in_quiz2()
        self.assertEqual(self.teacher.grade_all_students(self.iteration),
                         {self.student1: 0.625, self.student2: 0.5})

    def _teacher_assigns_quiz1_and_quiz2_to_student(self):
        self.teacher.assign_quiz_to_student(self.quiz1, self.student1)
        self.teacher.assign_quiz_to_student(self.quiz2, self.student1)

    def _student1_gets_1_out_of_2_in_quiz2(self):
        self.student1.answer_question(TEST_QUIZ2_QUESTION1, TEST_CORRECT_OPTION)

    def _student1_gets_3_out_of_4_in_quiz1(self):
        self.student1.answer_question(TEST_QUIZ1_QUESTION1, TEST_CORRECT_OPTION)
        self.student1.answer_question(TEST_QUIZ1_QUESTION2, TEST_CORRECT_OPTION)
        self.student1.answer_question(TEST_QUIZ1_QUESTION3, TEST_CORRECT_OPTION)

    def _student2_gets_2_out_of_2_in_quiz2(self):
        self.student2.answer_question(TEST_QUIZ2_QUESTION1, TEST_CORRECT_OPTION)
        self.student2.answer_question(TEST_QUIZ2_QUESTION2, TEST_CORRECT_OPTION)
