class DungeonsAndDragonsTest{
    public static void main(String[] args){
        Human enemy = new Human();
        Human aragorn = new Human();
        Wizard gandalf = new Wizard();
        Samurai john = new Samurai();
        Samurai jack = new Samurai();
        Ninja  hanzo = new Ninja();

        gandalf.attackEnemy(enemy);
        gandalf.heal(aragorn);
        gandalf.fireball(enemy);
        gandalf.displayStats();

        jack.attackEnemy(enemy);
        jack.meditate();
        jack.deathBlow(enemy);
        jack.displayStats();

        hanzo.steal(enemy);
        hanzo.runAway();
        hanzo.attackEnemy(enemy);
        hanzo.displayStats();
        
        aragorn.attackEnemy();
        aragorn.attackEnemy();
        aragorn.attackEnemy(enemy);
        aragorn.displayStats();
    }
}