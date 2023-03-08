import java.util.Random;
import java.util.Arrays;

public class Battle {
    Random rand = new Random();
    EnemyList list = new EnemyList();
    static Enemy enemies[];
    boolean heroHasAttacked[] = new boolean[Overworld.sortedHeroes.length];
    boolean enemyHasAttacked[];
    Heroes hCurrent;
    Enemy eCurrent;

    public void initializeEnemy(int amount, int world) {
        enemies = new Enemy[amount];
        enemyHasAttacked = new boolean[enemies.length];
        //I wish these could be combined
        switch (world) {
            case 1 -> {
                for (int i = 0; i < amount; i++) {
                    enemies[i] = list.grassEnemyList(rand.nextInt(4));
                }
            }
            case 2 -> {
                for (int i = 0; i < amount; i++) {
                    enemies[i] = list.marshEnemyList(rand.nextInt(4));
                }
            }
            case 3 -> {
                for (int i = 0; i < amount; i++) {
                    enemies[i] = list.volcanoEnemyList(rand.nextInt(4));
                }
            }
            case 4 -> {
                for (int i = 0; i < amount; i++) {
                    enemies[i] = list.hellEnemyList(rand.nextInt(4));
                }
            }
            case 5 -> {
                for (int i = 0; i < amount; i++) {
                    enemies[i] = list.castleEnemyList(rand.nextInt(4));
                }
            }
        }
        engageFight();
    }

