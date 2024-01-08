package exams.e2022_08_29.exerscise_4;

public class Car implements Runnable {
    private String id;
    private ParkingLot2 parking;

    public Car(String id, ParkingLot2 parking) {
        this.parking = parking;
        this.id = "CAR-" + id;
    }

    @Override
    public void run() {
        boolean request;

        do {
            synchronized (parking) {
                request = parking.enter();
            }

            if (!request)
                try {
                    System.out.println(id + " will wait 5 sec before trying again");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println("Error waiting");
                }
        } while (!request);

        System.out.println(this.id + " entered the parking lot");
        try {
            Thread.sleep((int) (Math.random() * 20000));
        } catch (Exception e) {
            System.out.println("Thread error");
        }

        synchronized (parking) {
            System.out.println(this.id + " exited the parking lot");
            parking.exit();
        }
    }
}
