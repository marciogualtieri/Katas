class Course:
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def __eq__(self, other):
        return self.name == other.name \
               and self.number == other.number

    def __hash__(self):
        return hash(self.name) \
               ^ hash(self.number)


class Iteration:
    def __init__(self, course, teacher, year, semester):
        self.course = course
        self.teacher = teacher
        self.year = year
        self.semester = semester
        self.teacher.iterations.append(self)
        self.students = []
        self.quizzes = []

    def __eq__(self, other):
        return self.course == other.course \
               and self.teacher == other.teacher \
               and self.year == other.year \
               and self.semester == other.semester

    def __hash__(self):
        return hash(self.course) \
               ^ hash(self.teacher) \
               ^ hash(self.year) \
               ^ hash(self.semester)

    def __str__(self):
        return "Iteration<course=%s, teacher=%s, year=%d, semester=%s>" % (self.course, self.teacher, self.year, self.semester)
