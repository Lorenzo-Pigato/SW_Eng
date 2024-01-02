package Exercise.Exercise_16;

/*
Esercizio 5 / Strategy

Considera un'applicazione di elaborazione del testo che deve eseguire diverse
operazioni di formattazione del testo.

    👉  Deﬁnisci un'interfaccia TextFormatter con un metodo formatText(String text).
    
    👉  Implementa tre classi che implementano l'interfaccia TextFormatter:
            - UpperCaseFormatter: Converte il testo di input in maiuscolo.
            - LowerCaseFormatter: Converte il testo di input in minuscolo.
            - TitleCaseFormatter: Converte il testo di input in maiuscolo all'inizio di ogni parola.
    
    👉  Crea una classe TextEditor che ha un campo TextFormatter. Questa classe
        dovrebbe avere un metodo string formatText(String text) che delega la
        formattazione alla strategia.
    
    👉 Permetti agli utenti di impostare dinamicamente la strategia di formattazione.
 */

public class TextEditor {
    private TextFormatter formattingStrategy;

    public void setFormatting(TextFormatter formattingStrategy) {
        this.formattingStrategy = formattingStrategy;
    }

    public String format(String text) {
        return formattingStrategy.formatText(text);
    }

    public static void main(String[] args) {

        TextFormatter[] formatting = {  new UpperCaseFormatter(),
                                        new LowerCaseFormatter(),
                                        new TitleCaseFormatter()};
        
        TextEditor editor = new TextEditor();

        for (TextFormatter format : formatting) {
            editor.setFormatting(format);
            System.out.println(editor.format("lorem ipsum"));
        }
    }
}
