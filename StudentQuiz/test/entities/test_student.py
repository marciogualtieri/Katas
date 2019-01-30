from unittest import TestCase
from copy import deepcopy
from test.test_utils import *


class TestStudent(TestCase):
    def setUp(self):
        self.student = deepcopy(TEST_STUDENT1)

    def test_student_answer_question(self):
        self.student.answer_question(TEST_QUIZ1_QUESTION1, TEST_OPTION_A)
        self.assertEqual(self.student.answers, {TEST_QUIZ1_QUESTION1: TEST_OPTION_A})
