package Exercise.Exercise_3;

import java.time.LocalDate;
import java.util.List;


import java.util.ArrayList;


class Student extends Person {
    String id;
    List<Exam> exams;

    Student (String name, String surname, LocalDate birthDate, String id){
        super(name, surname, birthDate);
        
        this.id = new String();
        this.id = id;

        this.exams = new ArrayList<Exam>(); 
    }

    protected String getId(){
        return this.id;
    }

    protected void addExam (int mark, int credits){
        Exam exam = new Exam(mark, credits);
        this.exams.add(exam);
    }

    protected double meanGrade() throws Exception {
        double marksSum = 0;
        int creditsSum = 0;

        for (Exam exam : exams) {
            marksSum += exam.getMark()*exam.getCredits();
            creditsSum += exam.getCredits();
        }
            
        double mean = marksSum / creditsSum;
        
        if(Double.isNaN(mean)) throw new Exception();
        else return mean;
    }

    @Override
    public int compareTo(Person p) {
        int personComp = super.compareTo(p);

        if(p instanceof Student)
        {
            if (personComp == 0) {
                return ((Student)p).getId().compareTo(id);
            }
            else return personComp;
        }
        else
            throw new RuntimeException("Can't compare Student with Unknown");
    }
}

class Exam {
    private int mark;
    private int credits;

    Exam(int mark, int credits){
        this.mark = mark;
        this.credits = credits;
    }

    protected int getMark(){
        return this.mark;
    }

    protected int getCredits(){
        return this.credits;
    }
}
