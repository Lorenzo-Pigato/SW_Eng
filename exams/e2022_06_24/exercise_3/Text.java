package exams.e2022_06_24.exercise_3;

// Base object
public class Text implements Elaborate{
    
    @Override
    public String writeText(String str) {
        return str;
    }

    public static void main(String[] args) {
        Text t = new Text();
        Select s = new Select();
        System.out.println(s.apply(t, "green").writeText("abcd"));

    }
}

