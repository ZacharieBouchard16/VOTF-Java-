import java.util.Random;

public class Enemy extends Entity{
    static int aliveCount;

    //double expDrop;

    public Enemy(String name, int health, int strength, int defense, int intelligence, int speed, int luck) {
        super(name, health, strength, defense, intelligence, speed, luck);
        aliveCount++;
    }
    @Override
    public String getAction() {
        return "attack";
    }
    @Override
    public Entity getTarget() {
        int target;
        Random rand = new Random();
        do {
            target = rand.nextInt(Overworld.heroes.length);
        }
        while (!Overworld.heroes[target].isAlive || !Overworld.heroes[target].isUnlocked);
        return Overworld.heroes[target];
    }
    @Override
    public int getAttack() {
        int attackNum;
        Random rand = new Random();
        attackNum = rand.nextInt(attack.length);
        do {
            mana[0] -= attack[attackNum].cost;
            if (mana[0] < 0) {
                mana[0] += attack[attackNum].cost;
            }
        }
        while (mana[0] < 0);
        return attackNum;
    }
}
