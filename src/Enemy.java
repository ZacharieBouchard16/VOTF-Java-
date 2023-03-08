public class Enemy {
    String name;
    int health[] = new int[2]; //[0] = current | [1] = max
    int strength;
    int defense;
    int intelligence;
    int speed;
    int luck;
    int mana;

    int level;

    static int aliveCount;

    boolean isAlive = true;

    double expDrop;
    Attack attack[];

    public Enemy(String name, int health, int strength, int defense, int intelligence, int speed, int luck) {
        this.name = name;
        this.health[0] = this.health[1] = health;
        this.strength = strength;
        this.defense = defense;
        this.intelligence = intelligence;
        this.speed = speed;
        this.luck = luck;
        aliveCount++;

        mana = 100 + (intelligence * 3);
    }
}
