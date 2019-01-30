class Quiz:
    def __init__(self, description, iteration):
        self.description = description
        self.iteration = iteration
        self.iteration.quizzes.append(self)
        self.questions = []

    def __eq__(self, other):
        return self.description == other.description \
               and self.iteration == other.iteration

    def __hash__(self):
        return hash(self.description) \
               ^ hash(self.iteration)

    def __str__(self):
        return "Quiz<description=%s, course=%s, questions=%s>" % (self.description, self.iteration, self.questions)

    def add_question(self, question):
        self.questions.append(question)

    def add_questions(self, questions):
        self.questions += questions

    def grade(self, answers):
        result = 0.0
        for question in self.questions:
            if question in answers.keys() and answers[question] == question.answer:
                result += 1
        return result / len(self.questions)
