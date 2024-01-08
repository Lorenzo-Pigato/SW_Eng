package exams.e2022_07_22.exercise_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Esercizio 2 (8 punti)
Si considerio le seguenti classi Java, in cui viene omessa l’ovvia implementazione dei metodi getMembers(), getSize()
e getName().
public class Group {
public List<Element> getMembers() { ... }
}
class Element {
public String getName() { ... }
public int getSize() { ... }
}
Si implementino i seguenti metodi facendo uso esclusivamente di costrutti della programmazione funzionale:
1. Il metodo void printType(Group g) deve stampare la dimensione media degli elementi del gruppo g. Se il
gruppo `e vuoto, il metodo non deve stampare nulla.
2. Il metodo List<String> namesInGroups(List<Group> gs) restituisce la lista con il nome di tutti gli ele-
menti presenti all’interno dei gruppi in gs con una dimensione maggiore di 10.
 */

public class FunctionalGroup {
    public static void printType(Group g){
        System.out.println( g.getMembers().stream().mapToDouble(msize -> msize.getSize()).average());                    
    }

    public static List<String> namesInGroups(List<Group> groups){
        return groups.stream().flatMap(group -> group.getMembers().stream()
                                                                  .map(name -> name.getName()))
                              .filter(name -> name.length() > 10)
                              .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        List<Element> elemList = Arrays.asList(new Element("E000", 5),
                                               new Element("E001", 4),
                                               new Element("E002", 3),
                                               new Element("E003", 5),
                                               new Element("E004",6),
                                               new Element("E005", 3),
                                               new Element("E006", 4),
                                               new Element("E008", 5),
                                               new Element("E009", 2),
                                               new Element("E010", 7)
                                               );
        Group group = new Group(elemList);
        FunctionalGroup.printType(group);
    }
}
