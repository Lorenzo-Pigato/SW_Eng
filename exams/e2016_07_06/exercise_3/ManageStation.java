package exams.e2016_07_06.exercise_3;

/*
    Esercizio 3 (7 punti)
    Si scriva un programma Java concorrente (classi e thread) che consenta la gestione di una stazione ferroviaria, con un numero
    nBinari di binari e un numero massimo di treni pari a nTreni. Chiaramente, un treno può entrare in stazione solo se esiste
    almeno un binario libero e lascerà la stazione dopo un tempo variabile. Per semplicità, ogni treno occupa il primo binario utile
    partendo dal primo.
    Si modelli anche il caso in cui la stazione offre 5 binari e 20 treni, in parallelo, cercano di entrare in stazione. Ogni treno
    aspetterà una quantità di tempo casuale prima di cercare di occupare un binario. Si ricorda che Math.random() restituisce
    un long compreso tra 0 e 1
 */
public class ManageStation {
    private int nPlatforms;
    private int nTrains;
    private Train[] trainList;
    private Platform[] platformList;

    public ManageStation(int nPlatforms, int nTrains){
        this.nPlatforms = nPlatforms;
        this.nTrains = nTrains;
        this.trainList = new Train[nTrains];
        this.platformList = new Platform[nPlatforms];
        
        System.out.println("Istancing " + this.nTrains + " trains and " + nPlatforms + " rails");
        for(int i = 0; i < nPlatforms; i++){
            platformList[i] = new Platform(i);
        }
        
        for(int i = 0; i < nTrains; i++){
            trainList[i] = new Train(i, this);
            new Thread(trainList[i]).start();
        }
    }

    public synchronized Platform assignPlatform(){
        for(int i = 0; i < nPlatforms; i++){
            if (!this.platformList[i].isBusy()) {
                notifyAll();
                return platformList[i];
            }
        }
        return null;
    }

    public synchronized void setFree(Platform platform){
        platform.setFree();
        notify();
    }

    public static void main(String[] args) {
        new ManageStation(3, 10);
    }
    
}
