package Exercise.Exercise_5;

import java.time.LocalDateTime;

public class Main {
    public static void main (String[] args){
        CronoDaemon.PrintAction prnt1 = new CronoDaemon.PrintAction("First message");
        CronoDaemon.PrintAction prnt2 = new CronoDaemon.PrintAction("Second message");
        CronoDaemon.PrintAction prnt3 = new CronoDaemon.PrintAction("Third message");
        CronoDaemon.PrintAction prnt4 = new CronoDaemon.PrintAction("Fourth message");
        CronoDaemon.PrintAction prnt5 = new CronoDaemon.PrintAction("Fifth message");

        try {
            CronoDaemon cronoEvent1 = new CronoDaemon(LocalDateTime.now().plusSeconds(2), prnt1);
            CronoDaemon cronoEvent2 = new CronoDaemon(LocalDateTime.now().plusSeconds(4), prnt2);
            CronoDaemon cronoEvent3 = new CronoDaemon(LocalDateTime.now().plusSeconds(6), prnt3);
            CronoDaemon cronoEvent4 = new CronoDaemon(LocalDateTime.now().plusSeconds(8), prnt4);
            CronoDaemon cronoEvent5 = new CronoDaemon(LocalDateTime.now().plusSeconds(10), prnt5);

            System.out.println(cronoEvent1.getTime());
            System.out.println(cronoEvent2.getTime());
            System.out.println(cronoEvent3.getTime());
            System.out.println(cronoEvent4.getTime());
            System.out.println(cronoEvent5.getTime());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        CronoDaemon.cronoStart();
            
    }
}
