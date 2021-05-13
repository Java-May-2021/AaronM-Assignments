public class Human{
    protected int health = 100;
    protected int strength = 3;
    protected int stealth = 3;   
    protected int intelligence = 3;    
    protected int enemyHealth = 100;


    public void attackEnemey(){
        this.enemyHealth -=this.strength;
        System.out.println("Attack hits for "+ this.strength + " damage. Enemy has " + this.enemyHealth + " health remaining.");
    }

    public void displayStats(){
        System.out.println("Your Character Stats ");
        System.out.println("              Health: " + health);
        System.out.println("            Strength: " + strength);
        System.out.println("             Stealth: " + stealth);
        System.out.println("        Intellegence: " + intelligence);
    } 
}