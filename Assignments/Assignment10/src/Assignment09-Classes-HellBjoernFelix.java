class Main {
    public static void main(String[] args) {
        Student s = new Student("Stud");
        TAStudent t = new TAStudent("TAStud", new String[]{"task1", "task2"});
        PhDStudent p = new PhDStudent("PhStud", new String[]{"task1", "task2"}, "computer science");

        System.out.println(s.display());
        System.out.println(t.display());
        System.out.println(p.display());
    }
}

class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    public String display() {
        return("Student with name " + this.name);
    }
}

class TAStudent extends Student {
    protected String[] tasks;

    TAStudent(String name, String[] tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public String display() {
        return(super.display() + " and tasks " + String.join(", ", this.tasks));
    }
}

class PhDStudent extends TAStudent {
    protected String degree;
    PhDStudent(String name, String[] tasks, String degree) {
        super(name, tasks);
        this.degree = degree;
    }

    public String display() {
        return(super.display() + " and degree " + this.degree);
    }
}