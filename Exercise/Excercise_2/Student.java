package Exercise.Excercise_2;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/*
Esercizio 5 / Persons and Students

Deﬁnire le classi Person, Student e Grade
    👉 Una persona ha un nome, cognome e una data ( java.util.Date).
    👉 Uno studente è una persona con un id e una lista di voti.
    👉 Un voto contiene punteggio e crediti.
    👉 Lo studente espone due funzionalità:
        ○ Metodo meanGrade per calcolare media pesata.
        ○ Metodo canGraduate se è possibile che si laurei (crediti totali >= 180).
*/

class Student extends Person {
    String id;
    List<Exam> exams;

    Student (String name, String surname, Date birthDate, String id){
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

    protected double meanGrade() throws NumberFormatException {
        double marksSum = 0;
        int creditsSum = 0;

        for (Exam exam : exams) {
            marksSum += exam.getMark()*exam.getCredits();
            creditsSum += exam.getCredits();
        }

        try {
            double mean = marksSum / creditsSum;
            return mean;
        }
        catch (NumberFormatException exc)
        {
            throw exc;
        }
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
