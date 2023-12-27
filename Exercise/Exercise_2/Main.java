package Exercise.Exercise_2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Student lorenzo = new Student("Lorenzo", "Pigato", LocalDate.of(2002,6,11), "10766655");
        
        try {
            System.out.println("Mean of grades: " + lorenzo.meanGrade());
        } catch (Exception e) {
            System.out.println("No exams taken");
        }
        
        lorenzo.addExam(30,10);
        lorenzo.addExam(17, 7);
        lorenzo.addExam(30, 10);

        try {
            System.out.println("Mean of grades: " + lorenzo.meanGrade());
        } catch (Exception e) {
            System.out.println("No exams taken");
        }
    }
}
