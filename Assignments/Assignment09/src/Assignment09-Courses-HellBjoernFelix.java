import java.util.Scanner;

class Courses {
    public static void main(String[] args) {
        Teacher[] teachers = {
            new Teacher("Teacher1", "TeacherStreet 1", "1", new Course[]{}),
            new Teacher("Teacher2", "TeacherStreet 2", "2", new Course[]{}),
            new Teacher("Teacher3", "TeacherStreet 3", "3", new Course[]{}),
        };

        Course[] courses = {
            new Course("Course1", 1, "Normal", 1, teachers[0]),
            new Course("Course2", 2, "Normal", 2, null),
            new Course("Course3", 3, "Normal", 3, null),
            new Course("Course4", 4, "Normal", 4, teachers[0]),
            new Course("Course5", 5, "Normal", 5, null),
            new Course("Course6", 6, "Normal", 6, null),
            new Course("Course7", 7, "Normal", 7, teachers[0]),
            new Course("Course8", 8, "Normal", 8, null),
            new Course("Course9", 9, "Normal", 9, null),
        };

        courses[1].setTeacher(teachers[1]);
        courses[2].setTeacher(teachers[2]);
        courses[4].setTeacher(teachers[1]);
        courses[5].setTeacher(teachers[2]);
        courses[7].setTeacher(teachers[1]);
        courses[8].setTeacher(teachers[2]);

        Student[] students = {
            new Student("Student1", "1", new Course[]{courses[0], courses[4], courses[8]}),
            new Student("Student2", "2", new Course[]{courses[1], courses[3], courses[7]}),
            new Student("Student3", "3", new Course[]{courses[2], courses[5], courses[6]}),
        };

        System.out.println(teachers[0].info());
        System.out.println(students[0].info());
        System.out.println(courses[0].info());

        Scanner sc = new Scanner(System.in);
        boolean searching = true;
        while (searching) {
            System.out.print("Output teacher with name: ");
            String teacher = sc.nextLine();
            for (Teacher teacherObj: teachers) {
                if (teacherObj.getName().equals(teacher)) {
                    String[] coursesInfo = new String[teacherObj.getCourses().length];
                    for (int i = 0; i < teacherObj.getCourses().length; i++) {
                        coursesInfo[i] = teacherObj.getCourses()[i].info();
                    }
                    System.out.println("Courses taught by " + teacher + ": " + String.join(", ", coursesInfo));
                    searching = false;
                    break;
                }
            }
            if (searching) {
                System.out.println("Teacher not found, try again");
            }
        }
        searching = true;

        while (searching) {
            System.out.print("Output students courses with name: ");
            String student = sc.nextLine();
            for (Student studentObj: students) {
                if (studentObj.getName().equals(student)) {
                    String[] coursesInfo = new String[studentObj.getCourses().length];
                    for (int i = 0; i < studentObj.getCourses().length; i++) {
                        coursesInfo[i] = studentObj.getCourses()[i].info();
                    }
                    System.out.println("Courses taken by " + student + ": " + String.join(", ", coursesInfo));
                    searching = false;
                    break;
                }
            }
            if (searching) {
                System.out.println("Student not found, try again");
            }
        }

        searching = true;

        while (searching) {
            System.out.print("Output students taking course with name: ");
            String course = sc.nextLine();
            for (Course courseObj: courses) {
                // Find correct course
                if (courseObj.getName().equals(course)) {
                    // find student taking course
                    for (Student studentObj: students) {
                        for (Course studentCourse: studentObj.getCourses()) {
                            if (studentCourse.equals(courseObj)) {
                                System.out.println("Student taking course " + course + ": " +studentObj.getName());
                                searching = false;
                                break;
                            }
                        }

                    }
                }

            }

            if (searching) {
                System.out.println("Course not found, try again");
            }
        }

    }
}

class Student {
    private String name;
    private String ID;
    private Course[] courses;

    Student(String name, String ID, Course[] courses) {
        this.setName(name);
        this.setID(ID);
        this.setCourses(courses);
        System.out.println("New Student created");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public Course[] getCourses() {
        return courses;
    }

    public String info() {
        String[] coursesInfo = new String[this.courses.length];
        for (int i = 0; i < this.courses.length; i++) {
            coursesInfo[i] = this.courses[i].info();
        }
        return ("Student " + this.name + " with ID " + this.ID + " attends the following courses: " + String.join("; ", coursesInfo));
    }
}

class Teacher {
    private String name;
    private String address;
    private String ID;
    private Course[] courses;

    Teacher(String name, String address, String ID, Course[] courses) {
        this.setName(name);
        this.setAddress(address);
        this.setID(ID);
        this.setCourses(courses);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        Course[] tmp = new Course[this.courses.length + 1];
        for (int i = 0; i < this.courses.length; i++) {
            tmp[i] = this.courses[i];
        }
        tmp[tmp.length - 1] = course;
        this.courses = tmp;
    }

    public String info() {
        String[] coursesInfo = new String[this.courses.length];
        for (int i = 0; i < this.courses.length; i++) {
            coursesInfo[i] = this.courses[i].info();
        }
        return ("Teacher " + this.name + ", living at " + this.address + " with ID " + this.ID + " teaches the following courses: " + String.join("; ", coursesInfo));
    }
}

class Course {
    private String name;
    private int credits;
    private String examType;
    private int hoursPerWeek;
    private Teacher teacher;

    Course(String name, int credits, String examType, int hoursPerWeek, Teacher teacher) {
        this.setName(name);
        this.setCredits(credits);
        this.setExamType(examType);
        this.setHoursPerWeek(hoursPerWeek);
        this.setTeacher(teacher);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamType() {
        return examType;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        if (teacher != null) {
            this.teacher.addCourse(this);
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String info() {
        return ("Course  " + this.name + " with " + this.credits + " credits, " + this.examType + " exam type, " + this.hoursPerWeek + " h/week and the teacher " + teacher.getName());
    }
}