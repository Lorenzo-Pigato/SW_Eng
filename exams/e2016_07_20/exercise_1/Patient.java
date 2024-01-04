package exams.e2016_07_20.exercise_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
La classe Paziente fornisce quindi il metodo ArrayList<Farmaco> aggiungi(Farmaco f) e questo:
• rimuove tutti i farmaci potenzialmente incompatibli con il nuovo aggiunto dalla storia del paziente e li restituisce, come
ArrayList. Nel caso in cui non esistano farmaci incompatibili, il metodo restituisce una lista vuota.
• aggiunge comunque il nuovo farmaco come primo alla lista dei farmaci prescritti al paziente.
• rimuove dalla cartella del paziente tutti farmaci non più prescitti, ovvero tutti i farmaci la cui data di fine prescrizione è
nel passato rispetto a oggi.

Paziente fornisce anche il metodo ArrayList<Farmaco> prescrizioniAttive(), che fornisce tutte le prescri-
zioni attive, ovvero associate al paziente.

 */

public class Patient {
    private String name;
    private String id;
    private ArrayList<Drug> drugList;

    public Patient(String id, String name) {
        this.name = name;
        this.id = id;
        this.drugList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Drug> addDrug(Drug newDrug) {
        ArrayList<Drug> removedDrugs = new ArrayList<>();

        for (Drug drug : drugList) {
            if (!drug.isCompatible(newDrug) || drug.getExpirationDate().isAfter(LocalDate.now())) {
                this.drugList.remove(drug);
                removedDrugs.add(drug);
            }
        }

        this.drugList.add(newDrug);
        return removedDrugs;
    }

    public ArrayList<Drug> activePrescriptions() {
        return this.drugList;
    }
}

class AlphaOrderDrugs implements Iterable<String> {
    private ArrayList<String> drugsIds = new ArrayList<>();
    private int index = 0;

    public AlphaOrderDrugs(ArrayList<Drug> drugs) {
        for (Drug drug : drugs) {
            drugsIds.add(drug.getId());
        }

        Collections.sort(drugsIds);
    }

    @Override
    public Iterator<String> iterator() {
        return new DrugsIterator();
    }

    class DrugsIterator implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return index < drugsIds.size();
        }

        @Override
        public String next() {
            return drugsIds.get(index);
        }
    }
}
