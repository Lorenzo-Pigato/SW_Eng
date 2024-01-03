package exams.e2016_07_06.exercise_2;

/*
    Si progetti un semplice sistema ad oggetti per consentire ad una persona di raggiungere l’aeroporto con diversi mezzi di
    trasporto. Una persona potrebbe: guidare la propria macchina, prendere un taxi, uno shuttle per l’aeroporto, un autobus, o usare
    un servizio di limousine. In alcuni casi, si potrebbe pensare anche all’uso della metropolitana e di un elicottero. Tutti questi
    mezzi di trasporto potrebbero essere usati dalla stessa persona in momenti diversi e tutti consentono alla persona di raggiungere
    l’aeroporto. La scelta sarà influenzata dai costi, dal tempo richiesto/a disposizione e anche dal confort di viaggio richiesto.
    1. Si definisca un diagramma delle classi UML, magari sfruttando il design pattern Strategy.
    2. Si scriva la struttura delle classi principali in Java.
 */
public abstract class Vehicle {
    abstract String getComfort();
    abstract void use();
}

class EconomyVehicle extends Vehicle{
    enum Type{
        CAR("Car", 30, 20),
        BUS("Bus", 3, 40),
        METRO("Metro", 5, 15);
        

        String vehicleType;
        int price;
        int time;

        Type(String name, int price, int time){
            this.vehicleType = name;
            this.price = price;
            this.time = time;
        }
        
        public int getPrice() {
            return price;
        }

        public int getTime() {
            return time;
        }

        public String getVehicleType() {
            return vehicleType;
        }
    }

    private Type type;

    public EconomyVehicle(Type type){
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String getComfort(){
        return "economy";
    }
    
    @Override
    public void use() {
        System.out.println("Travelling by " + this.type.getVehicleType());
    }
}

class BusinessVehicle extends Vehicle{
    enum Type{
        TAXI("taxi", 80, 20),
        SHUTTLE("Shuttle", 15, 30);
        

        String vehicleType;
        int price;
        int time;

        Type(String name, int price, int time){
            this.vehicleType = name;
            this.price = price;
            this.time = time;
        }
        
        public int getPrice() {
            return price;
        }

        public int getTime() {
            return time;
        }

        public String getVehicleType() {
            return vehicleType;
        }
    }

    private Type type;

    public BusinessVehicle(Type type){
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String getComfort(){
        return "business";
    }
    
    @Override
    public void use() {
        System.out.println("Travelling by " + this.type.getVehicleType());
    }
}

class EliteVehicle extends Vehicle{
    enum Type{
        LIMO("Limousine", 200, 20),
        HELI("Helicopter", 2000, 2);
        

        String vehicleType;
        int price;
        int time;

        Type(String name, int price, int time){
            this.vehicleType = name;
            this.price = price;
            this.time = time;
        }
        
        public int getPrice() {
            return price;
        }

        public int getTime() {
            return time;
        }

        public String getVehicleType() {
            return vehicleType;
        }
    }

    private Type type;

    public EliteVehicle(Type type){
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String getComfort(){
        return "elite";
    }
    
    @Override
    public void use() {
        System.out.println("Travelling by " + this.type.getVehicleType());
    }
}