    //TODO enemySort is inverted
    public void enemySort() {
        int size = enemies.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (enemies[j].speed > enemies[j + 1].speed) {
                    Enemy temp = enemies[j];
                    enemies[j] = enemies[j + 1];
                    enemies[j + 1] = temp;
                }
            }
        }
    }
    public void engageFight() {
        enemySort();
        System.out.print("A fight draws near");
        //Everything up to the boolean is to figure out how to be grammatically correct. Java why can't you do this for me.
        for (int i = 0; i < enemies.length - 1; i++) {
            System.out.print((enemies[i].name.charAt(0) == 'A' || enemies[i].name.charAt(0) == 'I' ? ", an " : ", a ")
                    + enemies[i].name
            );
        }
        System.out.print((enemies[enemies.length - 1].name.charAt(0) == 'A' || enemies[enemies.length - 1].name.charAt(0) == 'I' ? " and an " : " and a ")
                + enemies[enemies.length - 1].name + " appeared!"
        );
        boolean victory = false;
        while (!victory) {
            //The two conditions are basically interchangeable but the issue here is that if I put both in I still have to check if one is true because I have to set victory.
            if (!((Overworld.sortedHeroes[0].isAlive && Overworld.sortedHeroes[0].isUnlocked) || (Overworld.sortedHeroes[1].isAlive && Overworld.sortedHeroes[1].isUnlocked) || (Overworld.sortedHeroes[2].isAlive && Overworld.sortedHeroes[2].isUnlocked))) {
                System.out.println("Your heroes have died. You lost.");
                System.exit(0);

            }
            if (Enemy.aliveCount == 0) {
                victory = true;
                continue;
            }
            int type = currentAttacker();
            if (type == 0) {
                switch (attackMenu()) {
                    case "attack" -> {
                        System.out.println("Select the position of the enemy you want to attack");
                        int target = -1;
                        do {
                            try {
                                target = Keyboard.readInt() - 1;
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.err.println("Invalid target!");
                            }
                        }
                        while (!(target >= enemies.length) && !enemies[target].isAlive);

                        attack(hCurrent, target);
                    }
                    case "item" -> {
                        //Item()
                        System.out.println("WIP");
                    }
                    case "run" -> {
                        //Run();
                        System.out.println("WIP2");
                    }
                }
            }
            else if (type == 1){
                int target;
                do {
                    target = rand.nextInt(Overworld.sortedHeroes.length);
                }
                while (!(Overworld.sortedHeroes[target].isUnlocked && Overworld.sortedHeroes[target].isAlive));
                attack(eCurrent, target);
            }
        }
        System.out.println("Initiate drops");
    }
    public boolean isFilled(boolean arr[]) {
        //I have no ideas why Arrays doesn't have this
        boolean filled = true;
        for (boolean b : arr) {
            if (!b) {
                filled = false;
                break;
            }
        }
        return filled;
    }
    public int currentAttacker() {
        if (isFilled(heroHasAttacked) && isFilled(enemyHasAttacked)) {
            Arrays.fill(heroHasAttacked, false);
            Arrays.fill(enemyHasAttacked, false);
        }
        int type;
        int index[] = {-1, -1}; //This DEFINITELY caused me some stupid problems
        //I know the next two loop through the same thing, but I need the information from the first in order to do the second
        for (int i = 0; i < Overworld.sortedHeroes.length; i++) {
            if (!Overworld.sortedHeroes[i].isUnlocked) {
                heroHasAttacked[i] = true;
            }
        }
        for (int i = 0; i < Overworld.sortedHeroes.length; i++) {
            if (!heroHasAttacked[i]) {
                index[0] = i;
                break;
            }
        }
        for (int i = 0; i < enemies.length; i++) {
            if (!enemyHasAttacked[i]) {
                index[1] = i;
                break;
            }
        }
        if (isFilled(enemyHasAttacked) || (!heroHasAttacked[index[0]] && (Overworld.sortedHeroes[index[0]].speed >= enemies[index[1]].speed))) {
            type = 0;
            hCurrent = Overworld.sortedHeroes[index[0]];
            heroHasAttacked[index[0]] = true;
        }
        else {
            type = 1;
            eCurrent = enemies[index[1]];
            enemyHasAttacked[index[1]] = true;
        }
        return type;
    }
    public String attackMenu() {
        for (Heroes hero : Overworld.heroes) {
            if (!hero.isUnlocked) {
                break;
            }
            if (hero.name.equals(hCurrent.name)) {
                System.out.printf("> %-16s %s\n", hero.name, hero.health[0] + "/" + hero.health[1]);
            }
            else {
                System.out.printf("%-16s %s\n", hero.name, hero.health[0] + "/" + hero.health[1]);
            }
        }
        System.out.println("\n");
        for (Enemy enemy : enemies) {
            if (enemy.isAlive) {
                System.out.printf("%-16s %s\n", enemy.name, enemy.health[0] + "/" + enemy.health[1]);
            }
        }
        System.out.println("What will I do?");
        System.out.println("- Attack");
        System.out.println("- Item");
        System.out.println("- Run");
        System.out.print("Your choice: ");
        String choice = Keyboard.readString().toLowerCase().trim();
        while (!(choice.contains("attack") || choice.contains("item") || choice.contains("run") )) {
            System.err.println("Invalid Option!");
            choice = Keyboard.readString().toLowerCase().trim();
        }
        return choice;
    }

    //TODO Add more sleeping in the attack options
    //TODO Replace the index ints by Objects
    public void attack(Enemy caster, int target) {
        int attackNum = rand.nextInt(caster.attack.length);
        do {
            caster.mana -= caster.attack[attackNum].cost;
            if (caster.mana < 0) {
                caster.mana += caster.attack[attackNum].cost;
            }
        }
        while (caster.mana < 0);
        if (caster.attack[attackNum].damage - Overworld.sortedHeroes[target].defense <= 0) {
            System.out.println(caster.name + " has attacked " + Overworld.sortedHeroes[target].name + " with " + caster.attack[attackNum].name + " but they were too weak and did no damage!");
        }
        else {
            System.out.println(caster.name + " has attacked " + Overworld.sortedHeroes[target].name + " with " + caster.attack[attackNum].name + " for " + (caster.attack[attackNum].damage - Overworld.sortedHeroes[target].defense) + " damage!");
        }
        Overworld.heroes[target].health[0] -= caster.attack[attackNum].damage - Overworld.sortedHeroes[target].defense;
        if (Overworld.heroes[target].health[0] <= 0) {
            Overworld.heroes[target].isAlive = false;
            System.out.println(Overworld.heroes[target] + " has died!");
        }
    }
    public void attack(Heroes caster, int target) {
        System.out.println("Choose the position of the attack you want to use");
        for (Attack atk : caster.attack) {
            if (atk == null) {
                break;
            }
            System.out.printf("\n- %-16s Damage: %-4d Accuracy: %-4d Cost: %d mana", atk.name, atk.damage, atk.accuracy, atk.cost);
        }
        System.out.print("\nYour choice: ");
        int attackNum;
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
            caster.mana[0] -= caster.attack[attackNum].cost;
            if (caster.mana[0] < 0) {
                System.err.println("I don't have enough mana...");
                caster.mana[0] += caster.attack[attackNum].cost;
            }
            else {
                confirm[1] = true;
            }

        }
        while (!(confirm[0] && confirm[1]));
        if (caster.attack[attackNum].damage - enemies[target].defense <= 0) {
            System.out.println(caster.name + " has attacked " + enemies[target].name + " with " + caster.attack[attackNum].name + "but they were too weak and did no damage!");
        }
        else {
            System.out.println(caster.name + " has attacked " + enemies[target].name + " with " + caster.attack[attackNum].name + " for " + (caster.attack[attackNum].damage - enemies[target].defense) + " damage!");
            enemies[target].health[0] -= caster.attack[attackNum].damage - enemies[target].defense;
        }
        if (enemies[target].health[0] <= 0) {
           enemies[target].isAlive = false;
           System.out.println(enemies[target].name + " has died!");
        }
    }
}
