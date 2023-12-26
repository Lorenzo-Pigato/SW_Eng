package Exercise.Excercise_2;

import java.util.Date;

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
    private Date birthDate;

    public Person(String name, String surname, Date birthDate)
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

    protected Date getBirthDate(){
        return this.birthDate;
    }
}
