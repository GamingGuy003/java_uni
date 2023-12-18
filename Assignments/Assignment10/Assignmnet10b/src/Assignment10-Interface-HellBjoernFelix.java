class Main {
    public static void main(String[] args) {
        StudentInterface sInt; // can be made into a new object implementing the student interface just like student, tastudent etc do, except without creating a new class

        Student student = new Student(); // creates a new student

        sInt = null; // assigns null to the student interface, which effectively doesnt change anything, as the inital assignment just made it null aswell
        sInt = student; // this works, since student implements the interface. sInt is now an instance of student, since sInt can contain any object implementing the interface
        // student = sInt; // this does not work since student can only contain a student, not the interface which student implements
        // sInt = new StudentInteface(); // this does not work as interfaces cannot contain a constructor
        sInt.display(); // this works due to the prior assignment of sInt = student, where student implements the interfaces display method. otherwise, this would fail as the interface only contains the method head with no actual code

        TAStudent ta_test = new TAStudent();
        PhDStudent phd_test = new PhDStudent();
        Student student_test = new Student();

        // case 1: this still executes the phd students display method since student can contain any object that extends the student class
        student_test = phd_test;
        student_test.display(); // executes phdstudents display method

        student_test = new Student();
        // case 2 still executes the phd students display function. this works for the same reason as the previous case
        student_test = (Student) phd_test;
        student_test.display(); // executes phdstudents display method

        student_test = new Student();
        // case 3: this does not work, since tastudent can only contain objects that either extend tastudent or are themselves of class tastudent, since it may have implemented additional methods which the basic student class does not have.
        // ta_test = student_test;
        ta_test.display(); // executes tastudents display method

        // case 4: this does not work either for the same reason as explained in case 3. casting any non null value for student to a tastudent will yield a classcastexception
        // ta_test = (TAStudent) student_test;
        ta_test.display(); // executes tastudents display method

        // case 3: this works since phdstudent is higher in the hierarchy and tastudent can either contain other tastudent objects or objects which are derived from it like phdstudent
        ta_test = phd_test;
        ta_test.display(); // executes phd students display method
    }
}

interface StudentInterface {
    public void display();
}

class Student implements StudentInterface {
    @Override
    public void display() {
        System.out.println("I am a regular student");
    }
}

class TAStudent extends Student {
    @Override
    public void display() {
        System.out.println("I am a TA");
    }
}

class PhDStudent extends TAStudent {
    @Override
    public void display() {
        System.out.println("I am a PhD Student");
    }
}