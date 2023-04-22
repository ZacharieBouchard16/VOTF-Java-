public abstract class Entity {
    String name;
    int health[] = new int[2]; // [0] = current | [1] = max
    int strength;
    int defense;
    int intelligence;
    int speed;
    int luck;
    int mana[] = new int[2]; //[0] = current | [1] = max

    //int level = 0;

    boolean isAlive = true;
    Attack attack[];

    public Entity(String name, int health, int strength, int defense, int intelligence, int speed, int luck) {
        this.name = name;
        this.health[0] = this.health[1] = health;
        this.strength = strength;
        this.defense = defense;
        this.intelligence = intelligence;
        this.speed = speed;
        this.luck = luck;

        mana[0] = mana[1] = 100 + (intelligence * 3);
    }
    public String getHealth() {
        return String.format("HP: %s", this.health[0] + "/" + this.health[1]);
    }
    public String getMana() {
        return String.format("MP: %s", this.mana[0] + "/" + this.mana[1]);
    }
    public abstract String getAction();
    public abstract Entity getTarget();
    public abstract int getAttack();
}
