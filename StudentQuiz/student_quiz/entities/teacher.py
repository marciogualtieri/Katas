from student_quiz.entities.quiz import Quiz
from numpy import mean


class Teacher:
    def __init__(self, name, number):
        self.name = name
        self.number = number
        self.iterations = []

    def __eq__(self, other):
        return self.name == other.name \
               and self.number == other.number

    def __hash__(self):
        return hash(self.name) \
               ^ hash(self.number)

    def __str__(self):
        return "Teacher<name=%s, number=%s, courses=%s>" % (self.name, self.number, self.iterations)

    @staticmethod
    def create_quiz(description, iteration):
        quiz = Quiz(description, iteration)
        iteration.quizzes.append(quiz)
        return quiz

    @staticmethod
    def assign_quiz_to_student(quiz, student):
        student.quizzes.append(quiz)

    @staticmethod
    def grade_all_students(iteration):
        def grade_student(student):
            return mean([quiz.grade(student.answers) for quiz in iteration.quizzes])

        grades = [grade_student(student) for student in iteration.students]
        return dict(zip(iteration.students, grades))
