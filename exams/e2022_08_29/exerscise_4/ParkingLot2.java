package exams.e2022_08_29.exerscise_4;

import java.util.Scanner;

public class ParkingLot2 {
    private int freeSpace;

    public ParkingLot2 (int capacity) {
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert number of cars to create: ");
        
        ParkingLot2 park = new ParkingLot2(10);
        
        for (int i = scanner.nextInt(); i > 0; i--){
            new Thread(new Car(String.valueOf(i), park)).start();
        }

        scanner.close();
    }
}