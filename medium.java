import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + "%)";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 72),
            new Student("Charlie", 90),
            new Student("David", 65),
            new Student("Eve", 78)
        );

        List<String> topStudents = students.stream()
            .filter(student -> student.marks > 75)
            .sorted(Comparator.comparingDouble(student -> student.marks))
            .map(student -> student.name)
            .collect(Collectors.toList());
        
        System.out.println("Top Students: " + topStudents);
    }
}
