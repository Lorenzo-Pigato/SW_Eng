package exams.e2021_09_09.exercise_5;

public class Exercise {
    public static void main(String[] args) {
        int x = 5;
        int y = 3;

        int z = x;
        while (z > 0) {
            if (z > y || x == 1)
                break;
            else
                x = x % z;
            --z;
        }

        System.out.println(z);
    }
}
