package exams.e2018_09_03.exercise_3;

import java.util.ArrayList;

public class Array {
    private int[] array = new int[50];
    private ArrayList<Thread> subprocesses = new ArrayList<>();
    private ArrayList<Integer> partialResults = new ArrayList<>();

    public Array(){
        for(int i=0; i<50; i++){
            array[i]=(int)(Math.random()*10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public synchronized void saveResult(int result){
        this.partialResults.add(result);
    }

    public void start(){
        int[] subvector = new int[10];
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                subvector[j] = array[i*10 + j];
                System.out.print(subvector[j] + " ");
            }

            System.out.println();
            
            subprocesses.add(new Thread( new Subprocess(subvector, this)));
        }

        for (Thread subprocess : subprocesses) {
            subprocess.start();
        }


        for (Thread subprocess : subprocesses) {
            try { subprocess.join();}
            catch (Exception e) {};
        }

        System.out.println(partialResults.stream().reduce(0, (a, b) -> Integer.sum(a, b)));
    }

    public static void main(String[] args) {
        Array a = new Array();
        a.start();
    }
}
