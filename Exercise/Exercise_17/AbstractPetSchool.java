package Exercise.Exercise_17;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPetSchool implements PetSchool {
    List<Pet> students = new ArrayList<>();

    public void populate(){
        for(int i = 0; i < 50; i++){
            students.add(this.makePet(String.valueOf(i), null, 0));
        }
    }

    public void display(){
        students.stream().forEach(Pet::getId);
    }        
}

class DogSchool extends AbstractPetSchool {
    @Override
    public Pet makePet(String id, String name, int age) {
        return new Dog(id, name, age);
    }
}


class CatSchool extends AbstractPetSchool {
    @Override
    public Pet makePet(String id, String name, int age) {
        return new Cat(id, name, age);
    }
}
