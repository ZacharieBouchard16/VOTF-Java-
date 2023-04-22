import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Battle {
    ArrayList<Entity> warriors = new ArrayList<>(3);
    Random rand = new Random();
    EnemyList list = new EnemyList();
    static Enemy enemies[];
    public void initializeEnemy(int amount, int world) {
        enemies = new Enemy[amount];
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

    public void warriorSort() {
        int size = warriors.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (warriors.get(j).speed <= warriors.get(j + 1).speed) {
                    Entity temp = warriors.get(j);
                    warriors.set(j, warriors.get(j + 1));
                    warriors.set((j + 1), temp);
                }
            }
        }
    }
    public void engageFight() {
        for (Heroes hero : Overworld.heroes) {
            if (hero.isUnlocked) {
                warriors.add(hero);
            }
            else {
                break;
            }
        }
        warriors.addAll(Arrays.asList(enemies));
        warriorSort();
        System.out.print("A fight draws near");
        //Everything up to the boolean is to figure out how to be grammatically correct. Java why can't you do this for me.
        for (int i = 0; i < enemies.length - 1; i++) {
            System.out.print((enemies[i].name.charAt(0) == 'A' || enemies[i].name.charAt(0) == 'I' ? ", an " : ", a ")
                    + enemies[i].name
            );
        }
        System.out.print((enemies[enemies.length - 1].name.charAt(0) == 'A' || enemies[enemies.length - 1].name.charAt(0) == 'I' ? " and an " : " and a ")
                + enemies[enemies.length - 1].name + " appeared!\n"
        );
        boolean victory = false;
        while (!victory) {
            for (Entity attacker : warriors) {
                if (!((Overworld.heroes[0].isAlive && Overworld.heroes[0].isUnlocked) || (Overworld.heroes[1].isAlive && Overworld.heroes[1].isUnlocked) || (Overworld.heroes[2].isAlive && Overworld.heroes[2].isUnlocked))) {
                    System.out.println("Your heroes have died. You lost.");
                    System.exit(0);

                }

                if (Enemy.aliveCount == 0) {
                    victory = true;
                    break;
                }

                if (attacker.getClass() == Heroes.class) {
                    unitHealth(attacker);
                }

                String choice = attacker.getAction();
                switch (choice) {
                    case "attack" -> attack(attacker, attacker.getTarget());
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
            //The two conditions are basically interchangeable but the issue here is that if I put both in I still have to check if one is true because I have to set victory.
        }
        System.out.println("Initiate drops");
    }
    public void unitHealth(Entity current) {
        for (Heroes hero : Overworld.heroes) {
            if (hero.isUnlocked && hero.isAlive) {
                if (hero.name.equals(current.name)) {
                    System.out.println("> " + hero.name + " " + hero.getHealth() + " " + hero.getMana());
                }
                else {
                    System.out.println(hero.name + " " + hero.getHealth() + " " + hero.getMana());
                }
            }
        }
        System.out.println("\n");
        for (Enemy enemy : enemies) {
            if (enemy.isAlive) {
                System.out.println(enemy.name + " " + enemy.getHealth() + " " + enemy.getMana());
            }
        }
        System.out.println("\n");
    }

    //TODO Add more sleeping in the attack options
    public void attack(Entity caster, Entity target) {
        int attackNum = caster.getAttack();
        if (caster.attack[attackNum].damage - target.defense <= 0) {
            System.out.println(caster.name + " has attacked " + target.name + " with " + caster.attack[attackNum].name + " but they were too weak and did no damage!\n");
        }
        else {
            System.out.println(caster.name + " has attacked " + target.name + " with " + caster.attack[attackNum].name + " for " + (caster.attack[attackNum].damage - target.defense) + " damage!\n");
            target.health[0] -= caster.attack[attackNum].damage - target.defense;
        }
        if (target.health[0] <= 0) {
            target.isAlive = false;
            warriors.remove(target);
            System.out.println(target.name + " has died!");
            if (target.getClass() == Enemy.class) {
                Enemy.aliveCount--;
            }
        }
    }
}
