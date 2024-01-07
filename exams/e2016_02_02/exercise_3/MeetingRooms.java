package exams.e2016_02_02.exercise_3;

import java.util.ArrayList;

public class MeetingRooms {
    private ArrayList<Room> availableRooms = new ArrayList<>();

    public MeetingRooms(int rooms) {
        for(int i = 0; i < rooms; i++)
            this.availableRooms.add(new Room(String.valueOf(i)));

        for (int i = 0; i < rooms * 5; i++) {
            new Thread(new Request(String.valueOf(i), this)).start();
        }
        
    }

    public synchronized Room requestRoom() {
        if(!availableRooms.isEmpty()){
            Room assigned = availableRooms.get(0);
            availableRooms.remove(0);
            return assigned;
        }
        else
            return null;
    }

    public synchronized void returnRoom(Room room) {
        availableRooms.add(room);
        notifyAll();
    }

    public static void main(String[] args) {
        new MeetingRooms(10);
    }
}

class Room {
    private String id;
    
    public Room(String id){
        this.id = "R-" + id;
    }

    public String getId() {
        return id;
    }
}
