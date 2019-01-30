class Question:
    def __init__(self, description, options, answer, quiz):
        self.description = description
        self.options = options
        self.answer = answer
        self.quiz = quiz

    def __eq__(self, other):
        return self.description == other.description \
               and self.options == other.options \
               and self.answer == other.answer \
               and self.quiz == other.quiz

    def __hash__(self):
        return hash(self.description) \
               ^ hash(tuple(self.options)) \
               ^ hash(self.answer) \
               ^ hash(self.quiz)

    def __str__(self):
        return "Question<description=%s, options=%s, answer=%s, quiz=%s>" \
               % (self.description, self.options, self.answer, self.quiz)
