package Exercise.Exercise_2;

import java.time.LocalDate;

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

class Person {
    private String name;
    private String surname;
    private LocalDate birthDate;

    public Person(String name, String surname, LocalDate birthDate)
    {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    protected String getName(){
        return this.name;
    }

    protected String getSurname(){
        return this.surname;
    }

    protected LocalDate getBirthDate(){
        return this.birthDate;
    }
}
