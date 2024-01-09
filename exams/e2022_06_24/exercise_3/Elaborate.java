package exams.e2022_06_24.exercise_3;

/*
 * Esercizio 3 (5 punti)
Si realizzi un diagramma delle classi che consenta di gestire parole sia rappresentate attraverso testo “semplice”, sia con rappre-
sentazioni in corsivo, grassetto e sottolineato. La soluzione proposta, basandosi magari sull’uso di un design pattern opportuno,
deve considerare tutte le possibili combinazioni, ovvero un testo potrebbe essere rappresentato in grassetto sottolineato e un
altro in corsivo e grassetto
 */

public interface Elaborate {
    String writeText(String str);
}
