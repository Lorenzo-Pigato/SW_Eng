package exams.e2016_07_06.exercise_3;

public class Platform {
    private int platform;
    private boolean isBusy;

    public Platform(int platform){
        this.platform = platform;
        this.isBusy = false;
    }

    public int getPlatform() {
        return platform;
    }

    public void setBusy(){
        this.isBusy = true;
    }

    public void setFree(){
        this.isBusy = false;
    }

    public boolean isBusy() {
        return isBusy;
    }
}
