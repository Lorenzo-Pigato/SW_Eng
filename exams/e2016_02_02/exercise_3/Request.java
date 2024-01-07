package exams.e2016_02_02.exercise_3;

public class Request implements Runnable {
    private MeetingRooms pool;
    private String id;

    public Request(String id, MeetingRooms pool) {
        this.pool = pool;
        this.id = "REQ-" + id;
    }

    @Override
    public void run() {
        Room thisRoom = null;
        synchronized (pool) {
            while ((thisRoom = pool.requestRoom()) == null) {
                try {
                    if (Math.random() * 100 < 30) {
                        System.out.println(this.id + " request aborted");
                        return;
                    }
                    System.out.println(this.id + " request paused");
                    pool.wait();
                } catch (Exception e) {
                    System.out.println("Error");
                    return;
                }
            }
        }

        System.out.println(this.id + " booked room " + thisRoom.getId());

        try {
            Thread.sleep((int) (Math.random() * 3000));
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }

        System.out.println(this.id + " returned room " + thisRoom.getId());
        pool.returnRoom(thisRoom);

    }
}
