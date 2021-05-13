class DungeonsAndDragonsTest{
    public static void main(String[] args){
        Human enemy = new Human();
        Human aragorn = new Human();
        // aragorn.attackEnemy(enemy);
        // aragorn.attackEnemy(enemy);
        // aragorn.attackEnemy(enemy);
        aragorn.displayStats();
        Wizard gandalf = new Wizard();
        gandalf.attackEnemy(enemy);
        gandalf.heal(aragorn);
        gandalf.fireball(enemy);
        gandalf.displayStats();
        aragorn.displayStats();
        Samurai jack = new Samurai();
        jack.attackEnemy(enemy);
        jack.meditate();
        jack.deathBlow(enemy);
        jack.displayStats();
        Ninja  hanzo = new Ninja();
        hanzo.steal(enemy);
        hanzo.runAway();
        hanzo.attackEnemy(enemy);
        hanzo.displayStats();
    }
}