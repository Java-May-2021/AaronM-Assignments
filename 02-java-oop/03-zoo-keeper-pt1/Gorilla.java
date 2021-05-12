public class Gorilla extends Mammal {
    public Gorilla(int energyLevel) {
		super(energyLevel);
        System.out.println("Gorilla created! Current Energy Level: "+energyLevel);
	}
    public void throwSomething(){
        energyLevel -=5;
        System.out.println("Threw ****. Minus 5 Energy.");
    }
    public void eatBanana(){
        energyLevel +=5;
        System.out.println("Ate a banana. Plus 10 Energy!");
    }
    public void climb(){
        energyLevel -=10;
        System.out.println("Climbed a rope. Minus 10 Energy.");
    }

    public void displayEnergy(){
        System.out.println("Gorilla's Current Energy: " + energyLevel);
    }
}