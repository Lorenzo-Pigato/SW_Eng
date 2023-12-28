package Exercise.Exercise_8;

/*
    👉  Deﬁnire Person and Product che estendono Entity. Person ha attributi nome e
        cognome, mentre Product ha attributi nome e prezzo. Fare override del
        metodo displayDetails( ).
 */
 
public class Person extends Entity{
    private String name;
    private String surname;

    public Person(String id, String name, String surname){
        this.name = name;
        this.surname = surname;

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public void displayDetails(){
        System.out.println(name + " " + surname + ", Id: " + id);
    }

}
