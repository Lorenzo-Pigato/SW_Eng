package Exercise.Exercise_5;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/*
    Esercizio 1 / Cron
    
    Si progetti un package che oﬀra un "demone temporale" simile a cron di Unix.

    👉 Deﬁnire l’interfaccia Action con metodo execute( ).
       Deﬁnire la classe PrintAction con metodo execute( ) che stampa a schermo.
    
    👉 L'utente del package deve poter creare un demone (in inglese daemon), registrare presso di
       lui una serie di coppie <orario, azione da compiere>.

    👉 Il demone temporale, una volta avviato, deve eseguire le azioni registrate all'orario
       prestabilito.
    
    👉 Si supponga che non si possano registrare più di 10 azioni, che ogni azione debba venir
       eseguita una volta soltanto e che una volta eseguite tutte le azioni cron termini la sua
       esecuzione.
    
    👉 Si può interpretare l'orario di esecuzione come "orario indicativo": viene garantito che
       l'azione viene eseguita *dopo* l'orario speciﬁcato.
 */
public class CronoDaemon {
    // cronoList is static so every istance of the class is inside the list
    private static List<CronoDaemon> cronoList = new LinkedList<CronoDaemon>();

    private LocalDateTime time;
    private Action action;

    public CronoDaemon(LocalDateTime time, Action action) throws Exception {
        if (cronoList.size() >= 10)
            throw new Exception();

        this.time = time;
        this.action = action;

        cronoList.add(this);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Action getAction() {
        return action;
    }

    // Defined an Action interface to implement custom actions
    public interface Action {
        void execute();
    }

    // PrintAction is a final class that implements Action, used to print messages
    final static class PrintAction implements Action {
        private String message;

        public PrintAction(String message) {
            this.message = message;
        }

        @Override
        public void execute() {
            System.out.println(message);
        }
    }

    public static void cronoStart() {
        while (!cronoList.isEmpty()) {
            CronoDaemon inExec = null;
            for (CronoDaemon cronoDaemon : cronoList) {
                if (cronoDaemon.getTime().isBefore(LocalDateTime.now())) {
                    inExec = cronoDaemon;
                }
            }

            if (inExec != null) {
                inExec.getAction().execute();
                cronoList.remove(inExec);
            }

        }
    }

}
