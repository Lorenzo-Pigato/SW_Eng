package Exercise.Exercise_17;

public interface Pet {
    String getId(); 
    String getName();
    Species getSpecies();
    int getAge();
}

enum Species {
    DOG("Dog"),
    CAT("Cat"),
    BIRD("Bird");

    final private String speciesStr;

    // Special constructor: matches each enum with the String associated
    Species (String spec){
        this.speciesStr = spec;
    }

    public String getSpeciesStr() {
        return speciesStr;
    }
}

class Dog implements Pet {
    final static Species species = Species.DOG;
    private String name;
    private String id;
    private int age;

    public Dog(String id, String name, int age){
        this.name = name;
        this.id = "DOG"+id;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
        
    }

    @Override
    public String getId() {
        System.out.println(this.id);
        return this.id;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public Species getSpecies() {
        return Dog.species;
    }

}


class Cat implements Pet {
    final static Species species = Species.CAT;
    private String name;
    private String id;
    private int age;

    public Cat(String id, String name, int age){
        this.name = name;
        this.id = "CAT"+id;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
        
    }

    @Override
    public String getId() {
        System.out.println(this.id);
        return this.id;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public Species getSpecies() {
        return Cat.species;
    }

}

