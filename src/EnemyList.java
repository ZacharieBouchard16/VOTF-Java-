import java.util.Random;

public class EnemyList {
    Random rand = new Random();
    public Enemy grassEnemyList(int index) {
        Enemy enemy;
        switch (index) {
            case 0 -> {
                enemy = new Enemy(
                        "Slime",
                        rand.nextInt(11) + 40,
                        rand.nextInt(4) + 5,
                        rand.nextInt(2) + 3,
                        rand.nextInt(2) + 2,
                        rand.nextInt(2) + 3,
                        3
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Ram", 6 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Slime Drop", 20 + (enemy.intelligence / 3), 80, 8);}
            case 1 -> {
                enemy = new Enemy(
                        "Wolf",
                        rand.nextInt(11) + 50,
                        rand.nextInt(3) + 10,
                        0,
                        0,
                        rand.nextInt(6) + 10,
                        rand.nextInt(2) + 4
                );
                enemy.attack = new Attack[1];
                enemy.attack[0] = new Attack("Maul", 12 + (enemy.strength / 2), 95, 0);
            }
            case 2 -> {
                enemy = new Enemy(
                        "Fake Knight",
                        rand.nextInt(11) + 100,
                        rand.nextInt(3) + 12,
                        rand.nextInt(6) + 8,
                        rand.nextInt(2) + 1,
                        rand.nextInt(6) + 10,
                        rand.nextInt(3) + 4
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Slash", 10 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Strange Technique", 11 + (enemy.intelligence / 3), 75, 13);
            }
            case 3 -> {
                enemy = new Enemy(
                        "Maniac",
                        rand.nextInt(11) + 30,
                        rand.nextInt(6) + 25,
                        1,
                        0,
                        rand.nextInt(6) + 25,
                        rand.nextInt(3) + 10
                );
                enemy.attack = new Attack[1];
                enemy.attack[0] = new Attack("Assassinate", 20 + (enemy.strength / 2), 82, 0);
            }
            /*case 4 -> {
                enemy = new Enemy(
                        "Spider",
                        rand.nextInt(2) == 1 ? 88 : 80,
                        8,
                        8,
                        8,
                        8,
                        8
                );
            }*/
            default -> throw new IllegalStateException("Unexpected value: " + index);
        }
        return enemy;
    }
    public Enemy marshEnemyList(int index) {
        Enemy enemy;
        switch (index) {
            case 0 -> {
                enemy = new Enemy(
                        "Dark Slime",
                        rand.nextInt(21) + 80,
                        rand.nextInt(6) + 14,
                        rand.nextInt(4) + 10,
                        rand.nextInt(5) + 12,
                        rand.nextInt(4) + 8,
                        rand.nextInt(4) + 10
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Bash", 8 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Dark Slime Drop", 25 + (enemy.intelligence / 3), 85, 16);
            }
            case 1 -> {
                enemy = new Enemy(
                        "Mantis",
                        rand.nextInt(21) + 150,
                        rand.nextInt(6) + 10,
                        rand.nextInt(6) + 12,
                        rand.nextInt(4) + 6,
                        rand.nextInt(6) + 15,
                        1
                );
                enemy.attack = new Attack[3];
                enemy.attack[0] = new Attack("Slash", 10 + (enemy.strength / 2), 90, 0);
                enemy.attack[1] = new Attack("Spit", 15 + (enemy.intelligence / 3), 90, 10);
                enemy.attack[2] = new Attack("Consume", 30 + (enemy.strength / 2), 70, 40);
            }
            case 2 -> {
                enemy = new Enemy(
                        "Marsh Bird",
                        rand.nextInt(21) + 180,
                        rand.nextInt(8) + 13,
                        rand.nextInt(4) + 11,
                        rand.nextInt(4) + 10,
                        rand.nextInt(4) + 8,
                        3
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Peck", 14 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Divebomb", 30 + (enemy.intelligence / 3), 65, 30);
            }
            case 3 -> {
                enemy = new Enemy(
                        "Drowned",
                        rand.nextInt(21) + 90,
                        rand.nextInt(4) + 17,
                        rand.nextInt(4) + 1,
                        0,
                        rand.nextInt(8) + 30,
                        0
                );
                enemy.attack = new Attack[3];
                enemy.attack[0] = new Attack("Bite", 18 + (enemy.strength / 2), 90, 0);
                enemy.attack[1] = new Attack("Tidal Wave", 30 + (enemy.intelligence / 3), 70, 20);
                enemy.attack[2] = new Attack("Drown", 250, 15, 80);
            }
            /*case 4 -> {
                enemy = new Enemy(
                        "Mudman",
                        rand.nextInt(21) + 430,
                        rand.nextInt(4) + 15,
                        rand.nextInt(8) + 6,
                        rand.nextInt(4) + 9,
                        rand.nextInt(6),
                        2
                );
            }*/
            default -> throw new IllegalStateException("Unexpected value: " + index);
        }
        return enemy;
    }
    public Enemy volcanoEnemyList(int index) {
        Enemy enemy;
        switch (index) {
            case 0 -> {
                enemy = new Enemy(
                        "Volcano Slime",
                        rand.nextInt(31) + 160,
                        rand.nextInt(10) + 24,
                        rand.nextInt(6) + 12,
                        rand.nextInt(7) + 16,
                        rand.nextInt(6) + 12,
                        rand.nextInt(6) + 6
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Burn", 20 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Molten Slime Drop", 45 + (enemy.intelligence / 3), 85, 16);
            }
            case 1 -> {
                enemy = new Enemy(
                        "Kindred Spirit",
                        rand.nextInt(31) + 130,
                        rand.nextInt(6) + 15,
                        0,
                        rand.nextInt(6) + 12,
                        rand.nextInt(10) + 30,
                        rand.nextInt(6) + 5
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Fireball", 20 + (enemy.intelligence / 2), 100, 5);
                enemy.attack[1] = new Attack("Flaming Sorrows", 50 + (enemy.intelligence / 3), 85, 40);
            }
            case 2 -> {
                enemy = new Enemy(
                        "Firebender",
                        rand.nextInt(31) + 120,
                        rand.nextInt(6) + 20,
                        rand.nextInt(6) + 9,
                        rand.nextInt(7) + 11,
                        rand.nextInt(6) + 13,
                        rand.nextInt(6) + 9
                );
                enemy.attack = new Attack[3];
                enemy.attack[0] = new Attack("Torch", 27 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Ignite", 40 + (enemy.intelligence / 3), 85, 45);
                enemy.attack[2] = new Attack("Cremation", 70 + (enemy.intelligence / 3), 55, 70);
            }
            case 3 -> {
                enemy = new Enemy(
                        "Volcano Golem",
                        rand.nextInt(31) + 450,
                        rand.nextInt(6) + 15,
                        rand.nextInt(10) + 20,
                        rand.nextInt(6) + 14,
                        0,
                        rand.nextInt(6) + 10
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Squash", 25 + (enemy.strength / 2), 90, 5);
                enemy.attack[1] = new Attack("Flaming Sorrows", 50 + (enemy.intelligence / 3), 85, 40);
            }
            /*case 4 -> {
                enemy = new Enemy(
                        "Ignited",
                        rand.nextInt(31) + 240,
                        rand.nextInt(6) + 11,
                        rand.nextInt(6) + 11,
                        rand.nextInt(10) + 22,
                        rand.nextInt(6) + 8,
                        3
                );
            }*/
            default -> throw new IllegalStateException("Unexpected value: " + index);
        }
        return enemy;
    }
    public Enemy hellEnemyList(int index) {
        Enemy enemy;
        switch (index) {
            case 0 -> {
                enemy = new Enemy(
                        "Hell Slime",
                        rand.nextInt(41) + 250,
                        rand.nextInt(12) + 30,
                        rand.nextInt(8) + 24,
                        rand.nextInt(9) + 20,
                        rand.nextInt(8) + 20,
                        rand.nextInt(8) + 12
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Torch", 30 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Tormented Slime Drop", 60 + (enemy.intelligence / 3), 85, 25);
            }
            case 1 -> {
                enemy = new Enemy(
                        "\"Real\" Knight",
                        rand.nextInt(41) + 300,
                        rand.nextInt(9) + 15,
                        rand.nextInt(12) + 30,
                        0,
                        rand.nextInt(12) + 26,
                        rand.nextInt(9) + 12
                );
                enemy.attack = new Attack[3];
                enemy.attack[0] = new Attack("Stab", 30 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Forbidden Technique", 65 + (enemy.intelligence / 3), 85, 40);
                enemy.attack[2] = new Attack("Vorpal Slash", 80 + (enemy.strength / 2), 65, 0);
            }
            case 2 -> {
                enemy = new Enemy(
                        "Imp",
                        rand.nextInt(41) + 250,
                        rand.nextInt(8) + 20,
                        rand.nextInt(8) + 26,
                        rand.nextInt(12) + 40,
                        rand.nextInt(8) + 20,
                        rand.nextInt(8) + 14
                );
                enemy.attack = new Attack[2];
                enemy.attack[0] = new Attack("Stab", 30 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Fireball", 55 + (enemy.intelligence / 3), 85, 45);
            }
            case 3 -> {
                enemy = new Enemy(
                        "Damned Soul",
                        rand.nextInt(41) + 180,
                        rand.nextInt(8) + 18,
                        rand.nextInt(8) + 10,
                        rand.nextInt(9) + 11,
                        rand.nextInt(12) + 39,
                        rand.nextInt(8) + 13
                );
                enemy.attack = new Attack[3];
                enemy.attack[0] = new Attack("Scream", 20 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Curse", 30 + (enemy.intelligence / 3), 85, 37);
                enemy.attack[2] = new Attack("Haunting", 25 + (enemy.intelligence / 3), 90, 0);
            }
            /*case 4 -> {
                enemy = new Enemy(
                        "Demon Legionnaire",
                        rand.nextInt(41) + 290,
                        rand.nextInt(10) + 27,
                        rand.nextInt(10) + 25,
                        rand.nextInt(8) + 20,
                        rand.nextInt(8) + 28,
                        rand.nextInt(8) + 14
                );
            }*/
            default -> throw new IllegalStateException("Unexpected value: " + index);
        }
        return enemy;
    }
    public Enemy castleEnemyList(int index) {
        Enemy enemy;
        switch (index) {
            case 0 -> {
                enemy = new Enemy(
                        "Slime Armor",
                        rand.nextInt(51) + 500,
                        rand.nextInt(16) + 40,
                        rand.nextInt(10) + 38,
                        rand.nextInt(11) + 24,
                        rand.nextInt(10) + 20,
                        rand.nextInt(10) + 15
                );
                enemy.attack = new Attack[3];
                enemy.attack[0] = new Attack("Stab", 30 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Slime Wave", 85 + (enemy.intelligence / 3), 85, 60);
                enemy.attack[2] = new Attack("Dual-Vorpal Slash", 120 + (enemy.strength / 2), 65, 0);
            }
            case 1 -> {
                enemy = new Enemy(
                        "Hell Knight",
                        rand.nextInt(51) + 440,
                        rand.nextInt(11) + 34,
                        rand.nextInt(14) + 40,
                        rand.nextInt(10) + 38,
                        rand.nextInt(14) + 26,
                        rand.nextInt(11) + 17
                );
                enemy.attack = new Attack[3];
                enemy.attack[0] = new Attack("Impale", 50 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Ancient Technique", 65 + (enemy.intelligence / 3), 85, 60);
                enemy.attack[2] = new Attack("Vorpal Slash", 80 + (enemy.strength / 2), 65, 0);
            }
            case 2 -> {
                enemy = new Enemy(
                        "Demon Lord",
                        rand.nextInt(51) + 500,
                        rand.nextInt(8) + 22,
                        rand.nextInt(8) + 30,
                        rand.nextInt(12) + 50,
                        rand.nextInt(8) + 30,
                        rand.nextInt(8) + 19
                );
                enemy.attack = new Attack[4];
                enemy.attack[0] = new Attack("Slash", 50 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Deep Frost", 100 + (enemy.intelligence / 3), 90, 100);
                enemy.attack[2] = new Attack("Dark Inferno", 150 + (enemy.intelligence / 3), 70, 100);
                enemy.attack[3] = new Attack("Violent Thunder", 80 + (enemy.intelligence / 3), 80, 100);
            }
            case 3 -> {
                enemy = new Enemy(
                        "Avatar of Ernyel",
                        550,
                        45,
                        35,
                        31,
                        30,
                        30
                );
                enemy.attack = new Attack[4];
                enemy.attack[0] = new Attack("Slash", 10 + (enemy.strength / 2), 100, 0);
                enemy.attack[1] = new Attack("Fireball", 20 + (enemy.intelligence / 3), 90, 17);
                enemy.attack[2] = new Attack("Hell Slash", 27 + (enemy.strength / 2), 100, 10);
                enemy.attack[3] = new Attack("Flare Blast", 30 + (enemy.strength / 2), 80, 30);
            }
            /*case 4 -> {
                enemy = new Enemy(
                        "Wrath Lurker",
                        rand.nextInt(41) + 290,
                        rand.nextInt(16) + 27,
                        rand.nextInt(12) + 25,
                        rand.nextInt(10) + 14,
                        rand.nextInt(10) + 35,
                        rand.nextInt(10) + 14
                );
            }*/
            default -> throw new IllegalStateException("Unexpected value: " + index);
        }
        return enemy;
    }
    public Enemy bossList(int world) {
        Enemy boss;
        switch (world) {
            case 1 -> {
                boss = new Enemy(
                        "Ernyel",
                        550,
                        25,
                        15,
                        20,
                        10,
                        10
                );
                boss.attack = new Attack[4];
                boss.attack[0] = new Attack("Slash", 10 + (boss.strength / 2), 100, 0);
                boss.attack[1] = new Attack("Fireball", 20 + (boss.intelligence / 3), 90, 17);
                boss.attack[2] = new Attack("Hell Slash", 27 + (boss.strength / 2), 100, 20);
                boss.attack[3] = new Attack("Flare Blast", 30 + (boss.strength / 2), 80, 30);
            }
            case 2 -> {
                boss = new Enemy(
                        "Arrmethias",
                        770,
                        30,
                        25,
                        30,
                        18,
                        16
                );
                boss.attack = new Attack[4];
                boss.attack[0] = new Attack("Slash", 25 + (boss.strength / 2), 100, 0);
                boss.attack[1] = new Attack("Flare Dash", 38 + (boss.intelligence / 3), 100, 17);
                boss.attack[2] = new Attack("Hell Slash", 52 + (boss.strength / 2), 100, 20);
                boss.attack[3] = new Attack("Dark Inferno", 120 + (boss.intelligence / 3), 60, 50);
            }
            case 3 -> {
                boss = new Enemy(
                        "Flaxas",
                        1300,
                        50,
                        40,
                        65,
                        25,
                        20
                );
                boss.attack = new Attack[4];
                boss.attack[0] = new Attack("Flaming Slash", 30 + (boss.strength / 2), 100, 0);
                boss.attack[1] = new Attack("True Ignition", 60 + (boss.intelligence / 3), 80, 20);
                boss.attack[2] = new Attack("Molten Rock", 70 + (boss.intelligence / 3), 65, 35);
                boss.attack[3] = new Attack("Complete Ignition", 90 + (boss.intelligence / 3), 50, 50);
            }
            case 4 -> {
                boss = new Enemy(
                        "Entaeus",
                        2500,
                        75,
                        60,
                        0,
                        25,
                        25
                );
                boss.attack = new Attack[4];
                boss.attack[0] = new Attack("Hell Slash", 52 + (boss.strength / 2), 100, 0);
                boss.attack[1] = new Attack("Corkscrew Slash", 60 + (boss.strength / 2), 90, 0);
                boss.attack[2] = new Attack("Abyssal Slash", 70 + (boss.strength / 2), 100, 0);
                boss.attack[3] = new Attack("Eviscerate", 80 + (boss.strength / 2), 80, 0);
            }
            case 5 -> {
                boss = new Enemy(
                        "Bael",
                        5000,
                        90,
                        40,
                        115,
                        40,
                        30
                );
                boss.attack = new Attack[4];
                boss.attack[0] = new Attack("Wallop", 50 + (boss.strength / 2), 100, 0);
                boss.attack[1] = new Attack("Frostbite", 60 + (boss.intelligence / 3), 100, 20);
                boss.attack[2] = new Attack("Incinerate", 60 + (boss.intelligence / 2), 100, 20);
                boss.attack[3] = new Attack("Meteor Crash", 200 + (boss.strength / 2), 40, 0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + world);
        }
        return boss;
    }
}
