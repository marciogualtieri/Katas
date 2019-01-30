class Student:
    def __init__(self, name, number):
        self.name = name
        self.number = number
        self.quizzes = []
        self.answers = {}
        self.iterations = []

    def __eq__(self, other):
        return self.name == other.name \
               and self.number == other.number

    def __hash__(self):
        return hash(self.name) ^ hash(self.number)

    def answer_question(self, question, option):
        self.answers[question] = option

    def enrol_to_course_iteration(self, iteration):
        self.iterations.append(iteration)
        iteration.students.append(self)
