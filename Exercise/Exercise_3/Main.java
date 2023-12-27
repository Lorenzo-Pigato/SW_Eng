package Exercise.Exercise_3;

/*

Esercizio 3 / Comparable Interface
Implementare la funzione min(List list).

    👉  Implementare un metodo statico min che trova il minimo di una lista di oggetti
        che implementano l’interfaccia java.lang.Comparable
    
    👉  Person implementa Comparable controllando l’ordine del cognome e poi, in
        caso di omonimia, il nome. Student aggiunge a questo comportamento in caso
        di omonimia sia sul nome che sul cognome il controllo sull’id.

    👉  Ordinare una lista di studenti sia con java.util.Collections.sort che con il
        Comparator (invocando direttamente studentList.sort( ) ) 
*/

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student lorenzo = new Student("Lorenzo", "Pigato", LocalDate.of(2002,6,11), "10766655");
        Student lorenzo2 = new Student("Lorenzo", "Pigato", LocalDate.of(2002,11,6), "10766654");
        Student guido = new Student("Guido", "Cestele", LocalDate.of(2002,6,11), "10777655");
        Student sara = new Student("Sara", "Pigato", LocalDate.of(2005,8,11), "10766355");
        Student mario = new Student("Mario", "Rossi", LocalDate.of(2000,8,11), "10766335");
        
        List<Student> studentList = new ArrayList<>();

        studentList.add(lorenzo);
        studentList.add(lorenzo2);
        studentList.add(sara);
        studentList.add(guido);
        studentList.add(mario);

        Collections.sort(studentList);
        System.out.println(studentList);

        // Alternative methods to sort a list using a Comparator instead of Collections.sort() method:
        
        // Student::getBirthDate is a reference to a generic istance
        Comparator<Student> birthDateComp = Comparator.comparing(Student::getBirthDate);
        studentList.sort(birthDateComp);

        System.out.println(studentList);
        
        Student minSt = (Student)MinUtil.min(studentList);
        System.out.println(minSt);
    } 
}
