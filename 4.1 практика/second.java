class Student {
    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }

    public void printStudentInfo() {
        System.out.printf("Name: %s, Age: %d, Major: %s%n", name, age, major);
    }

    public static Student findOldestStudent(Student[] students) {
        Student oldest = students[0];
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }
        return oldest;
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 22, "Computer Science"),
            new Student("Bob", 25, "Mathematics"),
            new Student("Charlie", 23, "Physics")
        };

        for (Student student : students) {
            student.printStudentInfo();
        }

        System.out.println("Oldest Student:");
        Student oldestStudent = Student.findOldestStudent(students);
        oldestStudent.printStudentInfo();
    }
}
