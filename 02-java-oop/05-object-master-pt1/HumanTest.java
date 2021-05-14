class HumanTest{
    public static void main(String[] args){
        Human aragorn = new Human();
        Human enemy = new Human();
        aragorn.attackEnemy(enemy);
        aragorn.attackEnemy(enemy);
        aragorn.attackEnemy(aragorn);
        aragorn.displayStats();
    }
}