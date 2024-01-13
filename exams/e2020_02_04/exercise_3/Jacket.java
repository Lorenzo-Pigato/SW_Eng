package exams.e2020_02_04.exercise_3;

/*
 * Esercizio 3 (6 punti)
    Un’azienda che vende giacche invernali deve gestire la configurazione dei propri prodotti. Ogni giacca, oltre ad avere un tessuto
    ed un colore, pu`o avere tasche normali o esterne, tasche interne e tasche doppie. Ogni giacca pu`o avere il cappuccio, il collo
    alla coreana, oppure il collo normale. Infine, la chiusura pu`o essere attraverso bottoni, di diverse tipologie, o zip. L’azienda
    vuole realizzare un’applicazione per gestire tutte le condfigurazioni attuali e poter anche, magari, aggiungere ulteriori elementi
    in futuro. Come si potrebbe realizzare la struttura delle classi (diagramma delle classi UML) per avere le funzionalit`a richieste?
    Quali design pattern utilizzereste
 */

// Using Decorator design pattern

// Object Interface
interface Element {
   void display();
}

// Base object
public class Jacket implements Element {
   @Override
   public void display() {
       System.out.print("Jacket");
   }

   public static void main(String[] args) {
      new Pockets(new Neck((new Fabric(new Jacket(), Fabric.type.LEATHER)), Neck.type.HOOD), Pockets.type.EXTERN).display();
   }
}
