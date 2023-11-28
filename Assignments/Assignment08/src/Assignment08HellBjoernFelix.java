import java.util.Scanner;

public class Assignment08HellBjoernFelix {
    public static void main(String[] args) {
        new StudentList().run();
    }
}

class StudentList {
    Student[] studentList = {};
    Scanner sc = new Scanner(System.in);

    public void run() {
        addStudent();
        mainMenu();
    }

    void mainMenu() {
        String[] options = {
                "Add student",
                "List grades",
                "List students",
                "List student grades",
                "Search by name",
                "Search by grade",
                "Exit"
        };
        while (true) {
            switch (getUserChoice(options)) {
                case "Add student" -> addStudent();
                case "List grades" -> listGrades();
                case "List students" -> listStudents();
                case "List student grades" -> listStudentGrades();
                case "Search by name" -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    searchByName(name);
                }
                case "Search by grade" -> {
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    searchByGrade(grade);
                }
                case "Exit" -> System.exit(0);
            }
        }
    }

    void addStudent() {
        String[] options = {
                "Add",
                "Back"
        };
        while (true) {
            listStudentGrades();
            switch (getUserChoice(options)) {
                case "Add" -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Grade: ");
                    String grade = sc.nextLine();
                    Student studentNew = new Student(name, grade);
                    Student[] tmpStudentList = new Student[studentList.length + 1];
                    System.arraycopy(studentList, 0, tmpStudentList, 0, studentList.length);
                    tmpStudentList[studentList.length] = studentNew;
                    studentList = tmpStudentList;
                    sort();
                }
                case "Back" -> {
                    return;
                }
            }
        }
    }

    void listGrades() {
        for (Student student: studentList) {
            System.out.println(student.getGrade());
        }
    }

    void listStudents() {
        for (Student student: studentList) {
            System.out.println(student.getName());
        }
    }

    void listStudentGrades() {
        for (Student student: studentList) {
            System.out.println(student);
        }
    }

    void searchByName(String name) {
        String found = "";
        for (Student student: studentList) {
            if (student.getName().equals(name)) {
                found += student + "\n";
            }
        }
        if (found.isEmpty()) {
            System.out.println("No student found matching criteria");
        } else {
            System.out.print(found);
        }
    }

    void searchByGrade(String grade) {
        String found = "";
        for (Student student: studentList) {
            if (student.getGrade().equals(grade)) {
                found += student + "\n";
            }
        }
        if (found.isEmpty()) {
            System.out.println("No student found matching criteria");
        } else {
            System.out.print(found);
        }
    }

    void sort() {
        Student tmp;
        for (int i = 0; i < studentList.length; i++) {
            for (int j = i + 1; j < studentList.length; j++) {

                // to compare one string with other strings
                if (studentList[i].getName().compareTo(studentList[j].getName()) > 0) {
                    // swapping
                    tmp = studentList[i];
                    studentList[i] = studentList[j];
                    studentList[j] = tmp;
                }
            }
        }
    }

    int readChoice(int min, int max) {
        while (true) {
            System.out.print("(" + min + " - " + max + ")> ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    System.out.println("-----");
                    return choice -1;
                }
                System.out.println("Input out of range");
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }
    }

    void printChoices(String[] choices) {
        for (int i = 1; i <= choices.length; i++) {
            System.out.println(i + " " + choices[i - 1]);
        }
    }

    String getUserChoice(String[] content) {
        System.out.println("-----");
        printChoices(content);
        return content[readChoice(1, content.length)];
    }
}

class Student {
    private String name = "";
    private String grade = "";

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + grade;
    }
}