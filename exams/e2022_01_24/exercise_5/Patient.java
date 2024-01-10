package exams.e2022_01_24.exercise_5;

public class Patient implements Runnable{
    private int id;
    private Pharmacy pharmacy;
    
    public Patient(int id, Pharmacy pharmacy){
        this.id = id;
        this.pharmacy = pharmacy;
    }

    @Override
    public void run() {
        synchronized (pharmacy){
            while (!pharmacy.enter()) {
                try {
                    pharmacy.wait();
                } catch (Exception e) {break;}
            }

            System.out.println(id + " entered");
        }

        try {
            Thread.sleep((int)(Math.random()*5000));;
        } catch (Exception e) {return;}

        System.out.println(id + " leaving");

        synchronized(pharmacy){
            pharmacy.exit();
        }
    }
}
