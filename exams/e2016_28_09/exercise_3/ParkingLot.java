package exams.e2016_28_09.exercise_3;

import java.util.Scanner;

public class ParkingLot {
    private int freeSpace;

    public ParkingLot (int capacity) {
        this.freeSpace = capacity;
    }

    public synchronized boolean enter() {
        if(freeSpace > 0)
        {
            freeSpace --;
            return true;
        }
        else
            System.out.println("---- Parking is full -----");
            return false;
    }

    public synchronized void exit(){
        freeSpace ++;
        notify();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert number of cars to create: ");
        
        ParkingLot park = new ParkingLot(50);
        
        for (int i = scanner.nextInt(); i > 0; i--){
            new Thread(new Car(String.valueOf(i), park)).start();
        }

        scanner.close();
    }
}