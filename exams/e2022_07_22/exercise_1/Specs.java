package exams.e2022_07_22.exercise_1;

public class Specs {
    
    /*
     * @requires s != null
     * @ensures (n == 0) <==> (\result == s.length()) &&
     *          (n == 1) <==> (\result == (\num_of int i; i >= 0 && i< s.length(); s.charAt[i].isUpperCase())) &&
     *          (n == 2) <==> (\result == (\num_of i; i >= 0 && i< s.length(); s.charAt[i].isLowerCase())) &&
     *          (n < 0 || n > 2) <==> (\result == 0)
     */
    int method1(String s, int n){return 0;}

    /*
     * @requires as != null && bs != null && (\forall int i; i >= 0 && i < as.size(); 
     *                                          !(\exists int j; j > i && j < i.as.size(); as[i].equals(as[j])));
     *                                    && (*same for bs*);
     * @ensures \result == (\num_of int i; i >= 0 && i < as.size(); 
     *                          (\forall int j; j >= 0 && j < bs.size(); as[i].equals(bs[j])));
     */
    int method2(String[] as, String[] bs){return 0;}
}


