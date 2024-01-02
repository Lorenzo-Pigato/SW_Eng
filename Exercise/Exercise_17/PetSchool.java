package Exercise.Exercise_17;

/*
    Esercizio 6 / Factory
    👉  Una PetSchool è una scuola composta da animali invece che da essere umani.
    
    👉  Ogni PetSchool è composta da animali dello stesso tipo (solo gatti, solo cani,
        etc.) in numero pari a 50.
    
    👉  Il costruttore di PetSchool deve riempire la scuola. Usare un adeguato design
        pattern.
 */

public interface PetSchool {
    public Pet makePet(String id, String name, int age);
}