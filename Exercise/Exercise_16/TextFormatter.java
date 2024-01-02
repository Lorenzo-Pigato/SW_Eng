package Exercise.Exercise_16;

import java.lang.StringBuilder;

/*
 * 👉 Deﬁnisci un'interfaccia TextFormatter con un metodo formatText(String
 * text).
 * 
 * 👉 Implementa tre classi che implementano l'interfaccia TextFormatter:
 * - UpperCaseFormatter: Converte il testo di input in maiuscolo.
 * - LowerCaseFormatter: Converte il testo di input in minuscolo.
 * - TitleCaseFormatter: Converte il testo di input in maiuscolo all'inizio di
 * ogni parola.
 * 
 */

public interface TextFormatter {
    public String formatText(String text);
}

class UpperCaseFormatter implements TextFormatter{
    
    @Override
    public String formatText(String text){
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter{
    
    @Override
    public String formatText(String text){
        return text.toLowerCase();
    }
    
}

class TitleCaseFormatter implements TextFormatter{
    
    @Override
    public String formatText(String text){
        String[] words = text.split(" ");
        StringBuilder formatter = new StringBuilder();
        
        for (String word : words) {
            formatter.append(word.toUpperCase().charAt(0));
            formatter.append(word.toLowerCase().substring(1));
            formatter.append(" ");
        }
            
        return formatter.toString();
    }
}
