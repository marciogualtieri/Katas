class Option:
    def __init__(self, description):
        self.description = description

    def __eq__(self, other):
        return self.description == other.description

    def __hash__(self):
        return hash(self.description)

    def __str__(self):
        return "Option<description=%s>" % self.description
