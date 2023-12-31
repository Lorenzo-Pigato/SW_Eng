package Exercise.Extra;

/* 
    Esercizio 3 - Pokèmon
    Un Pokèmon ha un nome, un tipo (normale, erba, fuoco, acqua), un
    fattore di forza e dei punti vita.
    Un Pokèmon può attaccare un altro Pokèmon, in tal caso, gli
    procura un danno pari al fattore di forza, eventualmente aumentato
    del 20% in caso di superefficacia.
    Un attacco è superefficace in base al confronto dei tipi di attaccante
    e avversario:
    (erba à acqua, acqua à fuoco, fuoco à erba)
    Ditto è un Pokèmon particolare di tipo normale. Quando attacca un
    Pokèmon, ne acquisisce il tipo. Questa «trasformazione» rimane
    attiva fino a che i suoi punti vita non scendono sotto i 10. Quando
    ciò succede, Ditto ritorna di tipo normale.
*/

public class Pokemon {
    private String name;
    protected Type type;
    private int pp;
    protected int ps;

    public Pokemon (String name, Type type, int pp, int ps){
        this.name = name;
        this.type = type;
        this.pp = pp;
        this.ps = ps;
    }

    public Pokemon (String name, Type type, int pp){
        this.name = name;
        this.type = type;
        this.pp = pp;
        this.ps = 100;
    }

    public String getName() {
        return name;
    }

    public int getPp() {
        return pp;
    }

    public int getPs() {
        return ps;
    }

    public Type getType() {
        return type;
    }

    public void display() {
        System.out.println("Name :" + name);
        System.out.println("Type :" + type.getTypeString());
        System.out.println("Ps :" + ps);
        System.out.println("Pp :" + pp);
    }

    protected void getDamage(int pp){
        this.ps -= pp;
    }
    
    public void attack(Pokemon pokemon){
        if(pp == 0)
        {
            System.out.println(pokemon.name + " can't fight anymore");
            return;
        }

        if(pokemon.ps == 0)
        {
            System.out.println("Enemy " + pokemon.getName() + " can't fight anymore, you can't attack it");
        }

        System.out.println(this.getName() + " attacks " + pokemon.getName());
        
        if(this.type.isSuperEffective(pokemon.type)){
            System.out.println("It's Supereffective!");
            pokemon.getDamage(2*pp);
        }
        else pokemon.getDamage(pp);

        if (pokemon.ps <= 0) {
            pokemon.ps = 0;
            System.out.println(pokemon.getName() + " is exhausted");
            pokemon.pp = 0;
        }
        else
            pokemon.display();
        
            System.out.println("------------");
    }


    public static void main(String[] args) {
        Ditto ditto = new Ditto(100, 15);
        Pokemon charizard = new Pokemon("Charizard", Type.FIRE, 45, 100);

        charizard.attack(ditto);
        ditto.attack(charizard);
        ditto.attack(charizard);
        charizard.attack(ditto);
        charizard.attack(ditto);
    }
}

enum Type {
        GRASS("Grass"),
        WATER("Water"),
        NORMAL("Normal"),
        FIRE("Fire");

        final private String typeString;

        Type (String type){
            this.typeString = type;
        }

        public String getTypeString() {
            return typeString;
        }

        public boolean isSuperEffective(Type type){
            if (this == GRASS && type == FIRE) return true;
            if (this == FIRE && type == WATER) return true;
            if (this == WATER && type == GRASS) return true;
            return false;
        }
}

class Ditto extends Pokemon{
    public Ditto(int ps, int pp){
        super("Ditto", Type.NORMAL, pp, ps);
    }

    @Override
    public void attack(Pokemon pokemon){
        if(this.getPs() > 10)
        {
            this.type = pokemon.getType();
            System.out.println("Ditto is now " + pokemon.getName());
        }
        
        super.attack(pokemon);
    }

    @Override
    public void getDamage(int pp){
        this.ps -= pp;
        if(this.ps <= 10){
            this.type = Type.NORMAL;
            System.out.println("Ditto is now itself again!");
        }
    }
}
