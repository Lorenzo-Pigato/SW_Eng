package Exercise.Exercise_3;

import java.util.List;

public class MinUtil {
    //(List<? extends Comparable) allows to not define which class is extending Comparable. "?" is called wildcard

    @SuppressWarnings("rawtypes")
    public static Comparable min (List<? extends Comparable> list) {
        Comparable actualMin = null;

        for(Comparable obj: list){
            if(actualMin == null || obj.compareTo(actualMin) < 0) actualMin = obj;
        }

        return actualMin;

    }
}
