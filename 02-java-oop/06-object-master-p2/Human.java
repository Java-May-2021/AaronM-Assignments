public class Human{
    protected int health = 100;
    protected int strength = 3;
    protected int stealth = 3;   
    protected int intelligence = 3;

    public void attackEnemy(Human target){
        target.health -=this.strength;
        System.out.println("Attack hits for "+ this.strength + " damage. Enemy has " + target.health + " health remaining.");
    }

    public void displayStats(){
        System.out.println("Your Character Stats ");
        System.out.println("              Health: " + health);
        System.out.println("            Strength: " + strength);
        System.out.println("             Stealth: " + stealth);
        System.out.println("        Intellegence: " + intelligence);
    } 
}