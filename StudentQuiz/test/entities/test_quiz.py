from unittest import TestCase
from copy import deepcopy
from test.test_utils import *


class TestQuiz(TestCase):
    def setUp(self):
            self.student = deepcopy(TEST_STUDENT1)
            self.quiz = deepcopy(TEST_QUIZ1)

    def test_grade_quiz(self):
        self._student_gets_1_out_of_2_in_quiz()
        self.assertEqual(self.quiz.grade(self.student.answers), 0.25)

    def test_add_questions_to_quiz(self):
        question = Question("Some Question", [Option("Yes"), Option("No")], Option("Yes"), self.quiz)
        self.quiz.add_question(question)
        self.assertTrue(self, question in self.quiz.questions)

    def _student_gets_1_out_of_2_in_quiz(self):
        self.student.answer_question(TEST_QUIZ1_QUESTION1, TEST_CORRECT_OPTION)
