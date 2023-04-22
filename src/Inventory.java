public class Inventory {
    int potion;
    int revive;
    int defenseUp;
    int attackUp;
    int meteorCrash;

    public Inventory(int potion, int revive, int defenseUp, int attackUp, int meteorCrash) {
        this.potion = potion;
        this.revive = revive;
        this.defenseUp = defenseUp;
        this.attackUp = attackUp;
        this.meteorCrash = meteorCrash;
    }
    public void display() {
        System.out.println("- Potion: " + potion);
        System.out.println("- Revive: " + revive);
        System.out.println("- Defense-Up: " + defenseUp);
        System.out.println("- Attack-Up: " + attackUp);
        System.out.println("- Meteor Crash: " + meteorCrash);
    }
}
