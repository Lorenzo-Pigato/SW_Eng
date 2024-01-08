package exams.e2022_07_22.exercise_5;

public class Robot implements Runnable {
    private Belt belt;
    private String packetName;

    public Robot(Belt belt) {
        this.belt = belt;
        packetName = null;
    }

    public Robot(Belt belt, String packetName){
        this.belt = belt;
        this.packetName = packetName;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(belt){
                if (packetName != null) {
                    if(!belt.load(new Packet(packetName))) 
                    try {
                        belt.wait();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }

                else{
                    if((belt.unload()) == null)
                    try {
                        belt.wait();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }
            } 
        }
    }
}
