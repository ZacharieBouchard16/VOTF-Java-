//WIP - Untested
public class mainGame {

   static Overworld world = new Overworld();

    public static void main (String[] args) {
        switch (TitleScreen()) {
            case "new game" -> NewGame();
            case "continue" -> Continue();
            case "quit" -> {
                System.out.println("Quitting...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.exit(0);
                }
            }
        }
    }

    public static String TitleScreen() {
        String title = "Valley of the Forsaken";
        String space = "|" + " ".repeat(title.length() + 2) + "|";

        System.out.println("-".repeat(title.length() + 4));
        System.out.println(space);
        System.out.println("|" + " " + title + " " + "|");
        System.out.println(space);
        System.out.println("-".repeat(title.length() + 4) + "\n" + "\n");
        System.out.println("- New Game");
        System.out.println("- Continue (WIP)");
        System.out.println("- Quit");
        
        System.out.print("Your choice: ");
        String titleChoice = Keyboard.readString().toLowerCase().trim();
        while (!(titleChoice.contains("new game") || titleChoice.contains("continue") || titleChoice.contains("quit"))) {
            System.out.println("Invalid choice! Try again!");
            titleChoice = Keyboard.readString().toLowerCase().trim();
        }
        return titleChoice;
    }
    public static void NewGame() {
       world.startGame(); //I could shorten it and remove this but it felt better to keep it this way
    }
    public static void Continue() {
        //WorldMovement.worldSelection();
        System.out.println("Continue");
    }
}