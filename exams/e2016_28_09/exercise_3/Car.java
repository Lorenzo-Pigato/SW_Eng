package exams.e2016_28_09.exercise_3;

public class Car implements Runnable {
    private String id;
    private ParkingLot parking;

    public Car(String id, ParkingLot parking) {
        this.parking = parking;
        this.id = "CAR-" + id;
    }

    @Override
    public void run() {
        synchronized (parking) {
            while (!parking.enter()) {
                try {
                    parking.wait();
                } catch (Exception e) {
                    System.out.println("Error waiting");
                }
            }
        }

        System.out.println(this.id + " entered the parking lot");
        try {
            Thread.sleep((int) (Math.random() * 5000));
        } catch (Exception e) {
            System.out.println("Thread error");
        }

        System.out.println(this.id + " exited the parking lot");
        parking.exit();
    }
}
