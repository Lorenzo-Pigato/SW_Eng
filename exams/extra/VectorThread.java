package exams.extra;

public class VectorThread {
    private Object lock = new Object();
    private int[] vector = new int[10];
    private int index = 0;

    public Integer read(int position) {
        synchronized (lock) {
            if (position < index) return vector[position];
            return null;
        }
    }

    public Integer shiftOut(){
        synchronized(lock){
            if(index > 0){
                int retval = vector[0];
                for(int i = 0; i < index-1; i++){
                    vector[i] = vector[i+1];
                }
                index--;
                return retval;
            }
            return null;
        }
    }

    public boolean add(int i){
        if(index < 9){vector[index] = i; index++; return true;}
        return false;
    }
}
