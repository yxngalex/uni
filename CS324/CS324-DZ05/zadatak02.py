class Person:
    def __init__(self, name, surname):
        self.name = name
        self.surname = surname


class Student(Person):
    def __init__(self, name: str, surname: str, index: int, major: str, passed_exams: dict):
        super(Student, self).__init__(name, surname)
        self.index = index
        self.major = major
        self.passed_exams = passed_exams

    def exams(self):
        return list(self.passed_exams.keys())

    def curriculum(self, other: 'Student'):
        if self.major == other.major:
            return True
        return False

    def common_exams(self, other: 'Student'):
        return list(set(self.exams()).intersection(set(other.exams())))


def main():
    s1 = Student("Aleksa", "Cekić", 4173, "Software Engineer", {"CS324": 10})
    s2 = Student("Uros", "Milovanović", 4191, "Software Engineer", {"CS324": 10})

    print("Student {} and student {} do{} have the same major".format(s1.name, s2.name,
                                                                      "" if s1.curriculum(s2) else " not"))
    print("Student {} has passed {} exam(s) ".format(s1.name, len(s1.exams())))

    print("Student {} has passed {} exam(s) ".format(s2.name, len(s1.exams())))

    print("Both students{} have common passed exams: {}".format("" if len(s1.common_exams(s2)) > 0 else " don't",
                                                                s1.common_exams(s2)))


if __name__ == "__main__":
    main()
