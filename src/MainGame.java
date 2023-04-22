//WIP - Untested
public class MainGame {

   static Overworld world = new Overworld();

    public static void main (String[] args) {
        Prints.printTitleScreen();
        switch (Prints.choice("titleScreen")) {
            case "new game" -> NewGame();
            case "continue" -> Continue();
            case "quit" -> {
                System.out.println("Quitting...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.exit(1);
                }
            }
        }
    }
    public static void NewGame() {
       world.startGame(); //I could shorten it and put this line directly in the switch but this feels more comprehensible.
    }
    public static void Continue() {
        //WorldMovement.worldSelection();
        System.out.println("Continue");
    }
}