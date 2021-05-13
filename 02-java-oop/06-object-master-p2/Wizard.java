public class Wizard extends Human {
    public Wizard() {
		this.health= 50;
        this.intelligence = 8;
	}
    public void heal(Human target){
        target.health += this.intelligence;
        System.out.println("Wizard healed group for "+ this.intelligence + ".");
    }
    public void fireball(Human target){
        target.health -= this.intelligence * 3;
        System.out.println("Wizard attacked with Fireball! Enemy took " + this.intelligence*3 + " damage!");
    }
    public void attackEnemy(Human target){
        target.health -=this.strength;
        System.out.println("Attack hits for "+ this.strength + " damage. Enemy has " + target.health + " health remaining.");
    }
}