package exams.e2022_08_29.exercise_1;

import java.util.ArrayList;

public class Specs {
    /*
     * @requires s != null
     * @ensures \result == (\sum int i; i >= 0 && i < s.length(); 
     * @                         !(\exists int j; j >= 0 && j <s.length && j != i; 
     * @                            (Character.isUpperCase(charAt[i]) ? Character.toLowerCase(charAt[i])  : s.charAt[i]) == s.charAt[j]))
     * @signals (NullStringException nse) s == null;
     */
    int method1(String s){return 0;}

    /*
     * @requires as != null && s != null;
     * @ensures as.contains(s) <==> (\old.as.contains(s) || !\old.as.contains(s) && \old.as.add(s)) &&
     *          (\forall int i; i >= 0 && i < as.size; 
     *              !(\exists int j; j > i && j < as.size; as.get(i).length() > as.get(i).length()));
     * @signals(NullArgumentException nae) as == null || s == null;
     */
    void method2(ArrayList<String> as, String s){}

}
