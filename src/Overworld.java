import java.util.Random;

public class Overworld {
    short area;
    static Heroes[] heroes = new Heroes[3];
    Random rand = new Random();
    Battle fight = new Battle();

    public void startGame() {
        heroes[0] = new Heroes(
                "Christopher",
                rand.nextInt(11) + 250,
                rand.nextInt(6) + 15,
                rand.nextInt(3) + 10,
                8,
                rand.nextInt(3) + 7,
                rand.nextInt(2) + 8
        );
        heroes[0].attack = new Attack[4];
        heroes[0].attack[0] = new Attack("Slash", 10 + (heroes[0].strength / 2), 100, 0);
        heroes[0].attack[1] = new Attack("Flames", 20 + (heroes[0].intelligence / 3), 100, 20);
        heroes[0].isUnlocked = true;
        heroes[1] = new Heroes(
                "Marquis",
                rand.nextInt(11) + 190,
                rand.nextInt(2) + 7,
                rand.nextInt(3) + 10,
                8,
                rand.nextInt(6) + 15,
                rand.nextInt(3) + 10
        );
        heroes[1].attack[0] = new Attack("Shoot", 15 + (heroes[1].strength / 2), 100, 0);
        heroes[1].attack[1] = new Attack("Piercing Arrow", 30 + (heroes[1].speed), 100, 45);
        heroes[2] = new Heroes(
                "Enyad",
                rand.nextInt(11) + 250,
                rand.nextInt(3) + 6,
                rand.nextInt(3) + 10,
                rand.nextInt(6) + 20,
                rand.nextInt(3) + 10,
                rand.nextInt(2) + 9
        );
        heroes[2].attack[0] = new Attack("Whack", 5 + (heroes[2].strength / 2), 100, 0);
        heroes[2].attack[1] = new Attack("Heal", -30 + (heroes[2].intelligence / 3), 100, 20);
        worldMovement();
    }
    public void worldMovement() {
        /*
        Grass = 0-15
        Marsh = 16-40
        Volcano = 41-70
        Hell = 71-105
        Castle = 106-150
         */
        while (area <= 151) {
            switch (Prints.choice("overworld")) {
                case "move" -> {
                    if (Prints.choice("moveSelect").equals("up")) {
                        if (moveConditions()) {
                            worldSwitch();
                            area += 1;
                        }
                    }
                    else {
                        if (area == 0) {
                            System.out.println("We cannot go further back!"); //This isn't in the conditions because it would cause issues with going down.
                        }
                        else {
                            worldSwitch();
                            area -= 1;
                        }
                    }
                }
                case "info" -> {
                    if (Prints.choice("displayType").equals("heroes")) {
                        for (Heroes hero : heroes) {
                            if (hero.isUnlocked) {
                                //I preferred to not use toString here because this looks nice
                                hero.display();
                            }
                        }
                    }
                    else {
                        Heroes.inventory.display();
                    }
                }
                case "save and quit" -> {
                    System.out.println("Quitting...");
                    System.exit(0);
                }
            }
        }
    }
    public boolean moveConditions() {
        if (area == 6 && !heroes[1].isUnlocked) {
            System.out.println("The silent archer, Marquis, has joined my party!");
            heroes[1].isUnlocked = true;
            return false;
        }
        else if (area == 25 && !heroes[2].isUnlocked) {
            System.out.println("The powerful healer Enyad has joined our party!");
            return false;
        }
        else if (area == 150) {
            System.out.println("You cannot go further forwards!");
            return false;
        }
        else {
            return true;
        }
    }
    public void worldSwitch() {
        if (area <= 15) {
            fight.initializeEnemy(rand.nextInt(3) + 1, 1);
        }
        else if (area <= 40){
            fight.initializeEnemy(rand.nextInt(3) + 1, 2);
        }
        else if (area <= 70) {
            fight.initializeEnemy(rand.nextInt(3) + 1, 3);
        }
        else if (area <= 105) {
            fight.initializeEnemy(rand.nextInt(3) + 1, 4);
        }
        else {
            fight.initializeEnemy(rand.nextInt(3) + 1, 5);
        }
    }
}
