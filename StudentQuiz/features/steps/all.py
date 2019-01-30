from behave import *

from test.test_utils import *
from copy import deepcopy

test_student = None
test_teacher = None
test_iteration = None

test_question = None

test_quiz1 = None
test_quiz2 = None

result_quiz = None


@given('a student')
def step_impl(context):
    global test_student
    test_student = deepcopy(TEST_STUDENT1)


@given('a teacher')
def step_impl(context):
    global test_teacher
    test_teacher = deepcopy(TEST_TEACHER1)


@given('a course iteration')
def step_impl(context):
    global test_iteration
    test_iteration = deepcopy(TEST_ITERATION1)


@given('a question')
def step_impl(context):
    global test_question
    test_question = deepcopy(TEST_QUIZ1_QUESTION1)


@given('a quiz quiz1')
def step_impl(context):
    global test_quiz1
    test_quiz1 = deepcopy(TEST_QUIZ1)


@given('a quiz quiz2')
def step_impl(context):
    global test_quiz2
    test_quiz2 = deepcopy(TEST_QUIZ2)


@when('the student enrol to the iteration')
def step_impl(context):
    test_student.enrol_to_course_iteration(test_iteration)


@when('the student answers the question')
def step_impl(context):
    test_student.answer_question(test_question, TEST_CORRECT_OPTION)


@when('the teacher creates a quiz')
def step_impl(context):
    global result_quiz
    result_quiz = test_teacher.create_quiz("Some Quiz", test_iteration)


@when('the teacher assigns quiz1 to the student')
def step_impl(context):
    test_teacher.assign_quiz_to_student(test_quiz1, test_student)


@when('the teacher assigns quiz2 to the student')
def step_impl(context):
    test_teacher.assign_quiz_to_student(test_quiz2, test_student)


@when('the student aces quiz1')
def step_impl(context):
    for question in test_quiz1.questions:
        test_student.answer_question(question, TEST_CORRECT_OPTION)


@when('the student aces quiz2')
def step_impl(context):
    for question in test_quiz2.questions:
        test_student.answer_question(question, TEST_CORRECT_OPTION)


@when('the student gets right half of quiz1')
def step_impl(context):
    test_student.answer_question(test_quiz1.questions[0], TEST_CORRECT_OPTION)
    test_student.answer_question(test_quiz1.questions[1], TEST_CORRECT_OPTION)


@then('iteration shows in the students list of iterations')
def step_impl(context):
    assert test_iteration in test_student.iterations


@then('an answer shows in the students list of answers')
def step_impl(context):
    assert test_question in test_student.answers and test_student.answers[test_question] == TEST_CORRECT_OPTION


@then('quiz1 shows in the iteration list of quizzes')
def step_impl(context):
    assert test_quiz1 in test_iteration.quizzes


@then('quiz2 shows in the iteration list of quizzes')
def step_impl(context):
    assert test_quiz2 in test_iteration.quizzes


@then('the result quiz shows in the iteration list of quizzes')
def step_impl(context):
    assert result_quiz in test_iteration.quizzes


@then('quiz1 shows in the student list of quizzes')
def step_impl(context):
    assert test_quiz1 in test_student.quizzes


@then('quiz2 shows in the student list of quizzes')
def step_impl(context):
    assert test_quiz2 in test_student.quizzes


@then('the student gets {grade:f} grade')
def step_impl(context, grade):
    result = test_teacher.grade_all_students(test_iteration)
    print(result)
    print(test_student)
    print(result[test_student])
    assert test_student in result and result[test_student] == grade
