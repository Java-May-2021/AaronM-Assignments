class GorillaTester{
    public static void main(String[] args){
        Gorilla congo = new Gorilla(500);
        Mammal monkey = new Mammal(50);
        congo.throwSomething();
        congo.throwSomething();
        congo.throwSomething();
        congo.eatBanana();
        congo.eatBanana();
        congo.climb();
        congo.displayEnergy();
        monkey.displayEnergy();
    }
}