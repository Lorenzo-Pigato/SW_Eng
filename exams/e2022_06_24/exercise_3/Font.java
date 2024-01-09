package exams.e2022_06_24.exercise_3;

public class Font implements Elaborate {
    private Format format = null;
    private Color color = null;
    private Elaborate origin;

    public Font(Elaborate origin, Format format){
        this.format = format;
        this.origin = origin;
    }

    public Font(Elaborate origin, Color color){
        this.color = color;
        this.origin = origin;
    }

    public Font(Elaborate origin, Format format, Color color){
        this.format = format;
        this.color = color;
        this.origin = origin;
    }

    @Override
    public String writeText(String str) {
        return (color != null ? color.getCode() : "") + 
                (format != null ? format.getCode() : "") + 
                origin.writeText(str) + 
                Format.RESET.getCode();
    }

    enum Format {
        RESET("\u001B[0m"),
        BOLD("\u001B[1m"),
        ITALIC("\u001B[3m"),
        UNDERLINE("\u001B[4m");

        String code;

        Format(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }

    enum Color {
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }
}

class Select {
    public Elaborate apply(Elaborate text, String modifier) {
        
        for (Font.Format format : Font.Format.values() ) {
            if(format.name().equalsIgnoreCase(modifier)){
                return new Font(text, format);
            }
        }

        for (Font.Color color : Font.Color.values() ) {
            if(color.name().equalsIgnoreCase(modifier)){
                return new Font(text, color);
            }
        }

        return null;
    }
}