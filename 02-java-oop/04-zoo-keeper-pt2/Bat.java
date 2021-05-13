public class Bat extends Mammal {
    public Bat(int energyLevel) {
		super(energyLevel);
        System.out.println("Bat Found! Current Energy Level: "+energyLevel);
	}
    public void fly(){
        energyLevel -=50;
        System.out.println("Bat is flying. Minus 50 Energy.");
    }
    public void eatHuman(){
        energyLevel +=5;
        System.out.println("Bat just ate a human. Plus 25 Energy!");
    }
    public void attackTown(){
        energyLevel -=100;
        System.out.println("Bat just attacked a city. Minus 100 Energy.");
    }

    public void displayEnergy(){
        System.out.println("The Bat's Current Energy: " + energyLevel);
    }
}