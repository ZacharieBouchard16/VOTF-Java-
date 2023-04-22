import java.util.Arrays;

public class Heroes extends Entity{

    static Inventory inventory = new Inventory(5, 0, 2, 0, 0);

    //double exp;
    boolean isUnlocked = false;

    public Heroes(String name, int health, int strength, int defense, int intelligence, int speed, int luck) {
        super(name, health, strength, defense, intelligence, speed, luck);
        super.attack = new Attack[4];
    }
    public void display() {
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
    @Override
    public String getAction() {
        return Prints.choice("battleMenu");
    }
    @Override
    public Entity getTarget() {
        System.out.println("Select the position of the enemy you want to attack");
        int target = Keyboard.readInt();
        while (target == -1 || target > Battle.enemies.length || !Battle.enemies[target - 1].isAlive) {
            System.err.println("Invalid target!");
            target = Keyboard.readInt();
        }
        return Battle.enemies[target - 1];
    }
    @Override
    public int getAttack() {
        int attackNum;
        System.out.println("Choose the position of the attack you want to use");
        for (Attack atk : attack) {
            if (atk == null) {
                break;
            }
            System.out.printf("\n- %-16s Damage: %-4d Accuracy: %-4d Cost: %d mana", atk.name, atk.damage, atk.accuracy, atk.cost);
        }
        System.out.print("\nYour choice: ");
        boolean confirm[] = new boolean[2];
        do {
            Arrays.fill(confirm, false); //Not needed for the first loop but needed after in case someone fucks it up
            attackNum = Keyboard.readInt() - 1;
            if (attackNum < 0 || attackNum > 4) {
                System.err.println("Invalid attack!");
                continue; //Why bother if it's false
            }
            else {
                confirm[0] = true;
            }
            mana[0] -= attack[attackNum].cost;
            if (mana[0] < 0) {
                System.err.println("I don't have enough mana...");
                mana[0] += attack[attackNum].cost;
            }
            else {
                confirm[1] = true;
            }

        }
        while (!(confirm[0] && confirm[1]));
        return attackNum;
    }
}
