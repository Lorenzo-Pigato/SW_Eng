package Exercise.Exercise_17;

public class Main {

    public static void main(String[] args) {
        DogSchool dogs = new DogSchool();
        dogs.populate();
        dogs.display();

        CatSchool cats = new CatSchool();
        cats.populate();
        cats.display();
    }
}
