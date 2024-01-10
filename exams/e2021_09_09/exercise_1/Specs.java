package exams.e2021_09_09.exercise_1;

import java.util.ArrayList;
import java.util.List;

public class Specs {
    /*
     * @requires s != null;
     * 
     * @ensures \result == (\sum int i; i >= 0; i <= s.length; 
     *                      (\num_of int j; j >= 0 && j < s[i].length(); this.vocale(s[i].charAt[j]))
     *                     );
     * 
     * @signals (NullArgumentException nae) s == null;
     */
    public int /*@ pure @*/method1(String[] s){return 0;}

    /*
     * @requires a != null && a.length > 0;
     * 
     * @ensures (\result == 0) <==> !(d1 >= 0 && d1 <= d2 && d2 < a.length) &&
     * @        (\result == (\sum int i; i >= d1 && i <= d2; a[i]) / (d2 - d1 + 1));
     * 
     * @signals (NullArgumentException nae) a == null;
     * @signals (InvalidArgumentException iae) a.length <= 0;
     */
    int method2(int[] a, int d1, int d2){return 0;}

    /*
     * @requires l1 != null && l2 != null;
     * 
     * @ensures (\forall int i; i >= 0 && i <= l1.size(); (l1.get(i) % 2 != 0) <==> \result.contains(l1.get(i))) && 
     *          (\forall int i; i >= 0 && i <= l2.size(); (l2.get(i) % 2 != 0) <==> \result.contains(l2.get(i))) &&
     *          (\forall int i; i >= 0 && i <= \result.size(); 
     *              !(\exists int j; j>=0 && j<\result.size && j != i; \result.get(i) == \result.get(j) && 
     *              !(\exists int j; j>=0 && j<\result.size; !(l1.contains(\result.get(i))&&
     *                                                       !(l2.contains(\result.get(i))));
     * @signals (NullArgumentException nae) l1 == null || l2 == null;
     */
    ArrayList<Integer> method3 (List<Integer> l1, List<Integer> l2){return null;}
}
