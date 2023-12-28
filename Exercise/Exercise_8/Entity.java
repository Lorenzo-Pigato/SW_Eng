package Exercise.Exercise_8;

/*
    Esercizio 5 / Database
    Si progetti la classe Database.

    👉  Deﬁnire la astratta classe Entity caratterizzato da
        un identiﬁcativo id e un metodo displayDetails( ).

*/

abstract class Entity {
    protected String id;

    public String getId() {
        return id;
    }
    
    abstract void displayDetails();
}


