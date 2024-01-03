package exams.e2016_07_06.exercise_2;

public class Strategy {
    private Vehicle vehicle;

    public void evaluateStrategy(String comfort, int price){
        if (comfort.equals("economy")) {
            switch (price) {
                case 3:
                    this.vehicle = new EconomyVehicle(EconomyVehicle.Type.METRO);
                    break;
                
                case 5:
                    this.vehicle = new EconomyVehicle(EconomyVehicle.Type.BUS);
                    break;
                
                case 30:
                    this.vehicle = new EconomyVehicle(EconomyVehicle.Type.CAR);
                    break;
                default:
                    break;
            }
        }
        else if(comfort.equals("business")){
            switch (price) {
                case 80:
                    this.vehicle = new BusinessVehicle(BusinessVehicle.Type.TAXI);
                    break;
                
                case 15:
                    this.vehicle = new BusinessVehicle(BusinessVehicle.Type.SHUTTLE);
                    break;

                default:
                    break;
            }
        }
        else
        {
            switch (price) {
                case 200:
                    this.vehicle = new EliteVehicle(EliteVehicle.Type.LIMO);
                    break;
                
                case 2000:
                    this.vehicle = new EliteVehicle(EliteVehicle.Type.HELI);
                    break;

                default:
                    break;
            }
        }

    }
    
    public void setStrategy(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void use(){
        this.vehicle.use();
    }

    public static void main(String[] args) {
        Strategy getToPlane = new Strategy();
        getToPlane.evaluateStrategy("elite", 2000);
        getToPlane.use();
    }
}
