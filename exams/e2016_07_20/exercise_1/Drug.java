package exams.e2016_07_20.exercise_1;

import java.util.ArrayList;
import java.time.LocalDate;

/*
La classe Farmaco fornisce i metodi: boolean compatibile(Farmaco f) per controllare la compatibilità tra
this e f, e Date finePrescrizione() per consentire il controllo relativo alla fine della prescrizione.
*/

public class Drug {
    private LocalDate expirationDate;
    private String id;
    private ArrayList<String> clashingDrugsId;

    public Drug(String id, LocalDate expirationDate, ArrayList<String> clashingDrugsID){
        this.id = id;
        this.expirationDate = expirationDate;
        this.clashingDrugsId = clashingDrugsID;
    }

    public String getId() {
        return id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isCompatible(Drug newDrug){
        for (String drug : clashingDrugsId) {
            if (drug.equals(newDrug.getId())) {
                return false;
            }
        }

        return true;
    }
}
