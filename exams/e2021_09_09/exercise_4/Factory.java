package exams.e2021_09_09.exercise_4;

import java.util.ArrayList;
import java.util.Collections;

public class Factory {
    ArrayList<Integer> lines = new ArrayList<>();

    public Factory(int totalLines){
        for(int i = 0; i < totalLines; i++){
            lines.add(i);
        }

        System.out.println("Added: " + lines.size() + " lines");
    }

    public synchronized int getLine(){
        int assigned;
        if (lines.size() > 0) {
            assigned = lines.get(0);
            lines.remove(0);
            return assigned;
        }
        
        return -1;
    }

    public synchronized void releaseLine(int line){
        lines.add(line);
        Collections.sort(lines);
        notifyAll();
    }

    public static void main(String[] args) {
        Factory fac = new Factory(10);
        for(int i=0; i < 30; i++){
            new Thread(new Element(i, fac)).start();
        }
    }   

}
