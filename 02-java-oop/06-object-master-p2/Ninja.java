public class Ninja extends Human {
    public Ninja() {
        this.stealth = 10;
	}
    public void runAway(){
        this.health -= 10;
        if (this.health <= 0){
            this.health += 10;
            System.out.println("Ninja Can not run away. Not enough health.");
        }
        else{ 
        System.out.println("Ninja ran away and now has "+ this.health + " health.");
        }
    }
    public void steal(Human target){
        target.health -= this.stealth;
        this.health += this.stealth;
        System.out.println("Ninja performed! Enemy took "+this.stealth+" damage. Ninja gained " + this.stealth + " health!");
    }
    public void attackEnemy(Human target){
        target.health -=this.strength;
        System.out.println("Attack hits for "+ this.strength + " damage. Enemy has " + target.health + " health remaining.");
    }
}