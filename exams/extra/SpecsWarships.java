package exams.extra;

/*
 * (* Il campo di battaglia è una matrice di boolean, una 
 *    combinazione [i][j] restituisce true se è stato sparato un colpo a quella posizione *)
 */
public class SpecsWarships {
    /*
     * @requires b != null && field!=null
     * @ensures (\result == true) <==> (\forall int d,x,y; d >= 0 && d < b.getPosition().length && x == b.getPosition()[d][0] 
     *                                                                                          && y == b.getPosition()[d][1];
     *                                                                                              field[x][y] == true)
     */
    boolean isSinked(Boat b, Field field) {return false;}
}

/*
 * private invariant position != null && position.length > 1 && position.length < 7
 *                            && (\forall int i; i >= 0 && i < position.length; position[i].length == 2)
 *                            && ((\forall int d1; d1 >= 0 && d1 < position.length; 
 *                                  (\forall int d2; d2 >= 0 && d2 < position.length; position[d1][0] == position [d2][0]
 *                                                                                 && position[d1][1] == position[d1 + 1][1] + 1)) 
 *                                ||
 *                                (\forall int d1; d1 >= 0 && d1 < position.length; 
 *                                  (\forall int d2; d2 >= 0 && d2 < position.length; position[d1][1] == position [d2][1]
 *                                                                                 && position[d1][0] == position[d1 + 1][0] + 1))
 *                               );
 *                            && ((\forall int d1; d1 >= 0 && d1 < position.length; 
 *                                  (\forall int d2; d2 >= 0 && d2 < position.length; position[d1][0] >= 0 && <= field.length
 *                                                                                    position[d1][1] >= 0 && <= field.length)) 
 *                    
 * 
 */
class Boat {
    int[][] position; // position [0-9 0-10 0-11 0-12 0-13]

    public int[][] getPosition() {
        return position;
    }
}

/*@ (*Il campo deve essere regolare*) */
class Field{
    boolean[][] field;
}