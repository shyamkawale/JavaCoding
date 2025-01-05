package Collections.Comparable_and_Comparator;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + score;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.score, o.getScore());
    }
}
