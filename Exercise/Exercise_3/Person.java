package Exercise.Exercise_3;

import java.time.LocalDate;
import java.lang.Comparable;


class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person p) {
        int surnameComp = p.getSurname().compareTo(this.surname);
        
        if (surnameComp < 0) return 1;
        
        else if(surnameComp > 0) return -1;
        
        else
        {
            int nameComp = p.getName().compareTo(this.name);
            
            if (nameComp < 0) return 1;
        
            else if(nameComp > 0) return -1;

            else return 0; 
        }
    }

    @Override
    public String toString() {
        String toStr;

        toStr = this.getName()+" "+this.getSurname();
        return toStr;
    }
}
