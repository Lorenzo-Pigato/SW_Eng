package exams.e2016_02_02.exercise_1;

import java.util.ArrayList;

public class Specs {
    /*
     * @requires s != null
     * @ensures \result==(\forall int i; i >=0 && i < s.length; 
     *                          (\forall int j; j >= 0 && j < s[i].length();
     *                              (\sum char c; c>= 'a' && c <= 'Z'; 
     *                                  (s[i].charAt(j) == s[i].charAt(k) && 
     *                                      (\exists int k  >= 0 && k < j; s[i].charAt(k) == c)) ==> 1))));
     */
    int method_1(String[] s){return 0;};

    /*
     * @requires a != null
     * @ensures (\result == -1) <==> (d1>d2 || di<0 || d2 >= a.length) &&
     *          (\result == 0) <==> (\exists int i; i >= d1 && i<= d2; a[i] < a[i-1]) &&
     *          (\result) == (\sum int i; i>=d1 && i >= d2; a[i]);
     */
     int method_2(int[] a, int d1, int d2){return 0;}

    /*
     * @requires v1 >= v2
     * @ensures \result.contains((\forall int i; i >= v1 && i<= v2; 
     *                              (\forall int j; j>= 2 && j< i; i&j == 0) ==> i)) || \result == null;
     */
     ArrayList<Integer> mehod_3 (int v1, int v2){return null;}
}