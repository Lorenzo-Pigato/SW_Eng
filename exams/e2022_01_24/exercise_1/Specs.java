package exams.e2022_01_24.exercise_1;

public class Specs {
    /*
     * @requires this.freeSpace() > 0 && e.getSize() > 0 && e != null;
     * 
     * @ensures (\result == true) <==> (this.fresSpace() > e.getSize());
     * @ensures (\forall int i; i>=0 && i < \old.this.objects().size(); 
     *              this.objects().get(i).equals(this.objects().get(i)) && 
     *              this.objects().get(\old.this.objects().size()).equals(e));
     * 
     * @singals (AlreadyFullException afe) this.freeSpace <= 0;
     * @signals (InvalidElemenException iee) e.Size <= 0;
     * @signals (NullArgumentException nae) e == null;
     */
    public boolean addElement(Element e){return false;}
}

class Element{}
