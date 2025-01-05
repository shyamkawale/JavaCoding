package Collections.Comparable_and_Comparator;

import java.util.Comparator;

public class MyComparators {
    public static class StudentScoreAgeNameComparator implements Comparator<Student>{
        @Override
        public int compare(Student s1, Student s2) {
            // if(s1.getScore() < s2.getScore()){
            //     return 1;
            // }
            // else if(s1.getScore() > s2.getScore()){
            //     return -1;
            // }
            // else{
            //     if(s1.getAge() < s2.getAge()){
            //         return -1;
            //     }
            //     else if(s1.getAge() > s2.getAge()){
            //         return 1;
            //     }
            //     else{
            //         return s1.getName().compareTo(s2.getName());
            //     }
            // }


            int scoreComparison = Double.compare(s2.getScore(), s1.getScore()); // can't use compareTo() method as Student.score is primitive type(double)
            if(scoreComparison != 0){
                return scoreComparison;
            }

            int ageComparison = Integer.compare(s1.getAge(), s2.getAge()); // can't use compareTo() method as Student.score is primitive type(int)
            if(ageComparison != 0){
                return ageComparison;
            }

            return s1.getName().compareTo(s2.getName());

        }

    }
}
