public class Samurai extends Human {
    private static int samNum = 0;
    public Samurai() {
		this.health= 200;
        this.strength = 7;
        samNum +=1;
        System.out.println("There are " + samNum + " Samurai in this dojo!");
	}
    public void meditate(){
        this.health += this.health*.5;
        if (this.health > 200){
            this.health = 200;
        }
        System.out.println("Samurai Meditated and now has "+ this.health + " health.");
    }
    public void deathBlow(Human target){
        target.health= 0;
        this.health = (this.health/2);
        System.out.println("Samurai attacked with Death Blow! Enemy killed. Samurai took " + this.health + " damage!");
    }
    public void attackEnemy(Human target){
        target.health -=this.strength;
        System.out.println("Attack hits for "+ this.strength + " damage. Enemy has " + target.health + " health remaining.");
    }
}