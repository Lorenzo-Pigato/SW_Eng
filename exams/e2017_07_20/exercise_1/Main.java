package exams.e2017_07_20.exercise_1;

/*
Esercizio 1 (10 punti)

Il sistema sanitario nazionale vuole fornire ai medici una app per la gestione delle prescrizioni ai loro pazienti. Per aiutare il
medico, all’aggiunta di ogni farmaco alla storia del paziente, il sistema controlla la compatibilità del nuovo farmaco con quelli
già previsti. 

La classe Paziente fornisce quindi il metodo ArrayList<Farmaco> aggiungi(Farmaco f) e questo:
• rimuove tutti i farmaci potenzialmente incompatibli con il nuovo aggiunto dalla storia del paziente e li restituisce, come
ArrayList. Nel caso in cui non esistano farmaci incompatibili, il metodo restituisce una lista vuota.
• aggiunge comunque il nuovo farmaco come primo alla lista dei farmaci prescritti al paziente.
• rimuove dalla cartella del paziente tutti farmaci non più prescitti, ovvero tutti i farmaci la cui data di fine prescrizione è
nel passato rispetto a oggi.
Paziente fornisce anche il metodo ArrayList<Farmaco> prescrizioniAttive(), che fornisce tutte le prescri-
zioni attive, ovvero associate al paziente.
La classe Farmaco fornisce i metodi: boolean compatibile(Farmaco f) per controllare la compatibilità tra
this e f, e Date finePrescrizione() per consentire il controllo relativo alla fine della prescrizione.

1. Si definisca la specifica completa del metodo aggiungi in JML.
2. Si ipotizzi una rappresentazione per lo stato delle classi Paziente e Farmaco e si definisca tutto quanto necessario
per realizzare il metodo Iterator<Farmaco> farmaciOrdineAlfabetico() per poter accedere ai farmaci
prescritti ad un paziente in ordine alfabetico.

Si ricorda che in Java 8 la classe Date ha un costruttore che crea un oggetto che rappresenta la data di creazione in
millisencondi a partire dal 1/1/1970. I metodi getTime, che restituisce il valore della data in millisecondi come sopra,
before e after possono essere usati per ragionare sulle date.
 */

public class Main {
    
}
