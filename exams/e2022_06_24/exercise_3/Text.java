package exams.e2022_06_24.exercise_3;

public class Text {
    public static void main(String[] args) {
        String t = "myText";

        t = FormattedText.apply(t, "red");
        System.out.println(FormattedText.apply(FormattedText.apply(t, "bold"), "underline"));
    }
}

