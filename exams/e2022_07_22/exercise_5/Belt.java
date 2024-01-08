package exams.e2022_07_22.exercise_5;

import java.util.ArrayList;

public class Belt {
    private final int size = 3;
    private ArrayList<Packet> onTrack;

    public Belt() {
        this.onTrack = new ArrayList<>();
        new Thread(new Robot(this)).start();
        new Thread(new Robot(this)).start();
        new Thread(new Robot(this, "A")).start();
        new Thread(new Robot(this, "B")).start();
    }

    public synchronized boolean load(Packet packet){
        if(onTrack.size() < size)
        {
            System.out.println("Adding packet " + packet.getName());
            onTrack.add(0, packet);
            notifyAll();
            return true;
        }

        return false;

    }

    public synchronized String unload(){
        String result = null;
        if(onTrack.size() > 0){
            result = onTrack.get(onTrack.size()-1).getName();
            System.out.println(result);
            onTrack.remove(onTrack.size()-1);
            notifyAll();
        }

        return result;
    }

    public static void main(String[] args) {
        new Belt();
    }
}

class Packet {
    static int id;
    private String name;
    public Packet(String name){
        this.name = name + "-" + id;
        id++;
    }

    public String getName() {
        return name;
    }
}
