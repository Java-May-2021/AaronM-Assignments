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
        System.out.println("Wizard attacked with Fireball! Enemey took " + this.intelligence*3 + " damage!");
    }
}