public class Heroes {
    String name;
    int health[] = new int[2]; // [0] = current | [1] = max
    int strength;
    int defense;
    int intelligence;
    int speed;
    int luck;
    int mana[] = new int[2]; //[0] = current | [1] = max

    double exp;
    int level;

    boolean isAlive = true;
    boolean isUnlocked = false;

    //int sortedLocation;

    Attack attack[] = new Attack[4];

    public Heroes(String name, int health, int strength, int defense, int intelligence, int speed, int luck, double exp, int level) {
        this.name = name;
        this.health[0] = this.health[1] = health;
        this.strength = strength;
        this.defense = defense;
        this.intelligence = intelligence;
        this.speed = speed;
        this.luck = luck;
        this.exp = exp;
        this.level = level;

        mana[0] = mana[1] = 100 + (intelligence * 3);
    }
    public void Display() {
        String string = String.format("Name: %-16s Health: %-9s Mana: %-9s Strength: %-4d Defense: %-4d Intelligence: %-4d Speed: %-4d Luck: %-4d\n Attacks:", name, health[0] + "/" + health[1], mana[0] + "/" + mana[1], strength, defense, intelligence, speed, luck);
        for (Attack value : attack) {
            if (value == null) {
                break;
            } else {
                string += String.format("\n \t- %-16s Damage: %-4d Accuracy: %-4d Cost: %d mana", value.name, value.damage, value.accuracy, value.cost);
            }
        }
        System.out.println(string);
    }
}
