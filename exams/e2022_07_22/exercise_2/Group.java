package exams.e2022_07_22.exercise_2;

import java.util.List;

public class Group {
    private List<Element> members;
    
    public Group(List<Element> members){
        this.members = members;
    }

    public List<Element> getMembers() {
        return members;
    }
}

class Element {
    private String name;
    private int size;

    public Element(String name, int size){
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
