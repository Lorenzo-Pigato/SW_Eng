package exams.e2016_07_06.exercise_3;

public class Train implements Runnable {
    private int trainNumber;
    private ManageStation station;

    public Train(int trainNumber, ManageStation station) {
        this.trainNumber = trainNumber;
        this.station = station;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    @Override
    public void run() {
        System.out.println("Train " + trainNumber + " is online");

        /*
         * try {
         * Thread.sleep((int)(Math.random() * 5000));
         * } catch (Exception e) {
         * System.out.println("Error suspending thread");
         * }
         */

        System.out.println("Train " + trainNumber + " is requesting a platform");

        Platform assignedPlatform = null;
        synchronized (station) {
            while ((assignedPlatform = station.assignPlatform()) == null) {
                try {
                    station.wait();
                } catch (Exception e) {
                    System.out.println("Generic error");
                }
            }
        }

        assignedPlatform.setBusy();
        System.out.println("Train " + trainNumber + " arrived at platform " + assignedPlatform.getPlatform());

        try {
            Thread.sleep((int) (Math.random() * 4000 + 1000));
        } catch (Exception e) {
            System.out.println("Error suspending thread");
        }

        System.out.println("Train " + trainNumber + " is leaving platform " + assignedPlatform.getPlatform());
        station.setFree(assignedPlatform);
        

    }
}
