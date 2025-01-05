package Collections.Comparable_and_Comparator;

import java.util.Arrays;
import java.util.List;

import Collections.Comparable_and_Comparator.MyComparators.StudentScoreAgeNameComparator;

public class Comparable_and_ComparatorMain {
    public static void main(String[] args) {
        // Create a list of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 22, 85.5),
            new Student("Bob", 20, 90.0),
            new Student("Charlie", 22, 85.5),
            new Student("David", 19, 92.0),
            new Student("Eve", 20, 90.0)
        );

        // Sort the students using the custom comparator
        students.sort(new StudentScoreAgeNameComparator());

        // Print the sorted list
        for (Student student : students) {
            System.out.println(student);
        }


        Student s1 = new Student("Shyam", 24, 92.8);
        Student s2 = new Student("Pallavi", 28, 95.45);

        System.out.println("Using Comparable: is s1(Shyam) object greater than s2(Pallavi): " + s1.compareTo(s2));

    }
}
