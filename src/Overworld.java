import java.util.Random;

public class Overworld {
    short area;
    static Heroes[] heroes = new Heroes[3];
    static Heroes sortedHeroes[] = heroes;
    Inventory inventory = new Inventory(5, 0, 2, 0, 0);
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
                rand.nextInt(2) + 8,
                0,
                0
        );
        heroes[0].attack[0] = new Attack("Slash", 10 + (heroes[0].strength / 2), 100, 0);
        heroes[0].attack[1] = new Attack("Flames", 20 + (heroes[0].intelligence / 3), 100, 20);
        heroes[0].isUnlocked = true;
        //heroes[0].sortedLocation = 0;
        heroes[1] = new Heroes(
                "Marquis",
                rand.nextInt(11) + 190,
                rand.nextInt(2) + 7,
                rand.nextInt(3) + 10,
                8,
                rand.nextInt(6) + 15,
                rand.nextInt(3) + 10,
                0,
                0
        );
        heroes[1].attack[0] = new Attack("Shoot", 15 + (heroes[1].strength / 2), 100, 0);
        heroes[1].attack[1] = new Attack("Piercing Arrow", 30 + (heroes[1].speed), 100, 45);
        //heroes[1].sortedLocation = 1;
        heroes[2] = new Heroes(
                "Enyad",
                rand.nextInt(11) + 250,
                rand.nextInt(3) + 6,
                rand.nextInt(3) + 10,
                rand.nextInt(6) + 20,
                rand.nextInt(3) + 10,
                rand.nextInt(2) + 9,
                0,
                0
        );
        heroes[2].attack[0] = new Attack("Whack", 5 + (heroes[2].strength / 2), 100, 0);
        heroes[2].attack[1] = new Attack("Heal", -30 + (heroes[2].intelligence / 3), 100, 20);
        //heroes[2].sortedLocation = 2;
        heroSort();
        WorldMovement();
    }

    //TODO heroSort is currently inverted
    public void heroSort() {
        int size = sortedHeroes.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (sortedHeroes[j].speed > sortedHeroes[j + 1].speed) {
                    Heroes temp = sortedHeroes[j];
                    sortedHeroes[j] = sortedHeroes[j + 1];
                    sortedHeroes[j + 1] = temp;
                }
            }
        }
    }
    public void WorldMovement() {
        /*
        Grass = 0-15
        Marsh = 16-40
        Volcano = 41-70
        Hell = 71-105
        Castle = 106-150
         */
        while (area <= 151) {
            switch (Menu()) {
                case "move" -> {
                    if (movementSelection().equals("up") && moveConditions()) {
                        worldSwitch();
                        area += 1;
                    }
                    else {
                        if (area == 0) {
                            System.out.println("We cannot go further back!"); //This isn't in the conditions because it would cause issues with going down.
                        }
                        else {
                            //Call enemy
                            area += 1;
                        }
                    }
                }
                case "info" -> {
                    if (infoSelection().equals("heroes")) {
                        for (Heroes hero : heroes) {
                            if (hero.isUnlocked) {
                                //I preferred to not use toString here because this looks nice
                                hero.Display();
                            }
                        }
                    }
                    else {
                        inventory.Display();
                    }
                }
                case "save and quit" -> {
                    //This ironically stops everything, might change it to a system.exit
                    return;
                }
            }
        }
    }
    public String Menu() {
        System.out.println("What will be our next action?");
        System.out.println("- Move");
        System.out.println("- Info");
        System.out.println("- Save and Quit");
        System.out.print("Your choice: ");
        String movementSelect = Keyboard.readString().toLowerCase().trim();
        while (!(movementSelect.contains("move") || movementSelect.contains("info") || movementSelect.contains("save and quit"))) {
            System.err.println("Invalid option! Try again!");
            movementSelect = Keyboard.readString().toLowerCase().trim();
        }
        return movementSelect;

    }
    public String movementSelection() {
        System.out.println("What direction will we move?");
        System.out.println("- Up");
        System.out.println("- Down");
        System.out.print("Your choice: ");
        String movementDirection = Keyboard.readString().toLowerCase().trim();
        while (!(movementDirection.contains("up") || movementDirection.contains("down"))) {
            System.err.println("Invalid option! Try again!");
            movementDirection = Keyboard.readString().toLowerCase().trim();
        }
        return movementDirection;
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
    public String infoSelection() {
        System.out.println("What information do you want to see?");
        System.out.println("- Heroes");
        System.out.println("- Items");
        String infoChoice = Keyboard.readString().toLowerCase().trim();
        while (!(infoChoice.contains("heroes") || infoChoice.contains("items"))) {
            System.err.println("Invalid option! Try again!");
            infoChoice = Keyboard.readString().toLowerCase().trim();
        }
        return infoChoice;
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
