class LehmanCourse:
    def __init__(self, course_name, credits):
        self.course_name = course_name
        self.credits = credits
        self._student_count = 0 

    def enroll_student(self):
        self._student_count += 1

    def display_info(self):
        print(f"Course: {self.course_name} | Credits: {self.credits} | Enrolled: {self._student_count}")


course1 = LehmanCourse("CMP 269", 4)
course1.enroll_student()
course1.enroll_student()
course1.display_info()

class LabCourse(LehmanCourse):
    def __init__(self, course_name, credits, lab_fee):
        super().__init__(course_name, credits)
        self.lab_fee = lab_fee

    def display_info(self):
        print(f"Course: {self.course_name} | Credits: {self.credits} | "
              f"Enrolled: {self._student_count} | Lab Fee: ${self.lab_fee}")

lab = LabCourse("BIO 185", 4, 75)
lab.enroll_student()
lab.display_info()

class Professor:
    def get_role(self):
        return "Teaching and Research"


class Student:
    def get_role(self):
        return "Learning and Coding"


def print_role(person):
    print(person.get_role())


prof = Professor()
stud = Student()

print_role(prof)
print_role(stud)


