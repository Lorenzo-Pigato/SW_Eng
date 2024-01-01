package Exercise.Exercise_13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args){
        
        Buffer[] bufferArray = new Buffer[4];
        for (int i = 0; i < 4; i++) {
            bufferArray[i] = new Buffer(i);
        }
        
        // Anonymous Runnable implementation for Processing Input
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader parser = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    System.out.println("Insert buffer id and input: ");
                    try {
                        String[] input = parser.readLine().split(" ");
                        int id = Integer.parseInt(input[0]);
                        char c = input[1].charAt(0);

                        if(id < bufferArray.length)
                            bufferArray[id].fill(c);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        // Anonymous Runnable implementation for Processing Output
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 4; i++) {
                        char ch = bufferArray[i].read();
                        String result = "<" + i + "," + ch + "> ";
                        System.out.println("Processing Output: " + result);
                    }
                }
            }
        }).start();

    }
}
