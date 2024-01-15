package exams.extra;

public class Flowchart {
    public static void main(String[] args) {
        int x = 3;
        if (x < 3) {
            return;
        }
        int m = x - 2;
        while (x > 0) {
            x = x % m;
            if (m == 1 || x >= 0) {
                x = x - 1;
            }
        }
        return;

    }
}
