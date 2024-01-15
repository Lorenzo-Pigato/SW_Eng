package exams.e2018_09_03.exercise_3;

public class Subprocess implements Runnable {
    private int[] vector;
    private Array array;

    public Subprocess(int[] vector, Array array){
        this.vector = vector.clone();
        this.array = array;
    }

    @Override
    public void run() {
        int result = 0;
        for(int i = 0; i < vector.length; i++){
            result += vector[i];
        }
        
        System.out.println("Partial: " + result);

        array.saveResult(result);
    }
}
