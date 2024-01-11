package exams.e2021_06_24.exercise_4;

public class Flight implements Runnable {
    private int id;
    private Airport airport;
    private Conveyor conveyor;
    private int luggage;
    
    public Flight(int id, Airport airport, int luggage){
        this.airport = airport;
        this.id = id;
        this.luggage = luggage;
    }

    @Override
    public void run() {
        synchronized(airport)
        {
            while ((conveyor = airport.getConveyor()) == null) {
                try {
                    airport.wait();
                } catch (Exception e) {System.out.println(e.getMessage());}
            }   
        }

        System.out.println("Flight: F" + id + " on conveyor: C" + conveyor.getId());
        
        while (luggage > 0) {
            synchronized(conveyor){
                while (!conveyor.load()) {
                    try {
                        conveyor.wait();
                    } catch (Exception e) {System.out.println(e.getMessage());}
                }
            }

            luggage--;
            System.out.println("F" + id
                                   + ": " + luggage + " remaining luggage");

            try {
                Thread.sleep(500);
            } catch (Exception e) {System.out.println(e.getMessage());}
        }

        synchronized(airport){
            airport.releaseConveyor(conveyor);
        }

        System.out.println("Flight: F" + id + " empty");

    }
        
}
