class Mammal{
    protected int energyLevel = 100;
    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }
    public void displayEnergy(){
        System.out.println("Mammal's Current Energy: " + energyLevel);
    } 
}